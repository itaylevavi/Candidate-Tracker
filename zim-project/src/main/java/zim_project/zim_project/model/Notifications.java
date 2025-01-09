package zim_project.zim_project.model;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
    @Entity
    @Table(name = "notifications")
    public class Notifications {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long notificationid;

        @ManyToOne
        @JoinColumn(name = "candidateid", nullable = false)
        private Candidates candidates;

        @Column(nullable = false)
        private String emailsent;

        @Column(nullable = false)
        private String meetinginvite;

        // Constructors
        public Notifications() {}

        public Notifications(Candidates candidate, String emailSent, String meetingInvite) {
            this.candidates = candidate;
            this.emailsent = emailSent;
            this.meetinginvite = meetingInvite;
        }

        // Getters and Setters
        public Long getNotificationID() {
            return notificationid;
        }

        public void setNotificationID(Long notificationID) {
            this.notificationid = notificationID;
        }

        public Candidates getCandidate() {
            return candidates;
        }

        public void setCandidate(Candidates candidate) {
            this.candidates = candidate;
        }

        public String getEmailSent() {
            return emailsent;
        }

        public void setEmailSent(String emailSent) {
            this.emailsent = emailSent;
        }

        public String getMeetingInvite() {
            return meetinginvite;
        }

        public void setMeetingInvite(String meetingInvite) {
            this.meetinginvite = meetingInvite;
        }
    }


