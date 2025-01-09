package zim_project.zim_project.model;

import jakarta.persistence.*;

// JobRoles Entity
@Entity
@Table(name = "jobroles")
public class JobRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobroleid", nullable = false)
    private Long jobroleid;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    public JobRoles(Long id, String name) {
        this.jobroleid = id;
        this.name = name;
    }

    public JobRoles() {

    }

    public Long getJobRoleID() {
        return jobroleid;
    }

    public String getName() {
        return name;
    }

    public void setJobRoleID(Long newJobRoleID) {
        this.jobroleid = newJobRoleID;
    }

    public void setName(String newName) {
        this.name = newName;
    }


    public String toString() {
        return "JobRoles [jobRoleID=" + jobroleid + ", name=" + name + "]";
    }
}