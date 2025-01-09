package zim_project.zim_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "progresstracking")
public class ProgressTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progressid")
    private Long progressid;

    @ManyToOne
    @JoinColumn(name = "candidateid", nullable = false)
    private Candidates candidate;

    @ManyToOne
    @JoinColumn(name = "stageid", nullable = false)
    private Stages stage;

    @Column(nullable = false, length = 30)
    private String stagestatus;

    @Column(nullable = false, length = 500)
    private String commentsfeedback;

    @Column(nullable = false, length = 20)
    private String finaldecision;

    // Constructors
    public ProgressTracking() {}

    public ProgressTracking(Candidates candidate, Stages stage, String stageStatus, String commentsFeedback, String finalDecision) {
        this.candidate = candidate;
        this.stage = stage;
        this.stagestatus = stageStatus;
        this.commentsfeedback = commentsFeedback;
        this.finaldecision = finalDecision;
    }

    // Getters and Setters
    public Long getProgressID() {
        return progressid;
    }

    public void setProgressID(Long progressID) {
        this.progressid = progressID;
    }

    public Candidates getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidates candidate) {
        this.candidate = candidate;
    }

    public Stages getStage() {
        return stage;
    }

    public void setStage(Stages stage) {
        this.stage = stage;
    }

    public String getStageStatus() {
        return stagestatus;
    }

    public void setStageStatus(String stageStatus) {
        this.stagestatus = stageStatus;
    }

    public String getCommentsFeedback() {
        return commentsfeedback;
    }

    public void setCommentsFeedback(String commentsFeedback) {
        this.commentsfeedback = commentsFeedback;
    }

    public String getFinalDecision() {
        return finaldecision;
    }

    public void setFinalDecision(String finalDecision) {
        this.finaldecision = finalDecision;
    }
}