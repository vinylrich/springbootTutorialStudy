package com.example.springbootTutorial.repository;


import com.example.springbootTutorial.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// 이 클래스에서는 가입된 회
// 원을 db에 저장하지 않고 java project 내에 일단 저장을 하는 기능을 구현한다.
@Repository
public class MemoryMemberRepository implements MemberRepository {

    public static Map<Long,Member> store = new HashMap<>();
    // [1][junwoo]
    // [2][jihoon]
    public static Long sequence = 0L;

    //Map
    //key: value
    //hashmap key:value key가 중복이 안됨(보안성이 높음) -> hashmap같은 경우에는 데이터가 들어갈 때 암호화가 돼

    @Override
    public Member save(Member member) {
        member.setId(++sequence);// 1,2,3,4,5
        store.put(sequence,member);//
        return member;
    }
    // 진짜 있어도 되고 없어도 돼서
    // ofnullable을 쓰기 위해서
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.
                values().
                stream().
                filter(member -> member.getName().equals(name))
                .findAny();
    }


    @Override
    public List<Member> findAll() {
        // 회원가입한 맴버 전체를 불러온다
        // store map이 끝날때까지
        return new ArrayList<>(store.values());
    }
}
