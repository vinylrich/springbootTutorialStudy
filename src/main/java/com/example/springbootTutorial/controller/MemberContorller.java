package com.example.springbootTutorial.controller;

import com.example.springbootTutorial.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberContorller {
    @GetMapping("member/new")
    public String createMember(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());

        System.out.println("member = " + member.getName());

        return "redirect:/";
    }
}
