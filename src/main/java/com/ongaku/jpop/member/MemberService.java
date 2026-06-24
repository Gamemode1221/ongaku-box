package com.ongaku.jpop.member;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member save(MemberDTO dto) {
        dto.setCreatedAt(LocalDateTime.now());
        return memberRepository.save(dto.toEntity());
    }

    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID의 회원이 존재하지 않습니다. id=" + id));
    }

    public Member update(MemberDTO dto) {
        Member member = memberRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("수정할 회원이 존재하지 않습니다.")); // 수정할 레코드를 로딩
        System.out.println(member.toString());

        member.setUsername(dto.getUsername()); // DTO -> Entity 이동
        member.setPassword(dto.getPassword());
        member.setEmail(dto.getEmail());

        // 기존에 등록된 Entity를 로딩했음으로 update가 발생함.
        return memberRepository.save(member);
    }

    public List<Member> findByUsernameContaining(String title) {
        return memberRepository.findByUsernameContaining(title);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public boolean deleteMember(Long id) {
        Optional<Member> member = memberRepository.findById(id);

        if (member.isPresent()) {
            memberRepository.delete(member.get());
            return true;
        } else {
            return false;
        }
    }
}
