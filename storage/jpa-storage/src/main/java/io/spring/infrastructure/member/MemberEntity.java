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

    public MemberEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static MemberEntity of(Member member) {
        if (member.getId() == null) {
            return new MemberEntity(null, member.getName());
        }

        return new MemberEntity(member.getId(), member.getName());
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
