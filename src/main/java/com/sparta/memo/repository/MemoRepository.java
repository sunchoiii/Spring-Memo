package com.sparta.memo.repository;
//데이터베이스와 소통

import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 심플레포지토리에 Repository 가 달려있어서 따로 애너테이션 안해서 됨
public interface MemoRepository extends JpaRepository<Memo, Long> {

    List<Memo> findAllByOrderByModifiedAtDesc();

    // 이렇게 파라변수 넣어서 동적으로 생성도 가능
    // List<Memo> findAllByUsername(String username);

}