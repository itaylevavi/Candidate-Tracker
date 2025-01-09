package zim_project.zim_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zim_project.zim_project.model.Teams;
import zim_project.zim_project.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;



    public List<Teams> getAllTeams() {
        return teamRepository.findAll();
    }

    // קבלת קבוצה לפי ID
    public Optional<Teams> getTeamById(Long id) {
        return teamRepository.findById(id);
    }
}
