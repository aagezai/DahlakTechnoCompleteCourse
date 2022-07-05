package com.dahlaktechno.dahlaktechnoproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    @RequestMapping("/welcome")
    public String welcome(){
        return  "welcome.html";
    }
    @RequestMapping("/welcomeByJsp")
    public String welcomeJsp(){
        return  "welcomeByJsp.jsp";
    }
}
