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
    public String clientId;
    public String clientSecret;
    public String code;
    public String state;
    public String redirectUri;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
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
                "clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", code='" + code + '\'' +
                ", state='" + state + '\'' +
                ", redirectUri='" + redirectUri + '\'' +
                '}';
    }
}
