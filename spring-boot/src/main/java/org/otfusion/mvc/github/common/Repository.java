package org.otfusion.mvc.github.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Repository {

    private long id;
    private String name;
    private User owner;
    private String description;
    private String language;
    private int watchers;

    @JsonCreator
    public Repository(@JsonProperty("id") long id,
                      @JsonProperty("name") String name,
                      @JsonProperty("owner") User owner,
                      @JsonProperty("description") String description,
                      @JsonProperty("language") String language,
                      @JsonProperty("watchers") int watchers) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.language = language;
        this.watchers = watchers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }
}
