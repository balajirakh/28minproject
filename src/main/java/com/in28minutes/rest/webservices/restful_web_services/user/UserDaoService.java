package com.in28minutes.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;

	static {
		users.add(new User(++userCount, "balaji", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "gokul", LocalDate.now().minusYears(25)));
		users.add(new User(++userCount, "ajay", LocalDate.now().minusYears(28)));
		users.add(new User(++userCount, "vinay", LocalDate.now().minusYears(29)));

	}

	// to find all users

	public List<User> findAll() {
		return users;

	}

	// To find Single User

	public User getUserById(Integer id) {

		Predicate<User> predicate = user -> user.getId().equals(id);

		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public void deleteUserById(Integer id) {

		Predicate<User> predicate = user -> user.getId().equals(id);

		users.removeIf(predicate);
	}

	public User saveUser(User user) {

		user.setId(++userCount);
		users.add(user);
		return user;

	}

}
