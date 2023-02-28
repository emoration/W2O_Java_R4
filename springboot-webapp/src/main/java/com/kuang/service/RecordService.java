package com.kuang.service;

import com.kuang.dto.response.GetHistoryRes;
import com.kuang.pojo.Record;

import java.util.List;

public interface RecordService {
    int addRecord(Record record);

    int deleteRecordById(int id);

    int deleteRecordByIdList(List<Integer>idList);
    List<Record> queryRecordByUserId(int userId);
    GetHistoryRes queryRecordSongByUserIdWithPage(int userId, int page, int pageSize);

    Record queryRecordById(int id);

    int updateRecordById(int id,int fav);
}
