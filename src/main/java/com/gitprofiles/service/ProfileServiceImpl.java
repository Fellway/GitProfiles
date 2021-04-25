package com.gitprofiles.service;

import com.gitprofiles.client.GithubClient;
import com.gitprofiles.dto.ProfileDto;
import com.gitprofiles.dto.mapper.ProfileMapper;
import com.gitprofiles.model.db.Statistics;
import com.gitprofiles.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private GithubClient githubClient;
    private StatisticsRepository statisticsRepository;

    @Autowired
    public ProfileServiceImpl(final GithubClient githubClient, final StatisticsRepository statisticsRepository) {
        this.githubClient = githubClient;
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    @Transactional
    public ProfileDto getProfileByLogin(final String login) {
        increaseStatisticsCounter(login);
        return ProfileMapper.toProfileDto(githubClient.findUserByLogin(login));
    }

    private void increaseStatisticsCounter(final String login) {
        statisticsRepository.findByLoginIgnoreCase(login)
                .ifPresentOrElse(
                        (s) -> statisticsRepository.increaseCounterByLogin(login),
                        () -> statisticsRepository.save(new Statistics(login))
                );
    }

}
