/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author PC
 */
public class ActivityModel {
    private int idAct;
    private String title;
    private String description;
    private Date activityDate;
    private Time startTime;
    private Time endTime;
    private int  idCoach;
    private int  idAdmin;

    public ActivityModel(int id, String title, String description, 
                    Date activityDate,
                    Time startTime, Time endTime,
                    int idCoach,int idAdmin) {
        this.idAct = id;
        this.title = title;
        this.description = description;
        this.activityDate = activityDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.idCoach = idCoach;
        this.idAdmin = idAdmin;
    }

    // Getters ========================================
        public int getIdAct() { return idAct; }
        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public Date getActivityDate() { return activityDate; }
        public Time getStartTime() { return startTime; }
        public Time getEndTime() { return endTime; }
        public int getIdCoach() { return idCoach; }
        public int getIdAdmin() { return idAdmin; }
    // ==================================================

    // setters===========================================
        public void setIdAct(int idAct) { this.idAct = idAct; }
        public void setTitle(String title) { this.title = title; }
        public void setDescription(String description) { this.description = description; }
        public void setActivityDate(Date activityDate) { this.activityDate = activityDate; }
        public void setStartTime(Time startTime) { this.startTime = startTime; }
        public void setEndTime(Time endTime) { this.endTime = endTime; }
        public void setIdCoach(int idCoach) { this.idCoach = idCoach; }
        public void setIdAdmin(int idAdmin) { this.idAdmin = idAdmin; }
    // ==================================================

}
