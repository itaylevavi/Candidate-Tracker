package zim_project.zim_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zim_project.zim_project.model.Stages;
import zim_project.zim_project.repository.StageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StageService {

    @Autowired
    private StageRepository stageRepository;

    // Create or Update Stage
    @Transactional
    public Stages saveStage(Stages stage) {
        // Add validation or business logic here if needed
        return stageRepository.save(stage);
    }

    // Get all stages
    public List<Stages> getAllStages() {
        return stageRepository.findAll();
    }

    // Get a stage by ID
    public Optional<Stages> getStageById(Long id) {
        return stageRepository.findById(id);
    }

    // Delete a stage by ID
    @Transactional
    public void deleteStage(Long id) {
        stageRepository.deleteById(id);
    }
}