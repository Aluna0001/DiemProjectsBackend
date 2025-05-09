package org.exam.diemprojectsbackend.model;


import jakarta.persistence.*;


@Entity
public class SubProject {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String subProjectTitle;
    private String subProjectDescription;

    public SubProject() {

    }

    public SubProject(long id, String subProjectTitle, String subProjectDescription) {
        this.id = id;
        this.subProjectTitle = subProjectTitle;
        this.subProjectDescription = subProjectDescription;
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

    public String getSubProjectDescription() {
        return subProjectDescription;
    }

    public void setSubProjectDescription(String subProjectDescription) {
        this.subProjectDescription = subProjectDescription;
    }
}
