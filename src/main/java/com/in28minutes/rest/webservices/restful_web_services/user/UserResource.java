package com.in28minutes.rest.webservices.restful_web_services.user;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restful_web_services.exceptions.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> getAllUsers() {

		return service.findAll();
	}

	// entity model is use for the create a links.
	//WebMvcLinkBuilder is used for create link.

	@GetMapping("/user/{id}")
	public EntityModel<User> getUsers(@PathVariable Integer id) {

		User user = service.getUserById(id);
		if (user == null)
			throw new UserNotFoundException("User not found with id:" + id);

		EntityModel<User> entityModel = EntityModel.of(user);
		
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getAllUsers());

		entityModel.add(link.withRel("all-users"));
		
		return entityModel;

	}

	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Integer id) {

		service.deleteUserById(id);
		return ("user deleted Sussecfully with id" + " : " + id);

	}

	@PostMapping("/save-user")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		User saveUser = service.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
