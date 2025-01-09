package zim_project.zim_project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zim_project.zim_project.model.JobRoles;
import zim_project.zim_project.service.JobRoleService;

import java.util.List;

@RestController
@RequestMapping("/api/job-roles")
public class JobRoleController {

    @Autowired
    private JobRoleService jobRoleService;

    @GetMapping
    public ResponseEntity<List<JobRoles>> getAllJobRoles() {
        return ResponseEntity.ok(jobRoleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobRoles> getJobRoleById(@PathVariable Long id) {
        return jobRoleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<JobRoles> createJobRole(@RequestBody JobRoles jobRole) {
        return ResponseEntity.ok(jobRoleService.save(jobRole));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobRoles> updateJobRole(@PathVariable Long id, @RequestBody JobRoles jobRole) {
        return ResponseEntity.ok(jobRoleService.update(id, jobRole));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobRole(@PathVariable Long id) {
        jobRoleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}