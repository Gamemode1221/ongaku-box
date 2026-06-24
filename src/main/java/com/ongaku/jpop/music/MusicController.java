package com.ongaku.jpop.music;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/music")
@RequiredArgsConstructor
public class MusicController {

    private final MusicService musicService;

    // POST /api/music ➡️ 추천 곡 등록 (save 연동)
    //GET /api/music ➡️ 최신 등록순 목록 (findAllByOrderByCreatedAtDesc 연동)
    //GET /api/music/released ➡️ 신곡 발매순 목록 (findAllByOrderByReleasedAtDesc 연동)
    //GET /api/music/search?keyword=값 ➡️ 곡명/본문 검색 (findByTitleContainingOrContentContaining 연동)
    //GET /api/music/{id} ➡️ 추천 곡 상세 경로 변수 보기 (read_path 구조 연동)
    //PUT /api/music ➡️ 추천 정보 수정 (update2 연동)
    //DELETE /api/music/{id} ➡️ 추천 곡 삭제 (delete 연동)

    @DeleteMapping("/{id}")
    public boolean deleteMusic(@PathVariable Long id) {
        return musicService.deleteMusic(id);
    }
}
