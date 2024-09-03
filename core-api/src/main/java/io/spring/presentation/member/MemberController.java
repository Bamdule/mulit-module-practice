package io.spring.presentation.member;

import io.spring.domain.member.*;
import io.spring.usecase.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/v1/members")
@RestController
public class MemberController {

    private final MemberFindAllService memberFindAllService;
    private final MemberFindOneService memberFindOneService;
    private final MemberRegisterService memberRegisterService;
    private final PutMemberService putMemberService;

    public MemberController(MemberFindAllService memberFindAllService, MemberFindOneService memberFindOneService, MemberRegisterService memberRegisterService, PutMemberService putMemberService) {
        this.memberFindAllService = memberFindAllService;
        this.memberFindOneService = memberFindOneService;
        this.memberRegisterService = memberRegisterService;
        this.putMemberService = putMemberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> findMembers() {
        return ResponseEntity.ok().body(memberFindAllService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Member> findMember(@PathVariable Long id) {
        return ResponseEntity.ok().body(memberFindOneService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Member> putMember(@PathVariable Long id, String name) {
        return ResponseEntity.ok().body(putMemberService.putMember(id, name));
    }

    @PostMapping
    public ResponseEntity<Member> registerMember(String name) {
        return ResponseEntity.ok().body(memberRegisterService.register(new MemberRegisterCommand(name)));
    }
}
