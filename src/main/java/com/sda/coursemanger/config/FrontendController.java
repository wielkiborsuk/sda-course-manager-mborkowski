package com.sda.coursemanger.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {
    @RequestMapping(path = { "/courses/**", "/users/**" })
    public String handleFrontendEndpoints() {
        return "forward:/";
    }
}
