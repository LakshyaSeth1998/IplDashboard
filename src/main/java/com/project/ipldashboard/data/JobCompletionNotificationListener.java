package com.project.ipldashboard.data;

import com.project.ipldashboard.model.Team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

  private final JdbcTemplate jdbcTemplate;
  private final EntityManager em;

  @Autowired
  public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate,EntityManager em) {
    this.jdbcTemplate = jdbcTemplate;
    this.em = em;
  }

  @Override
  @Transactional
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");

      // jdbcTemplate.query("SELECT home_team, away_team , start_date FROM match",
      //   (rs, row) -> "Home Team " + rs.getString(1) + " Away Team " + rs.getString(2) + " Start Date " + rs.getString(3)
      // ).forEach(str -> System.out.println(str));

      Map<String, Team> teamData = new HashMap<>();
      
      List<Object[]> res=em.createQuery("select m.homeTeam, count(*) from Match m group by m.homeTeam").getResultList();
      for (Object[] obj : res) {
        Team t=new Team((String)obj[0], (Long) obj[1]);
        teamData.put(t.getTeamName(),t);
      }

      em.createQuery("select m.awayTeam, count(*) from Match m group by m.awayTeam", Object[].class)
      .getResultList()
      .stream()
      .forEach(t -> {
        Team team = teamData.get((String) t[0]);
        team.setTotalMatches(team.getTotalMatches()+(Long) t[1]);
      });

      em.createQuery("select m.winner, count(*) from Match m group by m.winner", Object[].class)
      .getResultList()
      .stream()
      .forEach(t -> {
        Team team = teamData.get((String) t[0]);
        if(team!=null) team.setTotalWins((Long)t[1]);
      });

      teamData.values().forEach(team -> em.persist(team));
      teamData.values().forEach(team -> System.out.println(team.toString()));
    }
  }
}