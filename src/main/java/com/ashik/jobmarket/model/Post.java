package com.ashik.jobmarket.model;


import java.util.Arrays;

public class Post {
    private String profile;


    private String description;
    private int experience;
    private String techs[];

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "profile='" + profile + '\'' +
                ", description='" + description + '\'' +
                ", experience=" + experience +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }

    public String getprofile() {
        return profile;
    }

    public void setprofile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }
}
