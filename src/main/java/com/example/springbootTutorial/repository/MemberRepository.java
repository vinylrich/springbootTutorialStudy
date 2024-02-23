package com.example.springbootTutorial.repository;

import com.example.springbootTutorial.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    // 레거시 코드 -> 옛날코드
    // 세대가 바뀌면 바뀔수록 업데이트가 많다
    // 오라클이 일을 잘한다
    Member save(Member member);

    Optional<Member> findByName(String name);

    Optional<Member> findById(Long id);

    List<Member> findAll();


    //mysql 설치 및 등록
}
