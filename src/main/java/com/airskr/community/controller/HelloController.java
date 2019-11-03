package com.airskr.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2019/11/03 8:53
 */
@Controller
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(Model model) {
        model.addAttribute("name", "北北");
        return "hello";
    }
}
