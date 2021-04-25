package com.gitprofiles.service;

import com.gitprofiles.dto.ProfileDto;

public interface ProfileService {
    ProfileDto getProfileByLogin(final String login);
}
