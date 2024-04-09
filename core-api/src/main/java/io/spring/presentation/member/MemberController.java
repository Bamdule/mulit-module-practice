package io.spring.presentation.member;

import io.spring.application.member.MemberFindAllService;
import io.spring.application.member.MemberFindOneService;
import io.spring.application.member.MemberRegisterCommand;
import io.spring.application.member.MemberRegisterService;
import io.spring.domain.member.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/v1/members")
@RestController
public class MemberController {

    private final MemberFindAllService memberFindAllService;
    private final MemberFindOneService memberFindOneService;
    private final MemberRegisterService memberRegisterService;

    public MemberController(MemberFindAllService memberFindAllService, MemberFindOneService memberFindOneService, MemberRegisterService memberRegisterService) {
        this.memberFindAllService = memberFindAllService;
        this.memberFindOneService = memberFindOneService;
        this.memberRegisterService = memberRegisterService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> findMembers() {
        return ResponseEntity.ok().body(memberFindAllService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Member> findMember(@PathVariable Long id) {
        return ResponseEntity.ok().body(memberFindOneService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Member> registerMember(String name) {
        return ResponseEntity.ok().body(memberRegisterService.register(new MemberRegisterCommand(name)));
    }
}
