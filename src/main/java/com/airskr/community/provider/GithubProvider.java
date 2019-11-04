package com.airskr.community.provider;

import com.airskr.community.dto.AccessTokenDto;
import com.airskr.community.dto.GithubClientDto;
import com.airskr.community.dto.GithubUserDto;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import okhttp3.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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

    @Resource(name = "snakeCaseSerializeConfig")
    private SerializeConfig snakeCaseSerializeConfig; // json转换格式：snakeCase

    /**
     * 获取github认证token
     * @param clientDto
     * @return
     */
    public AccessTokenDto getAccessToken(GithubClientDto clientDto) {
        OkHttpClient client = new OkHttpClient();
        // 对象转json
        String json = JSON.toJSONString(clientDto, snakeCaseSerializeConfig);
        // 请求body
        RequestBody body = RequestBody.create(json, APPLICATION_JSON);
        // post请求
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

    /**
     * 通过认证token获取github用户信息
     * @param accessToken 认证token
     * @return
     */
    public GithubUserDto getGithubUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        // get请求
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
}
