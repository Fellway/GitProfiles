package com.gitprofiles.model.db;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private Long requestCount;

    public Statistics(final String login) {
        this.login = login;
        this.requestCount = 1L;
    }
}
