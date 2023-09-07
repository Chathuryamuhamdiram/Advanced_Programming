/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbtest;
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
public class loginutilstest {
    public loginutilstest() {
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
     * Test successful login with correct email and password.
     */
    @Test
    public void testSuccessfulLogin() {
        System.out.println("testSuccessfulLogin");

        String email = "abc";
        String password = "123";

          Login login = new Login( "abc", "123");
        // Create an instance of LoginUtils
        LoginUtils loginUtils = new LoginUtils();

        // Perform the login operation
        boolean result = loginUtils.loginUser(email, password) != null;

        assertTrue(result);
    }

    /**
     * Test login with incorrect password.
     */
    @Test
    public void testIncorrectPassword() {
        System.out.println("testIncorrectPassword");

        String email = "abc";
        String incorrectPassword = "wrongpassword";

        LoginUtils loginUtils = new LoginUtils();
        boolean result = loginUtils.loginUser(email, incorrectPassword) != null;

        assertFalse(result);
    }

    /**
     * Test login with non-existent email.
     */
    @Test
    public void testNonExistentEmail() {
        System.out.println("testNonExistentEmail");

        String nonExistentEmail = "";
        String password = "password";

        LoginUtils loginUtils = new LoginUtils();
        boolean result = loginUtils.loginUser(nonExistentEmail, password) != null;

        assertFalse(result);
    }
}
