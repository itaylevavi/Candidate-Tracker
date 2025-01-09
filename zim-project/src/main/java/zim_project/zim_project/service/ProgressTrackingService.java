package zim_project.zim_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zim_project.zim_project.repository.ProgressTrackingRepository;

@Service
public class ProgressTrackingService {

    @Autowired
    private ProgressTrackingRepository progressTrackingRepository;
}
