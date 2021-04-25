package com.gitprofiles.service;

import com.gitprofiles.client.GithubClient;
import com.gitprofiles.client.model.Profile;
import com.gitprofiles.model.db.Statistics;
import com.gitprofiles.repository.StatisticsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProfileServiceImplTest {

    private static final String TEST_USER = "testUser";
    private static final Long ID = 1L;
    private static final String AVATAR = "avatar";
    private static final String LOGIN = "login";
    private static final String NAME = "name";
    private static final String TYPE = "type";
    private static Date CREATED_AT = new Date();

    @Mock
    private GithubClient githubClientMock;

    @Mock
    private StatisticsRepository statisticsRepositoryMock;

    @InjectMocks
    private ProfileServiceImpl profileService;

    @Before
    public void setUp() {
        CREATED_AT.setTime(10000L);
    }

    @Test
    public void getProfileByLoginShouldIncreaseCounterForExistingEntry() {
        when(githubClientMock.findUserByLogin(TEST_USER)).thenReturn(createProfileEntity());
        when(statisticsRepositoryMock.findByLoginIgnoreCase(TEST_USER)).thenReturn(Optional.of(new Statistics()));

        profileService.getProfileByLogin(TEST_USER);

        verify(statisticsRepositoryMock, times(0)).save(any());
        verify(statisticsRepositoryMock, times(1)).increaseCounterByLogin(TEST_USER);
        verify(statisticsRepositoryMock, times(1)).findByLoginIgnoreCase(TEST_USER);
    }

    @Test
    public void getProfileByLoginShouldCreateNewEntry() {
        when(githubClientMock.findUserByLogin(TEST_USER)).thenReturn(createProfileEntity());
        when(statisticsRepositoryMock.findByLoginIgnoreCase(TEST_USER)).thenReturn(Optional.empty());

        profileService.getProfileByLogin(TEST_USER);

        verify(statisticsRepositoryMock, times(1)).save(any());
        verify(statisticsRepositoryMock, times(0)).increaseCounterByLogin(TEST_USER);
        verify(statisticsRepositoryMock, times(1)).findByLoginIgnoreCase(TEST_USER);
    }

    private Profile createProfileEntity() {
        Profile profile = new Profile();
        profile.setAvatarUrl(AVATAR);
        profile.setId(ID);
        profile.setLogin(LOGIN);
        profile.setName(NAME);
        profile.setType(TYPE);
        profile.setCreatedAt(CREATED_AT);
        profile.setPublicRepos(1L);
        profile.setFollowers(1L);
        return profile;
    }
}
