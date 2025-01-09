package zim_project.zim_project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interviewschedules")
public class InterviewSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scheduleid")
    private Long scheduleid;

    @ManyToOne
    @JoinColumn(name = "candidateid", nullable = false)
    private Candidates candidateid;

    @ManyToOne
    @JoinColumn(name = "stage", nullable = false)
    private Stages stage;

    @Column(name ="scheduleddatetime",nullable = false)
    private LocalDateTime scheduleddatetime;

    @Column(name = "meetingacceptedstatus",nullable = false, length = 20)
    private String meetingacceptedstatus;

    // Constructors
    public InterviewSchedule() {}

    public InterviewSchedule(Candidates candidate, Stages stage, LocalDateTime scheduledDateTime, String meetingAcceptedStatus) {
        this.candidateid = candidate;
        this.stage = stage;
        this.scheduleddatetime = scheduledDateTime;
        this.meetingacceptedstatus = meetingAcceptedStatus;
    }

    // Getters and Setters
    public Long getScheduleID() {
        return scheduleid;
    }

    public void setScheduleID(Long scheduleID) {
        this.scheduleid = scheduleID;
    }

    public Candidates getCandidate() {
        return candidateid;
    }

    public void setCandidate(Candidates candidate) {
        this.candidateid = candidate;
    }

    public Stages getStage() {
        return stage;
    }

    public void setStage(Stages stage) {
        this.stage = stage;
    }

    public LocalDateTime getScheduledDateTime() {
        return scheduleddatetime;
    }

    public void setScheduledDateTime(LocalDateTime scheduledDateTime) {
        this.scheduleddatetime = scheduledDateTime;
    }

    public String getMeetingAcceptedStatus() {
        return meetingacceptedstatus;
    }

    public void setMeetingAcceptedStatus(String meetingAcceptedStatus) {
        this.meetingacceptedstatus = meetingAcceptedStatus;
    }
}
