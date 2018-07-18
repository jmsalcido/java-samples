package org.otfusion.mvc.github;

import org.otfusion.mvc.github.common.GithubProject;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GithubProjectRepository extends PagingAndSortingRepository<GithubProject, Long> {

    GithubProject findByRepositoryName(String repositoryName);

}
