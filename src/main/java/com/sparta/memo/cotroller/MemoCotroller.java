package com.sparta.memo.cotroller;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class MemoCotroller {

    //데이터저장소 대신 맵 사용,<키 = 아이디값, 실제 데이터 >
    private final Map<Long, Memo> memoList = new HashMap<>();

    //메모 생성 Post
    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // RequestDto -> Entity 데이터베이스 저장해야지
        Memo memo = new Memo(requestDto);

        // Memo Max ID 찾기
        // 아이디 값 중복되면 안되니까 가장 마지막 값 id +1
        Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet()) + 1 : 1;
        memo.setId(maxId);

        // DB 데이터베이스에 저장
        memoList.put(memo.getId(), memo);

        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        return memoResponseDto;
    }

    // 메모 조회 Get
    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        // Map -> List 반환
        List<MemoResponseDto> responseList = memoList.values().stream()
                .map(MemoResponseDto::new).toList();

        return responseList;


    }


}