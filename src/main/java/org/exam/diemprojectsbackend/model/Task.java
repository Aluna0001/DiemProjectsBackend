package org.exam.diemprojectsbackend.model;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double estimatedTime;
    private double spentTime;
    private double estimatedCost;
    private double spentCost;
    private String status;

    public Task() {

    }
  //skal lige høre om id skal være i constructeren
    public Task(Long id, String title, String description, double estimatedTime, double spentTime, double estimatedCost, double spentCost, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.spentTime = spentTime;
        this.estimatedCost = estimatedCost;
        this.spentCost = spentCost;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(double estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public double getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(double spentTime) {
        this.spentTime = spentTime;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public double getSpentCost() {
        return spentCost;
    }

    public void setSpentCost(double spentCost) {
        this.spentCost = spentCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
