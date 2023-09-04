package com.project.ipldashboard.repository;

import java.util.List;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.project.ipldashboard.model.Match;

public interface MatchRepository extends CrudRepository<Match,Long> {
    
    List<Match> getByHomeTeamOrAwayTeamOrderByStartDateDesc(String homeTeam,String awayTeam,Pageable pageable);

    default List<Match> findLatestMatchesByTeam(String teamName,int count){
        return getByHomeTeamOrAwayTeamOrderByStartDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}
