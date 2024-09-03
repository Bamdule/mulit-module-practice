package io.spring.domain.member;

public class Member {

    private Long id;
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void update(String name) {
        this.name = name;
    }
}
