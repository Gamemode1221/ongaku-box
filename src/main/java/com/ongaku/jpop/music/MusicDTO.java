package com.ongaku.jpop.music;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MusicDTO {
    private Long id;
    private String title;
    private String description;
    private String artist;
    private String album;
    private String genre;
    private String youtubeUrl;
    private String lyrics;

}
