package zim_project.zim_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zim_project.zim_project.model.InterviewSchedule;
import zim_project.zim_project.service.InterviewSchedulesService;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewSchedulesController {

    @Autowired
    private InterviewSchedulesService interviewScedulesService;

    @GetMapping
    public ResponseEntity<List<InterviewSchedule>> getInterviewSchedules() {
        List<InterviewSchedule> schedules = interviewScedulesService.getAllInterviewSchedules(); // קריאה לשירות
        return ResponseEntity.ok(schedules); // החזרת הרשימה בתגובה בפורמט JSON
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterviewSchedule> getInterviewScheduleById(@PathVariable Long id) {
        // קריאה לשירות כדי לשלוף את הרשומה לפי ID
        InterviewSchedule schedule = interviewScedulesService.getInterviewScheduleById(id);

        if (schedule != null) {
            return ResponseEntity.ok(schedule); // מחזיר את הרשומה עם סטטוס OK (200)
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // אם לא נמצא, מחזיר סטטוס NOT FOUND (404)
        }



    }
    @PostMapping
    public ResponseEntity<InterviewSchedule> createInterviewSchedule(@RequestBody InterviewSchedule newSchedule) {
        // קריאה לשירות כדי ליצור רשומה חדשה
        InterviewSchedule createdSchedule = interviewScedulesService.createInterviewSchedule(newSchedule);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchedule); // מחזיר את הרשומה החדשה עם סטטוס CREATED (201)
    }
}
