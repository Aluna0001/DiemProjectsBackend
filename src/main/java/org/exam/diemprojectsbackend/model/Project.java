package org.exam.diemprojectsbackend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Project {
    @Id
    @Column(name = "project_id") // Dette ændrer SQL-navnet men beholder "id" i Java
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String projectTitle;
    private String projectDescription;
    private double budget;
    private LocalDate startDate;
    private LocalDate endDate;



    public Project() {
    }

    public Project(long id, String projectTitle, String projectDescription, double budget, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.projectTitle = projectTitle;
        this.projectDescription = projectDescription;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
