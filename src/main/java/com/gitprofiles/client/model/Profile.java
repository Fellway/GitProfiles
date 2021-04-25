package com.gitprofiles.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public
class Profile {
    private Long id;
    private String login;
    private String name;
    private String type;
    @JsonProperty(value = "avatar_url")
    private String avatarUrl;
    @JsonProperty(value = "created_at")
    private Date createdAt;
    private Long followers;
    @JsonProperty(value = "public_repos")
    private Long publicRepos;
}

