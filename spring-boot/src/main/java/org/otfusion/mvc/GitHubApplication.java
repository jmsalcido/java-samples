package org.otfusion.mvc;

import org.otfusion.mvc.github.GithubProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GithubProperties.class)
public class GitHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitHubApplication.class, args);
    }

}