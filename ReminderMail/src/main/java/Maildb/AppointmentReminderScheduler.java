/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Maildb;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



public class AppointmentReminderScheduler {
   public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule the task to run every hour
        scheduler.scheduleAtFixedRate(() -> sendReminderEmails(), 0, 30, TimeUnit.SECONDS);
    }

    private static void sendReminderEmails() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        List<Appointment> appointmentsToRemind = (List<Appointment>) dbHandler.getAppointmentsToRemind();

        EmailSender emailSender = new EmailSender();
        for (Appointment appointment : appointmentsToRemind) {
            String subject = "Reminder: Your Appointment Tomorrow";
            String body = "Hello " + appointment.getFirstname() + ",\n\n" +
                          "This is a reminder of your appointment tomorrow at " +
                          appointment.getDatetime() + ".\n\n" +
                          "Best regards,\nYour Organization";

            emailSender.sendEmail(appointment.getEmail(), subject, body);
            
            // Mark the appointment as "reminder sent"
            dbHandler.markAppointmentAsReminderSent(appointment.getId());
        }
    }  
}
