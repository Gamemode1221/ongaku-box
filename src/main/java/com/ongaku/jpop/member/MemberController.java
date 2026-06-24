package com.ongaku.jpop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public ResponseEntity<Member> save(@RequestBody MemberDTO memberDTO) {
        Member savedEntity = memberService.save(memberDTO);
        return ResponseEntity.ok(savedEntity);
    }

    @PutMapping("/members")
    public ResponseEntity<Member> update(@RequestBody MemberDTO memberDTO) {
        Member savedEntity = memberService.update(memberDTO);
        return ResponseEntity.ok(savedEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> findById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findById(id));
    }

    @DeleteMapping("/{id}")
    public boolean deleteMember(@PathVariable Long id) {
        return memberService.deleteMember(id);
    }

    @GetMapping("/find_all")
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/find_by_username")
    public List<Member> findByUsernameContaining(String title) {
        return memberService.findByUsernameContaining(title);
    }
}
