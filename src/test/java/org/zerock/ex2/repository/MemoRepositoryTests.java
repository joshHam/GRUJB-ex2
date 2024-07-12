package org.zerock.ex2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.ex2.entity.Memo;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository; //멤버변수

    @Test
    public void testClass(){    //메소드1
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies(){ //메소드2
        IntStream.rangeClosed(1,100).forEach(i->{
            Memo memo = Memo.builder().memoText("Sample..."+i).build();
            memoRepository.save(memo);
        });
    }

    @Test
    public void testSelect(){
        //데이터베이스에 존재하는 mno
        Long mno = 100L;
        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("================================");

        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println(memo);
        }
    }


}













