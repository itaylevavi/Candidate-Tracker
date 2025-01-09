package zim_project.zim_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zim_project.zim_project.model.Stages;
import zim_project.zim_project.service.StageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stages")
public class StageController {

    @Autowired
    private StageService stageService;

    @GetMapping
    public ResponseEntity<List<Stages>> getAllStages() {
        List<Stages> stages = stageService.getAllStages();
        return ResponseEntity.ok(stages);
    }

    // Get a specific stage by ID
    @GetMapping("/{id}")
    public ResponseEntity<Stages> getStageById(@PathVariable Long id) {
        Optional<Stages> stage = stageService.getStageById(id);
        if (stage.isPresent()) {
            return ResponseEntity.ok(stage.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
