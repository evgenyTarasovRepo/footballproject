package com.tarasov.footballproject.repositores;

import com.tarasov.footballproject.entities.Team;
import com.tarasov.footballproject.exceptions.TeamNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

//    @Query("select t from Team t where t.teamName = ?1")
//    Optional<Team> findTeamByTeamNameIgnoreCase(String name);

    @Transactional(readOnly = true)
    Optional<Team> findTeamByTeamNameContainingIgnoreCase(String name);

    @Transactional(readOnly = true)
    @Query("select t from Team t " +
            "left join fetch t.manager " +
            "left join fetch t.players " +
            "left join fetch t.city " +
            "left join fetch t.stadium " +
            "where t.id = ?1")
    Optional<Team> getFullTeamById(Integer id) throws TeamNotFoundException;

    @Transactional(readOnly = true)
    @Query("select t from Team t " +
            "left join fetch t.manager " +
            "left join fetch t.players " +
            "left join fetch t.city " +
            "left join fetch t.stadium " +
            "where t.teamName = ?1")
    Optional<Team> getFullTeamByName(String teamName) throws TeamNotFoundException;

    @Transactional(readOnly = true)
    Optional<Team> findTeamByStadiumId(Integer id);
}
