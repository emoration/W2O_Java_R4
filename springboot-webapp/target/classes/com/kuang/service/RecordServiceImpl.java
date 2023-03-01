package com.kuang.service;

import com.kuang.constant.QueryParm;
import com.kuang.dto.history.GetHistoryResData;
import com.kuang.dto.history.History;
import com.kuang.exception.SqlException;
import com.kuang.mapper.RecordMapper;
import com.kuang.pojo.Record;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public int addRecord(Record record) throws SqlException {
        try {
            queryRecordByUserIdAndSongId(record.getUserId(), record.getSongId());
        } catch (SqlException e) {
            return recordMapper.addRecord(record);
        }
        throw new SqlException("add record existed");
    }

    @Override
    public int deleteRecordById(int id) throws SqlException {
        try {
            queryRecordById(id);
        } catch (SqlException e) {
            throw new SqlException("delete record not found");
        }
        return recordMapper.deleteRecordById(id);
    }

    @Override
    public int updateRecordById(int id, int fav) throws SqlException {
        try {
            queryRecordById(id);
        } catch (SqlException e) {
            throw new SqlException("update record not found");
        }
        return recordMapper.updateRecordById(id, fav);
    }

    @Override
    public Record queryRecordById(int id) throws SqlException {
        Record record = recordMapper.queryRecordById(id);
        if (record == null) {
            throw new SqlException("query record no found");
        }
        return record;
    }
    @Override
    public List<Record> queryRecordByUserId(int userId) throws SqlException {
        List<Record> recordList = recordMapper.queryRecordByUserId(userId);
        if (recordList == null) {
            throw new SqlException("query record no found");
        }
        return recordList;
    }
    @Override
    public Record queryRecordByUserIdAndSongId(int userId, int songId) throws SqlException {
        Record record = recordMapper.queryRecordByUserIdAndSongId(userId, songId);
        if (record == null) {
            throw new SqlException("query record no found");
        }
        return record;
    }
    @Override
    public List<History> queryRecordByUserIdWithPage(int userId, int pageStart, int pageSize) throws SqlException {
        List<History> queryList = recordMapper.queryRecordByUserIdWithPage(userId, pageStart, pageSize);
        if (queryList == null) {
            throw new SqlException("query record no found");
        }
        return queryList;
    }
    @Override
    public Integer queryCountByUserId(int userId) throws SqlException {
        Integer count = recordMapper.queryCountByUserId(userId);
        if (count == null) {
            throw new SqlException("query record count no found");
        }
        return count;
    }

    @Override
    public GetHistoryResData queryRecordSongByUserIdWithPageAndCount(int userId, int page, int pageSize) throws SqlException {
        List<History> queryList = queryRecordByUserIdWithPage(userId, (page - 1) * pageSize, pageSize);
        Integer count = queryCountByUserId(userId);
        return new GetHistoryResData(queryList, 1 + (count - 1) / QueryParm.PAGE_SIZE);
    }

    @Override
    public int deleteRecordByIdList(List<Integer> idList) throws SqlException {
        int theReturn = 0;
        for (Integer id : idList) {
            theReturn += deleteRecordById(id);
        }
        return theReturn;
    }
}
