package io.spring.infrastructure.member;

import io.spring.domain.member.Member;
import io.spring.domain.member.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberCoreRepository implements MemberRepository {

    private final JpaMemberRepository memberRepository;

    public MemberCoreRepository(JpaMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(MemberEntity.of(member))
            .to();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id)
            .map(MemberEntity::to);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll().stream().map(MemberEntity::to).toList();
    }

    @Override
    public Member put(Member member) {
        return memberRepository.save(MemberEntity.of(member)).to();
    }
}
