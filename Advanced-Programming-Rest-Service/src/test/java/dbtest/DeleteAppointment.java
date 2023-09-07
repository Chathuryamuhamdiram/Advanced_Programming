/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbtest;
import dbp.ViewAppointmentUtils;
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
public class DeleteAppointment {
    private ViewAppointmentUtils viewAppointmentUtils;

    public DeleteAppointment() {
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
        viewAppointmentUtils = new ViewAppointmentUtils();
    }

    @AfterEach
    public void tearDown() {
        // Clean up resources after each test
    }

    @Test
    public void testGetAllJobSeekers() {
        System.out.println("testGetAllJobSeekers");

        // Perform the getAllJobSeekers operation
        int numberOfJobSeekers = viewAppointmentUtils.getAllJobSeekers().size();

        // Assuming you have some expected number of job seekers, e.g., 5
        assertEquals(5, numberOfJobSeekers);
    }

    @Test
    public void testDeleteJobSeeker() {
        System.out.println("testDeleteJobSeeker");

        int userIdToDelete = 1;

        // Perform the deleteJobSeeker operation
        boolean result = viewAppointmentUtils.deleteJobSeeker(userIdToDelete);

        assertTrue(result);
    } 
}
