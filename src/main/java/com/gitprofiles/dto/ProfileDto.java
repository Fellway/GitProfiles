package com.gitprofiles.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class ProfileDto {

    private Long id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private Date createdAt;
    private Long calculations;
}
