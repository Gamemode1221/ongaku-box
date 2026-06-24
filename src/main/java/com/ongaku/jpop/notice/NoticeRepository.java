package com.ongaku.jpop.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE Notice n SET n.viewCount = n.viewCount + 1 WHERE n.id=:id")
    int increaseViewCount(Long id);

//    @Transactional
//    @Modifying(clearAutomatically = true, flushAutomatically = true)
//    @Query(value = "UPDATE NOTICE n SET n.viewCount = n.viewCount - 1 WHERE n.viewCount=:viewCount", nativeQuery = true)
//    int decreaseViewCount(int count);
}
