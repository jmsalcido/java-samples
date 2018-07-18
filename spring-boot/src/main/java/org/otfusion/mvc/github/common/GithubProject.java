package org.otfusion.mvc.github.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class GithubProject implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String orgName;

    @Column(unique = true)
    private String repositoryName;

    public GithubProject() {
    }

    public GithubProject(String orgName, String repositoryName) {
        this.orgName = orgName;
        this.repositoryName = repositoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubProject that = (GithubProject) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(orgName, that.orgName) &&
                Objects.equals(repositoryName, that.repositoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orgName, repositoryName);
    }

    @Override
    public String toString() {
        return "GithubProject{" +
                "id=" + id +
                ", orgName='" + orgName + '\'' +
                ", repositoryName='" + repositoryName + '\'' +
                '}';
    }
}
