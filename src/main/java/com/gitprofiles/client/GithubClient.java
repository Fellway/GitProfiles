package com.gitprofiles.client;


import com.gitprofiles.client.model.Profile;

public interface GithubClient {
    Profile findUserByLogin(final String login);
}
