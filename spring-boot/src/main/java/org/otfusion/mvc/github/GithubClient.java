package org.otfusion.mvc.github;

import org.otfusion.mvc.github.model.Repository;
import org.otfusion.mvc.github.model.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class GithubClient {

    private static final String REPOS_URL = "https://api.github.com/users/{username}/repos";
    private static final String USER_URL = "https://api.github.com/users/{username}";

    private final RestTemplate restTemplate;

    public GithubClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    List<Repository> getAllRepositories(String username) {
        ResponseEntity<Repository[]> entity =
                restTemplate.getForEntity(REPOS_URL, Repository[].class, username);

        List<Repository> response = Collections.emptyList();
        if (entity.getBody() != null) {
            response = Arrays.asList(entity.getBody());
        }
        return response;
    }

    User getUser(String username) {
        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(USER_URL, User.class, username);

        return userResponseEntity.getBody();
    }

}
