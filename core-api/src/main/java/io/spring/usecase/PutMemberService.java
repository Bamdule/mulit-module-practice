package io.spring.usecase;

import io.spring.domain.member.Member;
import io.spring.domain.member.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PutMemberService {

    private final MemberRepository memberRepository;

    public PutMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member putMember(Long id, String name) {
        Member member = memberRepository.findById(id)
            .orElseThrow(RuntimeException::new);

        member.update(name);

        return memberRepository.put(member);
    }
}
