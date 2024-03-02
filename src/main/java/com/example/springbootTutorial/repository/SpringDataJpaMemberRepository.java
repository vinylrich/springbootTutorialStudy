package com.example.springbootTutorial.repository;

import com.example.springbootTutorial.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository{

    // JpaMemberRepository 트러블 슈팅하기
    // App koyep으로 그대로 배포
    // aws,gcp,azure db 프리티어 연동 후 배포까지


    // mysql 연동 -> Spring Config 빈 재설정 -> 맴버레포지토리 전부 테스트 -> 타임리프 html 템플릿 만들기(id,name 받아오기)

    // SpringDataJpaMemberRepository
    // 'select m Member as m where m.name=name' 이라는 쿼리 구문을
    //  findByName을 Override 함으로서 생략하게 해준다.
    @Override
    Optional<Member> findByName(String name);
}
