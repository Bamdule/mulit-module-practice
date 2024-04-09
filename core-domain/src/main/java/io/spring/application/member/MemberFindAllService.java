package io.spring.application.member;

import io.spring.domain.member.Member;
import io.spring.domain.member.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberFindAllService {

    private final MemberRepository memberRepository;

    public MemberFindAllService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
