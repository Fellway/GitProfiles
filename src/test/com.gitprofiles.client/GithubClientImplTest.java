package com.gitprofiles.client;

import com.gitprofiles.client.model.Profile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GithubClientImplTest {

    private static final String TEST_USER = "test";

    @Value("${api.github.users}")
    private String API_URL;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private GithubClientImpl githubClient;

    @Test
    public void findUserByLogin() {
        when(restTemplate.getForEntity(API_URL + TEST_USER, Profile.class)).thenReturn(ResponseEntity.ok(new Profile()));
        Assert.assertNotNull(githubClient.findUserByLogin(TEST_USER));
    }
}
