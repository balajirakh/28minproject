package com.in28minutes.rest.webservices.restful_web_services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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

@SpringBootTest
class RestfulWebServicesApplicationTests {
	
	@InjectMocks
    private UserDaoService userService; // Assuming UserService is the class with the findAll method

    @Mock
    private List<User> mockUsers;

    @Test
    void testfindAll() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
        List<User> expectedUsers = Arrays.asList(
                new User(1, "balaji", LocalDate.now().minusYears(30)),
                new User(2, "gokul", LocalDate.now().minusYears(25)),
                new User(3, "ajay", LocalDate.now().minusYears(28)),
                new User(4, "vinay", LocalDate.now().minusYears(29))
        );

        when(mockUsers.size()).thenReturn(expectedUsers.size()); // Simulating the static list in mock
        when(userService.findAll()).thenReturn(expectedUsers);

        // Act
        List<User> actualUsers = userService.findAll();
        assertEquals(expectedUsers, actualUsers);
	
	
    }
}
	
	
	


