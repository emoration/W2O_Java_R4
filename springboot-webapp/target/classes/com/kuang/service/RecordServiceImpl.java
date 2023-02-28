package com.kuang.service;

import com.kuang.constant.QueryParm;
import com.kuang.dto.history.History;
import com.kuang.dto.response.GetHistoryRes;
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
    public int addRecord(Record record) {
        return recordMapper.addRecord(record);
    }

    @Override
    public int deleteRecordById(int id) {
        return recordMapper.deleteRecordById(id);
    }

    @Override
    public int deleteRecordByIdList(List<Integer> idList) {
        int theReturn = 0;
        for (Integer id : idList) {
            theReturn += deleteRecordById(id);
        }
        return theReturn;
    }

    @Override
    public List<Record> queryRecordByUserId(int userId) {
        return recordMapper.queryRecordByUserId(userId);
    }

    @Override
    public GetHistoryRes queryRecordSongByUserIdWithPage(int userId, int page, int pageSize) {
        List<History> queryList = recordMapper.queryRecordByUserIdWithPage(userId, (page - 1) * pageSize, pageSize);
        Integer count = recordMapper.queryCountByUserId(userId);
        return new GetHistoryRes(queryList, 1 + (count - 1) / QueryParm.PAGE_SIZE);
    }

    @Override
    public Record queryRecordById(int id) {
        return recordMapper.queryRecordById(id);
    }

    @Override
    public int updateRecordById(int id, int fav) {
        return recordMapper.updateRecordById(id, fav);
    }
}
