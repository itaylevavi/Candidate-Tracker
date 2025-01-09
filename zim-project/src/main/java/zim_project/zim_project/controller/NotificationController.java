package zim_project.zim_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zim_project.zim_project.model.Notifications;
import zim_project.zim_project.service.NotificationService;

import java.util.List;


@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // GET: Return all notifications
    @GetMapping
    public List<Notifications> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    // POST: Add a new notification
    @PostMapping
    public Notifications createNotification(@RequestBody Notifications notification) {
        return notificationService.createNotification(notification);
    }

    // GET: Return a single notification by ID
    @GetMapping("/{id}")
    public ResponseEntity<Notifications> getNotificationById(@PathVariable Long id) {
        return notificationService.getNotificationById(id);
    }



    // DELETE: Delete a notification by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        return notificationService.deleteNotification(id);
    }
}
