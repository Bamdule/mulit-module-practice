package io.spring.usecase;

import io.spring.domain.member.Member;
import io.spring.domain.member.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberFindOneService {

    private final MemberRepository memberRepository;

    public MemberFindOneService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member findById(Long id) {
        return memberRepository.findById(id)
            .orElseThrow(RuntimeException::new);
    }
}
