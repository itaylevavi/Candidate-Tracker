package zim_project.zim_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zim_project.zim_project.model.ReportsAnalytics;
import zim_project.zim_project.service.ReportsAnalyticsService;


import java.util.List;

@RestController
@RequestMapping("/api/reports-analystics")
public class ReportsAnalyticsController {

    @Autowired
    private ReportsAnalyticsService reportsAnalyticsService;

    @GetMapping
    public ResponseEntity<List<ReportsAnalytics>> getAllReportsAnalytics() {
        return ResponseEntity.ok(reportsAnalyticsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportsAnalytics> getReportsAnalyticsById(@PathVariable Long id) {
        return reportsAnalyticsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReportsAnalytics> createReportsAnalytics(@RequestBody ReportsAnalytics reportsAnalytics) {
        return ResponseEntity.ok(reportsAnalyticsService.save(reportsAnalytics));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportsAnalytics> updateReportsAnalytics(@PathVariable Long id, @RequestBody ReportsAnalytics reportsAnalytics) {
        return ResponseEntity.ok(reportsAnalyticsService.update(id, reportsAnalytics));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReportsAnalytics(@PathVariable Long id) {
        reportsAnalyticsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}