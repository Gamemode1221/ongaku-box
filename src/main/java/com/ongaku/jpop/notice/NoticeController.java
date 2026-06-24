package com.ongaku.jpop.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    // POST /api/notices ➡️ 공지사항 등록 (save 연동)
    //GET /api/notices ➡️ 최신순 전체 목록 (findAllByOrderByCreatedAtDesc 연동)
    //GET /api/notices/search?keyword=값 ➡️ 검색 (findByTitleContainingOrContentContaining 연동)
    //GET /api/notices/{id} ➡️ 조회수 증가 + 상세 보기 (findByIdRead 구조 연동)
    //PUT /api/notices ➡️ 공지사항 수정 (update2 구조 연동)
    //DELETE /api/notices/{id} ➡️ 공지사항 삭제 (delete 연동)
    //GET /api/notices/period?start=값&end=값 ➡️ 기간 검색 (findByRdatePeriodDesc 구조 연동)

    @DeleteMapping("/{id}")
    public boolean deleteNotice(@PathVariable Long id) {
        return noticeService.deleteNotice(id);
    }
}
