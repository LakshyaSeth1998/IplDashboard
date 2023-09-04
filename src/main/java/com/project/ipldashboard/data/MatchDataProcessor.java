package com.project.ipldashboard.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import com.project.ipldashboard.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

  private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

  @Override
  public Match process(final MatchInput matchInput) throws Exception {
    Match match=new Match();
    match.setSeason(matchInput.getSeason());
    match.setId(Long.parseLong(matchInput.getId()));
    match.setName(matchInput.getName());
    match.setShortName(matchInput.getShort_name());
    match.setHomeTeam(matchInput.getHome_team());
    match.setAwayTeam(matchInput.getAway_team());
    match.setTossWon(matchInput.getToss_won());
    match.setDecision(matchInput.getDecision());
    match.setFirstInningScore(matchInput.getFirst_inning_score());
    match.setSecondInningScore(matchInput.getSecond_inning_score());
    match.setWinner(matchInput.getWinner());
    match.setResult(matchInput.getResult());
    ZonedDateTime zonedDateTime = ZonedDateTime.parse(matchInput.getStart_date(), DateTimeFormatter.ISO_DATE_TIME);
    match.setStartDate(zonedDateTime.toLocalDateTime());
    match.setVenueName(matchInput.getVenue_name());
    match.setHomeCaptain(matchInput.getHome_captain());
    match.setAwayCaptain(matchInput.getAway_captain());
    match.setPom(matchInput.getPom());
    match.setPoints(matchInput.getPoints());
    match.setHomeOvers(matchInput.getHome_overs());
    match.setHomeRuns(matchInput.getHome_runs());
    match.setHomeWickets(matchInput.getHome_wickets());
    match.setHomeBoundaries(matchInput.getHome_boundaries());
    match.setAwayOvers(matchInput.getAway_overs());
    match.setAwayRuns(matchInput.getAway_runs());
    match.setAwayWickets(matchInput.getAway_wickets());
    match.setAwayBoundaries(matchInput.getAway_boundaries());
    match.setHighlights(matchInput.getHighlights());
    match.setHomeKeyBatsman(matchInput.getHome_key_batsman());
    match.setHomeKeyBowler(matchInput.getHome_key_bowler());
    match.setAwayKeyBatsman(matchInput.getAway_key_batsman());
    match.setAwayKeyBowler(matchInput.getAway_key_bowler());
    match.setUmpire1(matchInput.getUmpire1());
    match.setUmpire2(matchInput.getUmpire2());
    return match;
  }
}