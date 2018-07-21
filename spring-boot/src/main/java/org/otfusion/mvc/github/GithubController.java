package org.otfusion.mvc.github;

import org.otfusion.mvc.github.common.GithubProject;
import org.otfusion.mvc.github.http.GithubClient;
import org.otfusion.mvc.github.common.Repository;
import org.otfusion.mvc.github.common.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("github")
public class GithubController {

    private final GithubClient githubClient;
    private final GithubProjectRepository githubProjectRepository;

    public GithubController(GithubClient githubClient, GithubProjectRepository githubProjectRepository) {
        this.githubClient = githubClient;
        this.githubProjectRepository = githubProjectRepository;
    }

    @GetMapping("/repos/{username}")
    @ResponseBody
    public List<Repository> getAllRepositories(@PathVariable String username) {
        return githubClient.getAllRepositories(username);
    }

    @GetMapping("/stored/{repositoryName}")
    @ResponseBody
    public ResponseEntity<GithubProject> getGithubProjectByName(@PathVariable String repositoryName) {
        GithubProject githubProject = githubProjectRepository.findByRepositoryName(repositoryName);
        ResponseEntity<GithubProject> response;

        if (githubProject != null) {
            response = ResponseEntity.ok(githubProject);
        } else {
            response = ResponseEntity.notFound().build();
        }

        return response;
    }

    @GetMapping("/stored/")
    @ResponseBody
    public Iterable<GithubProject> getGithubProjectsStored() {
        return githubProjectRepository.findAll();
    }

    @GetMapping("/{username}/{repository}")
    @ResponseBody
    public Repository getRepository(@PathVariable String username, @PathVariable String repository) {
        return githubClient.getRepository(username, repository);
    }

    @GetMapping("/user/{username}")
    @ResponseBody
    public User getUser(@PathVariable String username) {
        return githubClient.getUser(username);
    }

}
