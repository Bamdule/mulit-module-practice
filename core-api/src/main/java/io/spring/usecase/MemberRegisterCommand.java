package io.spring.usecase;

import io.spring.domain.member.Member;

public record MemberRegisterCommand(String name) {

    public Member toEntity() {
        return new Member(name);
    }
}
