package zim_project.zim_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zim_project.zim_project.model.JobRoles;
import zim_project.zim_project.repository.JobRoleRepository;
import java.util.List;
import java.util.Optional;

@Service
public class JobRoleService {

    @Autowired
    private JobRoleRepository jobRoleRepository;

    public List<JobRoles> findAll() {
        return jobRoleRepository.findAll();
    }

    public Optional<JobRoles> findById(Long id) {
        return jobRoleRepository.findById(id);
    }

    public JobRoles save(JobRoles jobRole) {
        return jobRoleRepository.save(jobRole);
    }

    public JobRoles update(Long id, JobRoles jobRole) {
        Optional<JobRoles> existingJobRole = jobRoleRepository.findById(id);
        if (existingJobRole.isPresent()) {
            jobRole.setJobRoleID(id);
            return jobRoleRepository.save(jobRole);
        } else {
            throw new RuntimeException("JobRole not found with ID: " + id);
        }
    }

    public void delete(Long id) {
        if (jobRoleRepository.existsById(id)) {
            jobRoleRepository.deleteById(id);
        } else {
            throw new RuntimeException("JobRole not found with ID: " + id);
        }
    }
}