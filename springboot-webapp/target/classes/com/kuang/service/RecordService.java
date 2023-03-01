package com.kuang.service;

import com.kuang.dto.history.GetHistoryResData;
import com.kuang.dto.history.History;
import com.kuang.exception.SqlException;
import com.kuang.pojo.Record;

import java.util.List;

public interface RecordService {
    int addRecord(Record record)throws SqlException;

    int deleteRecordById(int id)throws SqlException;

    int updateRecordById(int id, int fav)throws SqlException;

    Record queryRecordById(int id);
    List<Record> queryRecordByUserId(int userId)throws SqlException;
    Record queryRecordByUserIdAndSongId(int userId, int songId);
    List<History> queryRecordByUserIdWithPage(int userId, int pageStart, int pageSize)throws SqlException;
    Integer queryCountByUserId(int userId)throws SqlException;

    int addRecordIgnore(Record record);

    int deleteRecordByIdList(List<Integer>idList)throws SqlException;
    GetHistoryResData queryRecordSongByUserIdWithPageAndCount(int userId, int page, int pageSize)throws SqlException;


}
