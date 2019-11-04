package com.airskr.community.provider;

import com.airskr.community.dto.AccessTokenDto;
import com.airskr.community.dto.GithubClientDto;
import com.airskr.community.dto.GithubUserDto;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2019/11/03 21:01
 */
@Component
public class GithubProvider {
    public static final String ACCESS_TOKEN_URI= "https://github.com/login/oauth/access_token";
    public static final String GITHUB_USER_URI = "https://api.github.com/user?access_token=";
    public static final MediaType APPLICATION_JSON = MediaType.get("application/json; charset=utf-8");

    public AccessTokenDto getAccessToken(GithubClientDto tokenDto) {
        OkHttpClient client = new OkHttpClient();
        String json = JSON.toJSONString(tokenDto);
        RequestBody body = RequestBody.create(json, APPLICATION_JSON);
        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(ACCESS_TOKEN_URI)
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()){
                String tokenJson = response.body().string();
                return JSON.parseObject(tokenJson, AccessTokenDto.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public GithubUserDto getGithubUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(GITHUB_USER_URI + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String json = response.body().string();
            GithubUserDto user = JSON.parseObject(json, GithubUserDto.class);
            return  user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    String bowlingJson(String player1, String player2) {
        return "{'winCondition':'HIGH_SCORE',"
                + "'name':'Bowling',"
                + "'round':4,"
                + "'lastSaved':1367702411696,"
                + "'dateStarted':1367702378785,"
                + "'players':["
                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
                + "]}";
    }
}
