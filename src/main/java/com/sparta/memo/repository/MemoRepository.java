package com.sparta.memo.repository;
//데이터베이스와 소통

import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 심플레포지토리에 Repository 가 달려있어서 따로 애너테이션 안해서 됨
public interface MemoRepository extends JpaRepository<Memo, Long> {
    

}