package zim_project.zim_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zim_project.zim_project.model.Candidates;
import zim_project.zim_project.repository.CandidateProjection;
import zim_project.zim_project.repository.CandidatesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

    @Autowired
    private CandidatesRepository candidatesRepository;


    public ResponseEntity<List<Candidates>> getCandidates() {
        return ResponseEntity.ok(candidatesRepository.findAll());
    }
    // Get all candidates
    @GetMapping
    public ResponseEntity<List<CandidateProjection>> getAllCandidates() {
        System.out.println("----FUNCTION TRIGGER-----");
        List<CandidateProjection> candidates = candidatesRepository.findAllProjectedBy();
        return ResponseEntity.ok(candidates);
    }

    // Add a new candidate
    @PostMapping
    public ResponseEntity<Candidates> addCandidate(@RequestBody Candidates candidate) {
        Candidates savedCandidate = candidatesRepository.save(candidate);
        return ResponseEntity.ok(savedCandidate);
    }

    // Get a single candidate by ID
    @GetMapping("/{id}")
    public ResponseEntity<Candidates> getCandidateById(@PathVariable Long id) {
        Optional<Candidates> candidate = candidatesRepository.findById(id);
        return candidate.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update a candidate by ID
    @PutMapping("/{id}")
    public ResponseEntity<Candidates> updateCandidate(@PathVariable Long id, @RequestBody Candidates updatedCandidate) {
        return candidatesRepository.findById(id)
                .map(existingCandidate -> {
                    existingCandidate.setName(updatedCandidate.getName());
                    existingCandidate.setEmail(updatedCandidate.getEmail());
                    existingCandidate.setPosition(updatedCandidate.getPosition());
                    existingCandidate.setTeam(updatedCandidate.getTeam());
                    existingCandidate.setLocation(updatedCandidate.getLocation());
                    Candidates savedCandidate = candidatesRepository.save(existingCandidate);
                    return ResponseEntity.ok(savedCandidate);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a candidate by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
        if (candidatesRepository.existsById(id)) {
            candidatesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Filter candidates
    @GetMapping("/filter")
    public ResponseEntity<List<Candidates>> filterCandidates(
            @RequestParam(required = false) Long position,
            @RequestParam(required = false) Long location,
            @RequestParam(required = false) String status) {
        // Example filter logic
        List<Candidates> candidates = new ArrayList<>();
        return ResponseEntity.ok(candidates);
    }
}
