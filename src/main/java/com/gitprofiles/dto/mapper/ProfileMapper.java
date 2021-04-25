package com.gitprofiles.dto.mapper;

import com.gitprofiles.client.model.Profile;
import com.gitprofiles.dto.ProfileDto;

public class ProfileMapper {
    public static ProfileDto toProfileDto(final Profile profile) {
        return ProfileDto.builder()
                .id(profile.getId())
                .login(profile.getLogin())
                .name(profile.getName())
                .avatarUrl(profile.getAvatarUrl())
                .type(profile.getType())
                .createdAt(profile.getCreatedAt())
                .calculations(calculations(profile))
                .build();
    }

    private static Long calculations(final Profile profile) {
        try {
            return (6 / profile.getFollowers()) * (2 + profile.getPublicRepos());
        } catch (final ArithmeticException e) {
            return 0L;
        }
    }
}
