package com.leckan.lasgididevelopers;

import java.io.Serializable;

/**
 * Created by Simpa on 3/12/2017.
 */

public class LasgidiUser implements Serializable {
    private String login;
    private String id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private String site_admin;
    private String score;

    public LasgidiUser(){
        login = "leckan";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String input) {
        this.login = input;
    }
    public String getId() {
        return id;
    }

    public void setId(String input) {
        this.id = input;
    }
    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String input) {
        this.avatar_url = input;
    }
    public String getGravatar_id() {
        return gravatar_id;
    }

    public void setGravatar_id(String input) {
        this.gravatar_id = input;
    }
    public String getUserUrl() {
        return url;
    }

    public void setUserUrl(String input) {
        this.url = input;
    }
    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String input) {
        this.html_url = input;
    }
    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String input) {
        this.followers_url = input;
    }
    public String getFollowing_url() {
        return following_url;
    }

    public void setFollowing_url(String input) {
        this.following_url = input;
    }
    public String getGists_url() {
        return gists_url;
    }

    public void setGists_url(String input) {
        this.gists_url = input;
    }
    public String getStarred_url() {
        return starred_url;
    }

    public void setStarred_url(String input) {
        this.starred_url = input;
    }
    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public void setSubscriptions_url(String input) {
        this.subscriptions_url = input;
    }
    public String getOrganizations_url() {
        return organizations_url;
    }

    public void setOrganizations_url(String input) {
        this.organizations_url = input;
    }
    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String input) {
        this.repos_url = input;
    }
    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String input) {
        this.events_url = input;
    }
    public String getReceived_events_url() {
        return received_events_url;
    }

    public void setReceived_events_url(String input) {
        this.received_events_url = input;
    }
    public String getType() {
        return type;
    }

    public void setType(String input) {
        this.type = input;
    }
    public String getSite_admin() {
        return site_admin;
    }

    public void setSite_admin(String input) {
        this.site_admin = input;
    }
    public String getScore() {
        return score;
    }

    public void setScore(String input) {
        this.score = input;
    }

    /*@Override
    public String toString() {
        return "[ headline=" + headline + ", reporter Name=" + reporterName + " , date=" + date + "]";
    }*/
}
