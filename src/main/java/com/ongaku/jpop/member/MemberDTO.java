package com.ongaku.jpop.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;

    public Member toEntity() {
        // 시퀀스로 ID를 자동으로 지정해주기 때문에, null을 지정
//        return new Member(null, username, password, email, LocalDateTime.now());
        return Member.builder()
                .username(this.username)
                .password(this.password)
                .email(this.email)
                .createdAt(LocalDateTime.now())
                .build(); // id는 적지 않으면 자동으로 null이 되어 시퀀스가 작동
    }
}
