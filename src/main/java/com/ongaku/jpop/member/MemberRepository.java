package com.ongaku.jpop.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByUsernameContaining(String title);
//    @Override
//    Optional<Member> findById(Long id);
}
