package com.xunsheng;

public class GitHubAccount {
    private int num, followers, repoNo, following, gists;
    private String login, url;

    GitHubAccount(String column1, String column2){
        this.login = column1;
        this.url = column2;

    }

    GitHubAccount(int column1, int column2, int column3, int column4, String column5){
        this.followers = column1;
        this.repoNo = column2;
        this.following = column3;
        this.gists = column4;
        this.url = column5;

    }

    //Return the index of the element.
    public int getNum() {
        return num;
    }

    //Set the index of the element.
    public void setNum(int num) {
        this.num = num;
    }

    //Return the login ID of the element.
    public String getLogin() {
        return login;
    }

    //Set the login ID of the element.
    public void setLogin(String column1) {
        this.login = column1;
    }

    //Return the API URL of the element.
    public String getUrl() {
        return url;
    }

    //set the API URL of the element.
    public void setUrl(String column2) {
        this.url = column2;
    }

    //Return the number of followers of the element.
    public int getFollowers() {
        return followers;
    }

    //set the number of followers of the element.
    public void setFollowers(int column3) {
        this.followers = column3;
    }

    //Return the number of repository of the element.
    public int getRepoNo() {
        return repoNo;
    }

    //set the number of repository of the element.
    public void setRepoNo(int column3) {
        this.repoNo = column3;
    }

    //Return the following count of the element.
    public int getFollowing() {
        return following;
    }

    //set the following count of the element.
    public void setFollowing(int column3) {
        this.following = column3;
    }

    //Return the link of github account of the element.
    public int getGists() {
        return gists;
    }

    //set the link of github account of the element.
    public void setGists(int column3) {
        this.gists = column3;
    }
}
