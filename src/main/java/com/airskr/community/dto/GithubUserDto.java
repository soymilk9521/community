package com.airskr.community.dto;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2019/11/03 21:19
 */
public class GithubUserDto {
    public Long id;
    public String name;
    public String bio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
