package zim_project.zim_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zim_project.zim_project.model.Notifications;
import zim_project.zim_project.repository.NotificationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // Return all notifications
    public List<Notifications> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Add a new notification
    public Notifications createNotification(Notifications notification) {
        return notificationRepository.save(notification);
    }

    // Return a single notification by ID
    public ResponseEntity<Notifications> getNotificationById(Long id) {
        Optional<Notifications> notification = notificationRepository.findById(id);
        return notification.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a notification by ID
    public Notifications updateNotification(Long id, Notifications notificationDetails) {
        return notificationRepository.findById(id).map(notification -> {
            notification.setCandidate(notificationDetails.getCandidate());
            notification.setEmailSent(notificationDetails.getEmailSent());
            notification.setMeetingInvite(notificationDetails.getMeetingInvite());
            return notificationRepository.save(notification);
        }).orElse(null);
    }

    // Delete a notification by ID
    public ResponseEntity<Void> deleteNotification(Long id) {
        Optional<Notifications> notification = notificationRepository.findById(id);

        if (notification.isPresent()) {
            notificationRepository.delete(notification.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
