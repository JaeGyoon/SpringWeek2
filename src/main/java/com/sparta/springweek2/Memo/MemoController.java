package com.sparta.springweek2.Memo;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class MemoController
{
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @GetMapping("/view/memos")
    public List<Memo> getMemos()
    {
        return memoRepository.findAllByOrderByCreatedAtDesc();
    }

    @PostMapping("/view/memos")
    public Memo createMemo(@RequestBody MemoRequestDTO requestDto)
    {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @PutMapping("/view/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDTO requestDTO)
    {
        memoService.update(id,requestDTO);
        return id;
    }

    @DeleteMapping("/view/memos/{id}")
    public Long deleteMemo(@PathVariable Long id)
    {
        memoRepository.deleteById(id);
        return id;
    }

    // 게시글 디테일 조회
    @GetMapping("/view/memos/{id}")
    public Memo getContents(@PathVariable Long id) {
        Memo contents =  memoRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("id가 존재하지 않습니다."));
        return contents;
    }

}