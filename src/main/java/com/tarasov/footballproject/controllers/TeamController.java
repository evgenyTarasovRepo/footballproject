package com.tarasov.footballproject.controllers;

import com.tarasov.footballproject.dto.get.GetFullTeamInfoDTO;
import com.tarasov.footballproject.dto.get.GetTeamDTO;
import com.tarasov.footballproject.dto.post.PostTeamDTO;
import com.tarasov.footballproject.entities.Team;
import com.tarasov.footballproject.exceptions.TeamNotFoundException;
import com.tarasov.footballproject.exceptions.errorresponse.TeamErrorResponse;
import com.tarasov.footballproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamController {
    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/teams")
    public ResponseEntity<Void> saveTeam(@RequestBody PostTeamDTO postTeamDTO) {
        teamService.saveTeam(postTeamDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/teams")
    public ResponseEntity<List<GetTeamDTO>> findAllTeams() {
        List<GetTeamDTO> teams = teamService.findAllTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<GetTeamDTO> findTEamById(@PathVariable Integer id) {
        GetTeamDTO teamDTO = teamService.findTeamById(id);
        return ResponseEntity.ok(teamDTO);
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<GetFullTeamInfoDTO> getFullTeamInfo(@PathVariable Integer id) {
        GetFullTeamInfoDTO fullTeamInfo = teamService.getFullTeamInfo(id);
        return ResponseEntity.ok(fullTeamInfo);
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<String> deleteTeamById(@PathVariable Integer id) {
        teamService.deleteTeamById(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/teams/{id}")
    public ResponseEntity<PostTeamDTO> updateTeam(@PathVariable Integer id, @RequestBody PostTeamDTO postTeamDTO) {
        teamService.updateTeam(id, postTeamDTO);

        return ResponseEntity.ok(postTeamDTO);
    }

}
