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
 * @since 2019/11/03 11:24
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model) {

        return "index";
    }
}
