package com.airskr.community.controller;

import com.airskr.community.dto.AccessTokenDto;
import com.airskr.community.dto.GithubClientDto;
import com.airskr.community.dto.GithubUserDto;
import com.airskr.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2019/11/03 12:22
 */
@Controller
public class LoginController {
    @Autowired
    GithubProvider provider;

    @GetMapping("/login")
    public String login(@RequestParam(value = "code", required = false) String code
                , @RequestParam(value = "state", required = false) String state) {
        System.out.println("第一次交互成功！返回code：" + code + ", state:" + state);
        GithubClientDto clientDto = new GithubClientDto();
        clientDto.setCode(code);
        clientDto.setState(state);
        clientDto.setClient_id("7cdeaa9109bad4e1c610");
        clientDto.setClient_secret("f738c38cd7f4d207eed42ced627a62de6f8f5c30");
        AccessTokenDto tokenDto = provider.getAccessToken(clientDto);
        System.out.println("第二次交互成功！返回access_token：" + tokenDto);
        GithubUserDto user = provider.getGithubUser(tokenDto.getAccess_token());
        System.out.println("第三次交互成功！返回user：" + user);
        return "index";
    }
}
