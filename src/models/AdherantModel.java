package models;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PC
 */
public class AdherantModel {
    private int idAdherant;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String associatedProgram;
    private Date subScriptionStart;
    private final Date subScriptionEnd;
    
    public AdherantModel(int id, String name,String email, String password,String phoneNumber,String associatedProgram ,Date subScriptionStart ,Date subScriptionEnd) {
        this.idAdherant = id;
        this.name = name;

        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.associatedProgram = associatedProgram;
        this.subScriptionStart = subScriptionStart;
        this.subScriptionEnd = subScriptionEnd;
    }
    
    // Constructor without subscriptionEnd → optional, default calculated
    public AdherantModel(int id, String name, String email, String password, String phoneNumber, String associatedProgram,Date subScriptionStart) {
        this(id, name, email, password, phoneNumber, associatedProgram,subScriptionStart,calculateSubscriptionEnd(associatedProgram,subScriptionStart));
    }

    // Getters ========================================
        public int getIdAdherant() { return idAdherant; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getPassword() { return password; }
        public String getPhoneNumber() { return phoneNumber; }
        public String getAssociatedProgram() { return associatedProgram; }
        public Date getSubScriptionStart() { return subScriptionStart; }
        public Date getSubScriptionEnd() { return subScriptionEnd; }
    // ==================================================

    // setters===========================================
        public void setIdAdherant(int idAdherant) { this.idAdherant = idAdherant; }
        public void setName(String name) { this.name = name; }
        public void setEmail(String email) { this.email = email; }
        public void setPassword(String password) { this.password = password; }
        public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
        public void setSubScriptionStart(Date subScriptionStart) { this.subScriptionStart = subScriptionStart; }
        public void setAssociatedProgram(String associatedProgram) { this.associatedProgram = associatedProgram; }
    // ==================================================
    
    // Must be static to call from constructor
    private static Date calculateSubscriptionEnd(String program,Date subScriptionStart) {
        int monthsToAdd = 0;
        if (program != null && program.contains(" ")) {
            try {
                monthsToAdd = Integer.parseInt(program.split(" ")[0]);
            } catch (NumberFormatException e) {
                monthsToAdd = 1;
            }
        }
        // Convert start Date → LocalDate
        LocalDate startDate = subScriptionStart.toLocalDate();

        // Add months to START date (not today)
        LocalDate endDate = startDate.plusMonths(monthsToAdd);

        // Convert LocalDate to java.sql.Date
        return java.sql.Date.valueOf(endDate);
    }

}
