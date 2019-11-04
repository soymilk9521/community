package com.airskr.community.controller;

import com.airskr.community.dto.AccessTokenDto;
import com.airskr.community.dto.GithubClientDto;
import com.airskr.community.dto.GithubUserDto;
import com.airskr.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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

    @Value("${github.oauth.client.id}")
    private String clientId;

    @Value("${github.oauth.client.secret}")
    private String clientSecret;

    @Value("${github.oauth.redirect.uri}")
    private String redirectUri;


    @GetMapping("/login")
    public String login(@RequestParam(value = "code", required = false) String code
                , @RequestParam(value = "state", required = false) String state
                , HttpSession session) {
        System.out.println("第一次交互成功！返回code：" + code + ", state:" + state);
        GithubClientDto clientDto = new GithubClientDto();
        clientDto.setCode(code);
        clientDto.setState(state);
        clientDto.setClientId(clientId);
        clientDto.setClientSecret(clientSecret);
        clientDto.setRedirectUri(redirectUri);
        AccessTokenDto tokenDto = provider.getAccessToken(clientDto);
        System.out.println("第二次交互成功！返回access_token：" + tokenDto);
        GithubUserDto user = provider.getGithubUser(tokenDto.getAccessToken());
        System.out.println("第三次交互成功！返回user：" + user);
        if (user != null) {
            // 登录成功，将用github户信息添加到session
            session.setAttribute("user", user);
            return "redirect:/index";
        }else {
            // TODO 登录失败处理
            return "redirect:/index";
        }
    }
}
