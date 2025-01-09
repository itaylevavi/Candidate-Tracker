package zim_project.zim_project.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reportsanalytics")
public class ReportsAnalytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportid")
    private Long reportid;

    @ManyToOne
    @JoinColumn(name = "candidateid", nullable = false)
    private Candidates candidate;

    @ManyToOne
    @JoinColumn(name = "stageid", nullable = false)
    private Stages stage;

    @Column(nullable = false)
    private LocalDateTime stagecompletiontime;

    @Column(nullable = false)
    private int conversionrate;

    public ReportsAnalytics(Candidates candidate, Stages stage, LocalDateTime stageCompletionTime,
                            int conversionRate) {
        super();
        this.candidate = candidate;
        this.stage = stage;
        this.stagecompletiontime = stageCompletionTime;
        this.conversionrate = conversionRate;
    }

    public ReportsAnalytics() {

    }

    public Long getReportID() {
        return reportid;
    }

    public void setReportID(Long reportID) {
        this.reportid = reportID;
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

    public LocalDateTime getStageCompletionTime() {
        return stagecompletiontime;
    }

    public void setStageCompletionTime(LocalDateTime stageCompletionTime) {
        this.stagecompletiontime = stageCompletionTime;
    }

    public int getConversionRate() {
        return conversionrate;
    }

    public void setConversionRate(int conversionRate) {
        this.conversionrate = conversionRate;
    }

    @Override
    public String toString() {
        return "ReportsAnalytics [reportID=" + reportid + ", stageCompletionTime=" + stagecompletiontime
                + ", conversionRate=" + conversionrate + "]";
    }
}