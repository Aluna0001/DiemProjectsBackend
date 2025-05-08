package org.exam.diemprojectsbackend.model;


import jakarta.persistence.*;


@Entity
public class SubTask {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String subProjectTitle;
    private String projectDescription;

    public SubTask() {

    }

    public SubTask(long id, String subProjectTitle, String projectDescription) {
        this.id = id;
        this.subProjectTitle = subProjectTitle;
        this.projectDescription = projectDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubProjectTitle() {
        return subProjectTitle;
    }

    public void setSubProjectTitle(String subProjectTitle) {
        this.subProjectTitle = subProjectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
}
