package org.exam.diemprojectsbackend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class SubProject {
    @Id
    @Column(name = "subproject_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String subProjectTitle;
    private String subProjectDescription;

    @ManyToOne
    @JoinColumn(name = "project_id") // Så kolonnen i databasen kommer til at hedde "project_id"
    private Project project;

    @OneToMany(mappedBy = "subProject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
