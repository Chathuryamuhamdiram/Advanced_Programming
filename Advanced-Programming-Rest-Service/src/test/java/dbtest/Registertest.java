/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbtest;

import com.mycompany.advanced.programming.rest.service.resources.RegisterResource;
import dbp.Login;
import dbp.LoginUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author User
 */
public class Registertest {
    public Registertest() {
    }

    @BeforeAll
    public static void setUpClass() {
        // Set up any resources or configurations before all tests
    }

    @AfterAll
    public static void tearDownClass() {
        // Clean up resources after all tests are done
    }

    @BeforeEach
    public void setUp() {
        // Set up any necessary objects or states before each test
    }

    @AfterEach
    public void tearDown() {
        // Clean up resources after each test
    }

    /**
     * Test successful user registration.
     */
    @Test
    public void testSuccessfulUserRegistration() {
        System.out.println("testSuccessfulUserRegistration");

        // Create a new Login object for registration
        Login addUser = new Login(1,"newuser@example.com", "newpassword", "New", "User", "user", "1990-01-01", "1234567890");

        // Create an instance of LoginUtils
        LoginUtils loginUtils = new LoginUtils();

        // Create an instance of RegisterResource
        RegisterResource registerResource = new RegisterResource();

        // Convert the newUser object to JSON
        String newUserJson = "{\"email\":\"newuser@example.com\",\"password\":\"newpassword\",\"firstname\":\"New\",\"lastname\":\"User\",\"user\":\"user\",\"dob\":\"1990-01-01\",\"phonenumber\":\"1234567890\"}";

        // Call the addUser method and get the Response status code
        int statusCode = registerResource.addUser(newUserJson).getStatus();

        // Check if the user registration was successful (status code 201)
        assertEquals(201, statusCode);

       
    }

    /**
     * Test user registration failure.
     */
    @Test
    public void testUserRegistrationFailure() {
        System.out.println("testUserRegistrationFailure");

        // Create an instance of RegisterResource
        RegisterResource registerResource = new RegisterResource();

        // Create an invalid JSON string (missing required fields)
        String invalidJson = "{\"email\":\"newuser@example.com\"}";

        // Call the addUser method and get the Response status code
        int statusCode = registerResource.addUser(invalidJson).getStatus();

        // Check if the user registration failed (status code 500)
        assertEquals(500, statusCode);
    }
}
