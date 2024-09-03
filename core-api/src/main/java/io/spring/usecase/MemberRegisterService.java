package io.spring.usecase;

import io.spring.domain.member.Member;
import io.spring.domain.member.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberRegisterService {

    private final MemberRepository memberRepository;

    public MemberRegisterService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member register(MemberRegisterCommand command) {
        return memberRepository.save(command.toEntity());
    }
}
