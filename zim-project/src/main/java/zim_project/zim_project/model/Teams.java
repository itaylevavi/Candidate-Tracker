package zim_project.zim_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamid")
    private Long teamid;

    @Column(name = "name", nullable = false, length=100)
    private String name;

    public Long getTeamID() {
        return teamid;
    }

    public void setTeamID(Long teamID) {
        this.teamid = teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

