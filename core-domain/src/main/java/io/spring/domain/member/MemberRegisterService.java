package io.spring.domain.member;

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
