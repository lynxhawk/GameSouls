package com.lynx.springsouls.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String background;
    private int power;
    private int heart;
    private int exp;
    private String gametype;
    private String introduce;
    private int follow;
    private int follower;
    private int publish;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getFollow() {
        return follow;
    }

    public void setFollow(int follow) {
        this.follow = follow;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) {
        this.publish = publish;
    }
}
