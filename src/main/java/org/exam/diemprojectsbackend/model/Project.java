package org.exam.diemprojectsbackend.model;

import jakarta.persistence.*;

@Entity
public class Project {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double estimatedTimeInHours;
    private double estimatedCost;

    public Project(double estimatedTimeInHours, double estimatedCost) {
        this.estimatedTimeInHours = estimatedTimeInHours;
        this.estimatedCost = estimatedCost;
    }

    public Project() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getEstimatedTimeInHours() {
        return estimatedTimeInHours;
    }

    public void setEstimatedTimeInHours(double estimatedTimeInHours) {
        this.estimatedTimeInHours = estimatedTimeInHours;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
}
