package com.example.springbootTutorial.service;


import com.example.springbootTutorial.domain.Member;
import com.example.springbootTutorial.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long signUp(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {throw new IllegalStateException("이미 존재하는 회원입니다.");}
                );
    }

    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOneMemberById(Long id){
        return memberRepository.findById(id);
    }
    public Optional<Member> findOneMemberByName(String name){return memberRepository.findByName(name);}
}
