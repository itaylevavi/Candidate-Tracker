package zim_project.zim_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zim_project.zim_project.service.ProgressTrackingService;

@RestController
@RequestMapping("/api/tracking")
public class ProgressTrackingController {

    @Autowired
    private ProgressTrackingService progressTrackingService;


}
