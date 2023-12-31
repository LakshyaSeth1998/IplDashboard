package com.project.ipldashboard.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ipldashboard.model.Match;
import com.project.ipldashboard.model.Team;
import com.project.ipldashboard.repository.MatchRepository;
import com.project.ipldashboard.repository.TeamRepository;

@RestController
@CrossOrigin
public class TeamController {
    private TeamRepository teamRepository;
    private MatchRepository matchRepository;
    
    public TeamController(TeamRepository teamRepository,MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("team")
    public Iterable<Team> getAllTeams(){
        return this.teamRepository.findAll();
    }

    @GetMapping("team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team team = this.teamRepository.findByTeamName(teamName);
        team.setLatestMatches(this.matchRepository.findLatestMatchesByTeam(teamName, 4));
        return team;
    }

    @GetMapping("team/{teamName}/matches")
    public List<Match> getMatchesForTean(@PathVariable String teamName, @RequestParam int year){
        LocalDateTime startDate= LocalDateTime.of(year, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(year+1, 1, 1, 0, 0);
        return this.matchRepository.getByTeamBetweenDates(teamName, startDate, endDate);
    }
}
