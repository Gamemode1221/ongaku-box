package com.ongaku.jpop.music;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "musicId_seq")
    @SequenceGenerator(name = "musicId_seq", sequenceName = "MUSICID_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 2000)
    private String description;

    @Column(nullable = false, length = 200)
    private String artist;

    @Column(length = 200)
    private String album;

    @Column(nullable = false, length = 200)
    private String genre;

    @Column(length = 1000)
    private String youtubeUrl;

    @Column(precision = 19)
    private Long viewCount;

    @Column(precision = 19)
    private Long likeCount;

    @Column(nullable = false, length = 1000)
    private String coverImageUrl;

    @Column(nullable = false)
    private LocalDateTime releasedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
