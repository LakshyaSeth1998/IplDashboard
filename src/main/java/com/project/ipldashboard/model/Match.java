package com.project.ipldashboard.model;

import java.sql.Clob;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Match {
    private String season;
    @Id
    private Long id;
    private String name;
    private String shortName;
    private String homeTeam;
    private String awayTeam;
    private String tossWon;
    private String decision;
    private String firstInningScore;
    private String secondInningScore;
    private String winner;
    private String result;
    private LocalDateTime startDate;
    private String venueName;
    private String homeCaptain;
    private String awayCaptain;
    private String pom;
    private String points;
    private String homeOvers;
    private String homeRuns;
    private String homeWickets;
    private String homeBoundaries;
    private String awayOvers;
    private String awayRuns;
    private String awayWickets;
    private String awayBoundaries;
    @Column(columnDefinition = "CLOB")
    private String highlights;
    private String homeKeyBatsman;
    private String homeKeyBowler;
    private String awayKeyBatsman;
    private String awayKeyBowler;
    private String umpire1;
    private String umpire2;
    public String getSeason() {
        return season;
    }
    public void setSeason(String season) {
        this.season = season;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public String getHomeTeam() {
        return homeTeam;
    }
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }
    public String getAwayTeam() {
        return awayTeam;
    }
    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }
    public String getTossWon() {
        return tossWon;
    }
    public void setTossWon(String tossWon) {
        this.tossWon = tossWon;
    }
    public String getDecision() {
        return decision;
    }
    public void setDecision(String decision) {
        this.decision = decision;
    }
    public String getFirstInningScore() {
        return firstInningScore;
    }
    public void setFirstInningScore(String firstInningScore) {
        this.firstInningScore = firstInningScore;
    }
    public String getSecondInningScore() {
        return secondInningScore;
    }
    public void setSecondInningScore(String secondInningScore) {
        this.secondInningScore = secondInningScore;
    }
    public String getWinner() {
        return winner;
    }
    public void setWinner(String winner) {
        this.winner = winner;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public String getVenueName() {
        return venueName;
    }
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
    public String getHomeCaptain() {
        return homeCaptain;
    }
    public void setHomeCaptain(String homeCaptain) {
        this.homeCaptain = homeCaptain;
    }
    public String getAwayCaptain() {
        return awayCaptain;
    }
    public void setAwayCaptain(String awayCaptain) {
        this.awayCaptain = awayCaptain;
    }
    public String getPom() {
        return pom;
    }
    public void setPom(String pom) {
        this.pom = pom;
    }
    public String getPoints() {
        return points;
    }
    public void setPoints(String points) {
        this.points = points;
    }
    
    public String getHomeOvers() {
        return homeOvers;
    }
    public void setHomeOvers(String homeOvers) {
        this.homeOvers = homeOvers;
    }
    public String getHomeRuns() {
        return homeRuns;
    }
    public void setHomeRuns(String homeRuns) {
        this.homeRuns = homeRuns;
    }
    public String getHomeWickets() {
        return homeWickets;
    }
    public void setHomeWickets(String homeWickets) {
        this.homeWickets = homeWickets;
    }
    public String getHomeBoundaries() {
        return homeBoundaries;
    }
    public void setHomeBoundaries(String homeBoundaries) {
        this.homeBoundaries = homeBoundaries;
    }
    public String getAwayOvers() {
        return awayOvers;
    }
    public void setAwayOvers(String awayOvers) {
        this.awayOvers = awayOvers;
    }
    public String getAwayRuns() {
        return awayRuns;
    }
    public void setAwayRuns(String awayRuns) {
        this.awayRuns = awayRuns;
    }
    public String getAwayWickets() {
        return awayWickets;
    }
    public void setAwayWickets(String awayWickets) {
        this.awayWickets = awayWickets;
    }
    public String getAwayBoundaries() {
        return awayBoundaries;
    }
    public void setAwayBoundaries(String awayBoundaries) {
        this.awayBoundaries = awayBoundaries;
    }
    public String getHighlights() {
        return highlights;
    }
    public void setHighlights(String highlights) {
        this.highlights = highlights;
    }
    public String getHomeKeyBatsman() {
        return homeKeyBatsman;
    }
    public void setHomeKeyBatsman(String homeKeyBatsman) {
        this.homeKeyBatsman = homeKeyBatsman;
    }
    public String getHomeKeyBowler() {
        return homeKeyBowler;
    }
    public void setHomeKeyBowler(String homeKeyBowler) {
        this.homeKeyBowler = homeKeyBowler;
    }
    public String getAwayKeyBatsman() {
        return awayKeyBatsman;
    }
    public void setAwayKeyBatsman(String awayKeyBatsman) {
        this.awayKeyBatsman = awayKeyBatsman;
    }
    public String getAwayKeyBowler() {
        return awayKeyBowler;
    }
    public void setAwayKeyBowler(String awayKeyBowler) {
        this.awayKeyBowler = awayKeyBowler;
    }
    public String getUmpire1() {
        return umpire1;
    }
    public void setUmpire1(String umpire1) {
        this.umpire1 = umpire1;
    }
    public String getUmpire2() {
        return umpire2;
    }
    public void setUmpire2(String umpire2) {
        this.umpire2 = umpire2;
    }
    
}
