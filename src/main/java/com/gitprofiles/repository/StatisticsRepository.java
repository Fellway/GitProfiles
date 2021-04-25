package com.gitprofiles.repository;

import com.gitprofiles.model.db.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

    @Modifying
    @Query("UPDATE Statistics s set s.requestCount = s.requestCount + 1 WHERE login = :login")
    void increaseCounterByLogin(@Param(value = "login") final String login);

    Optional<Statistics> findByLoginIgnoreCase(final String login);
}
