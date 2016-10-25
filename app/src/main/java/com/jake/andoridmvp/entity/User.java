package com.jake.andoridmvp.entity;

/**
 * description：user info
 *
 * @author jake
 * @since 2016/10/23 21:52
 */


public class User {
    public String nickname;
    public int sex;
    public String avatar;
    public String token;

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", avatar='" + avatar + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
