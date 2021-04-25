package com.gitprofiles.dto.mapper;

import com.gitprofiles.client.model.Profile;
import com.gitprofiles.dto.ProfileDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ProfileMapperTest {

    private static final Long ID = 1L;
    private static final String AVATAR = "avatar";
    private static final String LOGIN = "login";
    private static final String NAME = "name";
    private static final String TYPE = "type";
    private static Date CREATED_AT = new Date();

    private Profile profile;

    @Before
    public void setUp() {
            this.profile = createProfileEntity();
            CREATED_AT.setTime(10000L);
    }

    @Test
    public void toProfileDto() {
        ProfileDto profileDto = ProfileMapper.toProfileDto(profile);
        assertEquals(ID, profileDto.getId());
        assertEquals(AVATAR, profileDto.getAvatarUrl());
        assertEquals(LOGIN, profileDto.getLogin());
        assertEquals(NAME, profileDto.getName());
        assertEquals(TYPE, profileDto.getType());
        assertEquals(CREATED_AT, profileDto.getCreatedAt());
        assertEquals(Long.valueOf(18), profileDto.getCalculations());
    }

    @Test
    public void calculationsShouldReturn0IfNumberOfFollowersIs0() {
        Profile profileWithoutRepos = new Profile();
        profileWithoutRepos.setPublicRepos(1L);
        profileWithoutRepos.setFollowers(0L);

        ProfileDto profileDto = ProfileMapper.toProfileDto(profileWithoutRepos);

        Assert.assertEquals(Long.valueOf(0L), profileDto.getCalculations());
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
