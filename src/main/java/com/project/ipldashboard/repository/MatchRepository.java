package com.project.ipldashboard.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.ipldashboard.model.Match;

public interface MatchRepository extends CrudRepository<Match,Long> {
    
    List<Match> getByHomeTeamOrAwayTeamOrderByStartDateDesc(String homeTeam,String awayTeam,Pageable pageable);

    @Query("select m from Match m where (m.homeTeam = :teamName or m.awayTeam = :teamName) and (m.startDate between :startDate and :endDate) order by m.startDate desc")
    List<Match> getByTeamBetweenDates(
        @Param("teamName") String teamName,
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate);

    default List<Match> findLatestMatchesByTeam(String teamName,int count){
        return getByHomeTeamOrAwayTeamOrderByStartDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}
