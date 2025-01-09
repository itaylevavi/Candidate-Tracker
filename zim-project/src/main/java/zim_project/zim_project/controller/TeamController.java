package zim_project.zim_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zim_project.zim_project.model.Teams;
import zim_project.zim_project.service.TeamService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<Teams>> getAllTeams() {
        List<Teams> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams); // מחזיר את כל הקבוצות כ-JSON
    }

    // פונקציה לקבלת קבוצה לפי ID
    @GetMapping("/{id}")
    public ResponseEntity<Teams> getTeamById(@PathVariable Long id) {
        Optional<Teams> team = teamService.getTeamById(id);

        if (team.isPresent()) {
            return ResponseEntity.ok(team.get()); // מחזיר את הקבוצה אם נמצאה
        } else {
            return ResponseEntity.notFound().build(); // מחזיר 404 אם הקבוצה לא קיימת
        }
    }

}
