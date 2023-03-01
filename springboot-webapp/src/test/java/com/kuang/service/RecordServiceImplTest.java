package com.kuang.service;

import com.kuang.exception.SqlException;
import com.kuang.pojo.Record;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecordServiceImplTest {

    @Autowired
    @Qualifier("recordServiceImpl")
    RecordService recordService;

    @Test
    void addRecord() throws SqlException {
        recordService.addRecord(new Record(0,3,1,0));
//        recordService.addRecord(new Record(0,3,1,0));
//        recordService.addRecord(new Record(7,3,1,0));
//        recordService.addRecord(new Record(10,3,1,0));
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
    }

    @Test
    void queryRecordByUserIdAndSongId() {
    }

    @Test
    void queryRecordByUserIdWithPage() {
    }

    @Test
    void queryCountByUserId() {
    }

    @Test
    void queryRecordSongByUserIdWithPageAndCount() {
    }

    @Test
    void deleteRecordByIdList() {
    }
}