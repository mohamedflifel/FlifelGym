package models;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */


public class CoachModel {
    private int idCoach;
    private String speciality;
    private String name;
    private String email;
    private String password;
    public  CoachModel(int id, String name,String email, String password,String speciality) {
        this.idCoach = id;
        this.name = name;
        this.speciality = speciality;
        this.email = email;
        this.password = password;
    }

    // Getters ========================================
        public int getIdCoach() { return idCoach; }
        public String getSpeciality() { return speciality; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getPassword() { return password; }

    // ==================================================

    // setters===========================================
        public void setIdCoach(int idCoach) { this.idCoach = idCoach; }
        public void setSpeciality(String speciality) { this.speciality = speciality; }
        public void setName(String name) { this.name = name; }
        public void setEmail(String email) { this.email = email; }
        public void setPassword(String password) { this.password = password; }
    // ==================================================

}
