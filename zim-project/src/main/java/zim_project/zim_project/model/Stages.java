package zim_project.zim_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stages")
public class Stages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stageid;

    @Column(name = "name")
    private String name;

    public Long getStageId() {
        return stageid;
    }
    public void setStageId(Long stageId) {
        this.stageid=stageId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}