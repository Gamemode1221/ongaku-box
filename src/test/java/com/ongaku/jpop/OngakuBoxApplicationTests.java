package com.ongaku.jpop;

import com.ongaku.jpop.member.Member;
import com.ongaku.jpop.member.MemberRepository;
import com.ongaku.jpop.music.Music;
import com.ongaku.jpop.music.MusicRepository;
import com.ongaku.jpop.notice.Notice;
import com.ongaku.jpop.notice.NoticeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootTest
class OngakuBoxApplicationTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private NoticeRepository noticeRepository;

    @Test
    @Commit
        // 테스트가 끝난 후 롤백되지 않고 DB에 실제 반영
    void insertProjectDummyData() {

        // ==========================================
        // 1. 유저 가짜 데이터 삽입 (User Dummy)
        // ==========================================
        Member member1 = new Member();
        member1.setUsername("admin");
        member1.setPassword("admin123!");
        member1.setEmail("admin@ongaku.com");

        Member member2 = new Member();
        member2.setUsername("jpop_mania");
        member2.setPassword("pass1234!");
        member2.setEmail("mania@gmail.com");

        Member member3 = new Member();
        member3.setUsername("yoasobi_fan");
        member3.setPassword("yoasobi0412!");
        member3.setEmail("fan@naver.com");

        memberRepository.saveAll(Arrays.asList(member1, member2, member3));
        System.out.println(">>> 유저 데이터 삽입 완료!");

        // ==========================================
        // 2. J-POP 추천 음악 데이터 삽입 (Music Dummy)
        // ==========================================
        // 음악 1: 애니메이션/팝
        Music music1 = new Music();
        music1.setTitle("Idol (アイドル)");
        music1.setAuthor("YOASOBI");
        music1.setContent("최신 애니메이션 최애의 아이 오프닝 곡으로, 전 세계적인 붐을 일으킨 트렌디한 제이팝 음악입니다. 강력 추천!");
        music1.setReleasedAt(LocalDateTime.of(2023, 4, 12, 0, 0));
        music1.setCreatedAt(LocalDateTime.now());

        // 음악 2: 발라드/드라마 OST
        Music music2 = new Music();
        music2.setTitle("Lemon");
        music2.setAuthor("Kenshi Yonezu (米津玄師)");
        music2.setContent("드라마 '언내추럴'의 주제가로, 일본 레코드 협회 역사상 가장 빠른 속도로 밀리언 인증을 받은 서정적인 명곡입니다.");
        music2.setReleasedAt(LocalDateTime.of(2018, 3, 14, 0, 0));
        music2.setCreatedAt(LocalDateTime.now());

        // 음악 3: 어쿠스틱/소셜 메가히트
        Music music3 = new Music();
        music3.setTitle("Dry Flower (ドライフラワー)");
        music3.setAuthor("Yuuri (優里)");
        music3.setContent("애절한 이별 감성을 담은 어쿠스틱 발라드로, 빌보드 재팬 연간 차트 1위를 기록하며 노래방에서 가장 많이 불리는 곡입니다.");
        music3.setReleasedAt(LocalDateTime.of(2020, 10, 25, 0, 0));
        music3.setCreatedAt(LocalDateTime.now());

        // 음악 4: 시티팝 (레트로 장르)
        Music music4 = new Music();
        music4.setTitle("Stay With Me (真夜中のドア)");
        music4.setAuthor("Miki Matsubara (松原みき)");
        music4.setContent("1979년에 발매되었으나 최근 틱톡과 글로벌 스트리밍에서 전 세계적인 역주행 신화를 쓴 전설적인 시티팝 장르 대표곡입니다.");
        music4.setReleasedAt(LocalDateTime.of(1979, 11, 5, 0, 0));
        music4.setCreatedAt(LocalDateTime.now());

        musicRepository.saveAll(Arrays.asList(music1, music2, music3, music4));
        System.out.println(">>> J-POP 음악 추천 데이터 삽입 완료!");

        // ==========================================
        // 3. 공지사항 데이터 삽입 (Notice Dummy)
        // ==========================================
        Notice notice1 = new Notice();
        notice1.setTitle("[공지] J-GROOVE 커뮤니티 오픈 및 이용 규칙 안내");
        notice1.setAuthor("운영자");
        notice1.setContent("안녕하세요. J-POP 장르별 추천 커뮤니티에 오신 것을 환영합니다. 서로 존중하는 클린한 음악 공유 문화를 만들어가요.");
        notice1.setViewCount(150L);
        notice1.setCreatedAt(LocalDateTime.now());
        notice1.setUpdatedAt(LocalDateTime.now());

        Notice notice2 = new Notice();
        notice2.setTitle("[이벤트] 내 인생 최고의 최애 J-POP 인증 이벤트 (선물 증정)");
        notice2.setAuthor("운영자");
        notice2.setContent("여러분이 가장 사랑하는 J-POP 아티스트의 명곡을 추천 게시판에 인증해 주세요! 추첨을 통해 소정의 상품을 드립니다.");
        notice2.setViewCount(42L);
        notice2.setCreatedAt(LocalDateTime.now());
        notice2.setUpdatedAt(LocalDateTime.now());

        noticeRepository.saveAll(Arrays.asList(notice1, notice2));
        System.out.println(">>> 커뮤니티 공지사항 데이터 삽입 완료!");
    }
}
