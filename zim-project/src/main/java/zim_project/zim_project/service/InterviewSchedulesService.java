package zim_project.zim_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zim_project.zim_project.model.InterviewSchedule;
import zim_project.zim_project.repository.InterviewSchedulesRepository;

import java.util.List;

@Service
public class InterviewSchedulesService  {

    @Autowired
    private InterviewSchedulesRepository repository;

    public List<InterviewSchedule> getAllInterviewSchedules() {
        return repository.findAll();
    }

    public InterviewSchedule getInterviewScheduleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public InterviewSchedule createInterviewSchedule(InterviewSchedule schedule) {
        // שמירת הרשומה בבסיס הנתונים
        return repository.save(schedule);
    }
}
