package com.kuang.mapper;

import com.kuang.pojo.Record;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecordMapperTest {

    @Autowired
    RecordMapper recordMapper;

    @Test
    void addRecord() {
        recordMapper.addRecord(new Record(0,3,1,0));
    }

    @Test
    void deleteRecordById() {
    }

    @Test
    void updateRecordById() {
    }

    @Test
    void queryRecordById() {
    }

    @Test
    void queryRecordByUserId() {
        recordMapper.queryRecordByUserId(1);
    }

    @Test
    void queryRecordByUserIdAndSongId() {
        recordMapper.queryRecordByUserIdAndSongId(1,1);
    }

    @Test
    void queryRecordByUserIdWithPage() {
    }

    @Test
    void queryCountByUserId() {
    }
}