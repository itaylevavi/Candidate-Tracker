package zim_project.zim_project.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import zim_project.zim_project.model.ReportsAnalytics;
import zim_project.zim_project.repository.ReportAnalyticsRepository;


import java.util.List;
import java.util.Optional;

@Service
public class ReportsAnalyticsService {

    @Autowired
    private ReportAnalyticsRepository reportsAnalyticsRepository;

    public List<ReportsAnalytics> findAll() {
        return reportsAnalyticsRepository.findAll();
    }

    public Optional<ReportsAnalytics> findById(Long id) {
        return reportsAnalyticsRepository.findById(id);
    }

    public ReportsAnalytics save(ReportsAnalytics reportsAnalytics) {
        return reportsAnalyticsRepository.save(reportsAnalytics);
    }

    public ReportsAnalytics update(Long id, ReportsAnalytics reportsAnalytics) {
        if (reportsAnalyticsRepository.existsById(id)) {
            reportsAnalytics.setReportID(id);
            return reportsAnalyticsRepository.save(reportsAnalytics);
        }
        throw new RuntimeException("ReportsAnalytics not found with ID: " + id);
    }

    public void delete(Long id) {
        if (reportsAnalyticsRepository.existsById(id)) {
            reportsAnalyticsRepository.deleteById(id);
        } else {
            throw new RuntimeException("ReportsAnalytics not found with ID: " + id);
        }
    }
}