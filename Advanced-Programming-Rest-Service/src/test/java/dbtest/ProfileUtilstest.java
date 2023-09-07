/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbtest;
import dbp.ProfileUtils;
import dbp.Profile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author User
 */
public class ProfileUtilstest {
    @Test
    public void testAddProfile() {
        ProfileUtils profileUtils = new ProfileUtils();

        String firstname = "John";
        String lastname = "Doe";
        String dob = "1990-01-01";
        String address = "123 Main St";
        String email = "john@example.com";
        String phonenumber = "0773457890";
        String job = "Engineer";
        String education = "Bachelor's Degree";
        int userId = 1;

        boolean result = profileUtils.addProfile(firstname, lastname, dob, address, email, phonenumber, job, education, userId);

        assertTrue(result);
    }

    @Test
    public void testGetAllProfiles() {
        ProfileUtils profileUtils = new ProfileUtils();

        int userId = 1; // Assuming this user has profiles

        List<Profile> profiles = profileUtils.getAllProfiles(userId);

        assertFalse(profiles.isEmpty());

        // You can add more assertions based on your expected results
        for (Profile profile : profiles) {
            assertNotNull(profile.getFirstname());
            assertNotNull(profile.getLastname());
            assertNotNull(profile.getDob());
            assertNotNull(profile.getAddress());
            assertNotNull(profile.getEmail());
            assertNotNull(profile.getPhonenumber());
            assertNotNull(profile.getJob());
            assertNotNull(profile.getEducation());
        }
    }
}
