package com.ongaku.jpop.music;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "musicId_seq")
    @SequenceGenerator(name = "musicId_seq", sequenceName = "MUSICID_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private LocalDateTime releasedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
