package io.spring.domain.member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    List<Member> findAll();

    Member put(Member member);
}
