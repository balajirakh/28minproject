package com.in28minutes.rest.webservices.restful_web_services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28minutes.rest.webservices.restful_web_services.user.User;
import com.in28minutes.rest.webservices.restful_web_services.user.UserDaoService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserDaoServiceTest {
	@InjectMocks
	UserDaoService userService;

	@Mock
	private List<User> mockUsers;
	
//	@Test
//  void testfindAll() {
//       
//
//        // Arrange
//        List<User> expectedUsers = Arrays.asList(
//                new User(1, "balaji", LocalDate.now().minusYears(30)),
//                new User(2, "gokul", LocalDate.now().minusYears(25)),
//                new User(3, "ajay", LocalDate.now().minusYears(28)),
//                new User(4, "vinay", LocalDate.now().minusYears(29))
//        );
//        when(mockUsers.size()).thenReturn(expectedUsers.size()); // Simulating the static list in mock
//        when(userService.findAll()).thenReturn(expectedUsers);
//
//        // Act
//        List<User> actualUsers = userService.findAll();
//
//        // Assert
//        assertEquals(expectedUsers, actualUsers);
//	}
//
	@Test
	void testgetUser() {
		MockitoAnnotations.openMocks(this); // Initialize mocks

		// Arrange
		List<User> users = Arrays.asList(new User(1, "balaji", LocalDate.now().minusYears(30)),
				new User(2, "gokul", LocalDate.now().minusYears(25)),
				new User(3, "ajay", LocalDate.now().minusYears(28)));
		when(mockUsers.stream()).thenReturn(users.stream());

		// Act
		User user = userService.getUserById(2); // Retrieve user with ID 2

		// Assert
		assertEquals("gokul", user.getName());
		assertEquals(2, user.getId());
	}

}
