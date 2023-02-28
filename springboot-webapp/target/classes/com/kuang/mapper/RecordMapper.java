package com.kuang.mapper;

import com.kuang.dto.history.History;
import com.kuang.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecordMapper {
    int addRecord(Record record);

    int deleteRecordById(int id);

    Record queryRecordById(int id);
    List<Record> queryRecordByUserId(int userId);

    List<History> queryRecordByUserIdWithPage(int userId, int pageStart, int pageSize);

    Integer queryCountByUserId(int userId);

    int updateRecordById(int id, int fav);
}
