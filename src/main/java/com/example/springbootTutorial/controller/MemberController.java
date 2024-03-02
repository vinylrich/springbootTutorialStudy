package com.example.springbootTutorial.controller;

import com.example.springbootTutorial.domain.Member;
import com.example.springbootTutorial.service.MemberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }

    // 맴버 컨트롤러 말고 다른 여러 컨트롤러들이 맴버서비스를 가져다가 쓸 수 있음
    // 스프링 컨테이너에서 쓸 때 생성자를 호출함
    // @Autowired가 있으면 맴버 서비스를 스프링이
    // 스프링 컨테이너에 있는 맴버 서비스를 가져다가 연결을 시켜줌
    // 스프링이 올라가고 조립이 됨

    @GetMapping("member/new")
    public String createMemberForm(){
        return "member/createMemberForm";
    }

    @PostMapping("member/new")
    public String createMember(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());

        System.out.println("member = " + member.getName());

        try{
            memberService.signUp(member);
        }catch(Exception e){
            return "redirect:/";
        }
        return "redirect:/";
    }

    @GetMapping("member/all")
    public String allMembers(Model model){
        List<Member> members = memberService.findAllMembers();
        model.addAttribute("memberList",members);
        // 반복문을 돌려서 띄워줘야함
        return "member/list";
    }

    @ResponseBody
    @GetMapping("member")
    public Optional<Member> oneMemberById(Model model, @RequestParam(value = "id",required = false ,defaultValue = "1")Long id){
        Optional<Member> member = memberService.findOneMemberById(id);

        return member;
    }
    @ResponseBody
    @GetMapping("member/{name}")
    public Optional<Member> oneMemberByName(Model model, @PathVariable(value="name",required = false)String name){
        Optional<Member> member = memberService.findOneMemberByName(name);
        return member;
    }
}
