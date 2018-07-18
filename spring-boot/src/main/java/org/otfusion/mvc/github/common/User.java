package org.otfusion.mvc.github.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private String login;
    private long id;
    private String avatarUrl;
    private String url;
    private String name;
    private String email;
    private String bio;

    @JsonCreator
    public User(@JsonProperty("login") String login,
                @JsonProperty("id") long id,
                @JsonProperty("avatar_url") String avatarUrl,
                @JsonProperty("url") String url,
                @JsonProperty("name") String name,
                @JsonProperty("email") String email,
                @JsonProperty("bio") String bio) {
        this.login = login;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.url = url;
        this.name = name;
        this.email = email;
        this.bio = bio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
