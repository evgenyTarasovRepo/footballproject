package com.tarasov.footballproject.dto.post;

import java.time.LocalDateTime;

public class PostMatchDTO {
    LocalDateTime matchDateTime;
    private String homeTeam;
    private String awayTeam;
    private String stadium;
    private Integer homeTeamScore;
    private Integer awayTeamScore;
    private Integer attendance;

    public PostMatchDTO() {
    }

    public PostMatchDTO(LocalDateTime matchDateTime, String homeTeam, String awayTeam,
                        String stadium, Integer homeTeamScore, Integer awayTeamScore,
                        Integer attendance) {
        this.matchDateTime = matchDateTime;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.attendance = attendance;
    }

    public LocalDateTime getMatchDateTime() {
        return matchDateTime;
    }

    public void setMatchDateTime(LocalDateTime matchDateTime) {
        this.matchDateTime = matchDateTime;
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


    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(Integer awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }
}
