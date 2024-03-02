package com.example.springbootTutorial;

import com.example.springbootTutorial.repository.JpaMemberRepository;
import com.example.springbootTutorial.repository.MemberRepository;
import com.example.springbootTutorial.repository.SpringDataJpaMemberRepository;
import com.example.springbootTutorial.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final SpringDataJpaMemberRepository springDataJpaMemberRepository;
    //스프링 데이터 JPA 가 등록해준 MemberRepository bean 을 이용해서 DI 받음
    //MemberRepository 대체
    @Autowired
    public SpringConfig(SpringDataJpaMemberRepository springDataJpaMemberRepository) {
        this.springDataJpaMemberRepository = springDataJpaMemberRepository;
    }

    @Bean
    public MemberService memberService() {
//      return new MemberService(memberRepository);
        return new MemberService(springDataJpaMemberRepository);
    }

}
// web browser(client) -> localhost:8083/member/new (body name: rlawnsdn) Post 방식으로 요청
// -> java application MemberController Mapping 한 url로 handling 해줌
// createMember 맴버 함수 실행 memberServer.signUp MemberController-MemberService 연결을 해줌(DI)(빈으로 등록을 해준다)
// MemberService에서는 이름 중복 판별을 해주고 memberRepo 안에 있는 save를 실행시켜줌
// MemberService-MemberRepository
// MemberRepository 안에서는
// MemberService와 springDataJpaMemberRepository가 연결이 되어 있어서
// MemberRepository 안에 있는 기능이 구현이 되지 않은 Interface를 객체화 시켜서 사용할 수 있게된다.
// SpringDataJpaMemberRepository 안에서는 findByName을 @Override해서만 사용하고 있다
// 그러므로 SpringDataJpaMemberRepository는 사실상 미리 구현이 되어있는것이다.