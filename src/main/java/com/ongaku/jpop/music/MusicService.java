package com.ongaku.jpop.music;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    // save(MusicDTO): 유저 또는 관리자의 새로운 J-POP 추천 곡 등록
    //findAllByOrderByCreatedAtDesc(): 추천 게시판의 기본 정렬인 최신 등록순 목록 조회
    //findAllByOrderByReleasedAtDesc(): ISSUE 정렬 로직을 응용하여, 제이팝 최신 발매일순(신곡순) 정렬 조회 기능 (커뮤니티에 아주 유용)
    //findByTitleContainingOrContentContaining(String keyword): 곡 제목 또는 추천 본문 내용으로 검색
    //findByAuthorContaining(String author): ISSUE에는 없지만 Music에는 필수적인 가수/아티스트명(author) 기반 검색 기능 추가
    //findById(Long id): 특정 추천 곡 상세 보기 (조회수가 없으므로 단순 조회로 처리)
    //update2(MusicDTO): 추천 곡의 제목, 본문, 발매일 정보 수정
    //delete(Long id): 등록된 추천 곡 삭제
    //findAllByReleasedAtBetween(String start, String end): 기간 검색을 활용하여 "2020년대 발매된 곡", "특정 연도에 발매된 올드 제이팝/시티팝" 범위 검색 기능으로 승화

    public boolean deleteMusic(Long id) {
        Optional<Music> music = musicRepository.findById(id);

        if (music.isPresent()) {
            musicRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
