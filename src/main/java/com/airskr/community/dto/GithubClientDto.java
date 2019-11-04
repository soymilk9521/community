package com.airskr.community.dto;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2019/11/03 20:50
 */
public class GithubClientDto {
    public String client_id;
    public String client_secret;
    public String code;
    public String state;
    public String redirectUri;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    @Override
    public String toString() {
        return "AccessTokenDto{" +
                "clientId='" + client_id + '\'' +
                ", clientSecret='" + client_secret + '\'' +
                ", code='" + code + '\'' +
                ", state='" + state + '\'' +
                ", redirectUri='" + redirectUri + '\'' +
                '}';
    }
}
