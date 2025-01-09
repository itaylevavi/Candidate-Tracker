package zim_project.zim_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidates {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "candidateid")
    private Long candidateid;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @ManyToOne
    @JoinColumn(name = "position", referencedColumnName = "jobroleid", nullable = false)
    private JobRoles position;

    @ManyToOne
    @JoinColumn(name = "team", referencedColumnName = "teamid", nullable = false)
    private Teams team;

    @ManyToOne
    @JoinColumn(name = "location", referencedColumnName = "locationid", nullable = false)
    private Locations location;

    // Constructors
    public Candidates() {}

    public Candidates(String name, String email, JobRoles position, Teams teams, Locations location) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.team = teams;
        this.location = location;
    }

    public Long getId() {
        return candidateid;
    }

    public void setId(Long id) {
        this.candidateid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JobRoles getPosition() {
        return position;
    }

    public void setPosition(JobRoles position) {
        this.position = position;
    }

    public Teams getTeam() {
        return team;
    }

    public void setTeam(Teams teams) {
        this.team = teams;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }
}
