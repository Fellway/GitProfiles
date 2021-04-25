package com.gitprofiles.client;

import com.gitprofiles.client.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubClientImpl implements GithubClient {

    @Value("${api.github.users}")
    private String API_URL;

    private RestTemplate restTemplate;

    @Autowired
    public GithubClientImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Profile findUserByLogin(final String login) {
        return restTemplate.getForEntity(API_URL + login, Profile.class).getBody();
    }
}
