package org.otfusion.mvc.github;

import org.otfusion.mvc.github.model.Repository;
import org.otfusion.mvc.github.model.User;
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

    public GithubController(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @GetMapping("/repos/{username}")
    @ResponseBody
    public List<Repository> getAllRepositories(@PathVariable String username) {
        return githubClient.getAllRepositories(username);
    }

    @GetMapping("/user/{username}")
    @ResponseBody
    public User getUser(@PathVariable String username) {
        return githubClient.getUser(username);
    }

}
