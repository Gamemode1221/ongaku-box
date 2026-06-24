package com.ongaku.jpop.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    // save(NoticeDTO): 관리자의 공지사항 등록 기능
    // findAllByOrderByCreatedAtDesc(): 기존 findAll과 findAllByOrderByRdateDesc를 통합하여, 공지사항 목록을 항상 최신 등록일 순으로 조회하는 로직
    // findByTitleContainingOrContentContaining(String keyword): 제목 또는 내용에 키워드가 포함된 공지사항 검색
    // increaseViewCount(Long id): 공지사항 상세 조회 시 호출할 조회수 1 증가 로직 (이미 NoticeRepository에 구현해 두신 메서드 연동)
    // findById(Long id): 단건 공지사항 상세 정보 로딩
    // update2(NoticeDTO): 공지 내용을 영속성 컨텍스트를 활용해 안전하게 변경하고 수정된 객체를 반환하는 로직 (update보다 update2 방식 강력 권장)
    // delete(Long id): 공지사항 영구 삭제
    // findAllByCreatedAtBetween(String start, String end): 기존 findAllByOrderByRdateDesc(start, end)를 매핑하여 특정 기간 동안 등록된 공지/이벤트 검색 기능

    public boolean deleteNotice(Long id) {
        Optional<Notice> notice = noticeRepository.findById(id);

        if (notice.isPresent()) {
            noticeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
