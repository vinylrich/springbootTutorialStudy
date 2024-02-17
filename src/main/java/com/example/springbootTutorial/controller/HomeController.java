package com.example.springbootTutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//이것은 컨트롤러입니다.
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    // 접근제한자 정리
    // public -> 어디에서나 접근할 수 있음.
    // private -> 현재 클래스 내에서만 접근할 수 있음
    // default -> 현재 패키지 내에서 접근가능
    // protected -> 현재 패키지 내에서 접근 가능하지만 다른 패키지 내에서도 상속관계라면 접근 가능
}