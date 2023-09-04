package com.project.ipldashboard.data;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.project.ipldashboard.model.Match;

@Configuration
public class BatchConfiguration {
    private final String[] FIELD_NAMES = { "season", "id", "name", "short_name", "description", "home_team",
            "away_team", "toss_won",
            "decision", "First_inning_score", "Second_inning_score", "winner", "result", "start_date", "end_date",
            "venue_id", "venue_name", "home_captain", "away_captain", "pom", "points", "super_over", "home_overs",
            "home_runs", "home_wickets", "home_boundaries", "away_overs", "away_runs", "away_wickets",
            "away_boundaries", "highlights", "home_key_batsman", "home_key_bowler", "home_playx1", "away_playx1",
            "away_key_batsman", "away_key_bowler", "match_days", "umpire1", "umpire2", "tv_umpire", "referee",
            "reserve_umpire" };

    @Bean
    public FlatFileItemReader<MatchInput> reader() {
        return new FlatFileItemReaderBuilder<MatchInput>()
                .name("matchItemReader")
                .resource(new ClassPathResource("Cricket_data.csv"))
                .delimited()
                .names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MatchInput>() {
                    {
                        setTargetType(MatchInput.class);
                    }
                })
                .build();
    }

    @Bean
    public MatchDataProcessor processor() {
        return new MatchDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Match>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO match (id, name, short_name, home_team, away_team, toss_won, decision, first_inning_score, second_inning_score, winner, result, start_date, venue_name, home_captain, away_captain, pom, points, home_overs, home_runs, home_wickets, home_boundaries, away_overs, away_runs, away_wickets, away_boundaries, highlights, home_key_batsman, home_key_bowler, away_key_batsman, away_key_bowler, umpire1, umpire2)"
                        +
                        "VALUES (:id, :name, :shortName, :homeTeam, :awayTeam, :tossWon, :decision, :firstInningScore, :secondInningScore, :winner, :result, :startDate, :venueName, :homeCaptain, :awayCaptain, :pom, :points, :homeOvers, :homeRuns, :homeWickets, :homeBoundaries, :awayOvers, :awayRuns, :awayWickets, :awayBoundaries, :highlights, :homeKeyBatsman, :homeKeyBowler, :awayKeyBatsman, :awayKeyBowler, :umpire1, :umpire2)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository,
            JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
            PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Match> writer) {
        return new StepBuilder("step1", jobRepository)
                .<MatchInput, Match>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
