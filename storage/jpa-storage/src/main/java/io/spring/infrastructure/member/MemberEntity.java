package io.spring.infrastructure.member;

import io.spring.domain.member.Member;
import jakarta.persistence.*;


@Table(name = "member")
@Entity
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    protected MemberEntity() {
    }

    public MemberEntity(String name) {
        this.name = name;
    }


    public static MemberEntity of(Member member) {
        return new MemberEntity(member.getName());
    }

    public Member to() {
        return new Member(id, name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
