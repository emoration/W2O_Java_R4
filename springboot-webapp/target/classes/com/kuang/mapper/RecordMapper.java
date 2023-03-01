package com.kuang.mapper;

import com.kuang.dto.history.History;
import com.kuang.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecordMapper {
    // 当前禁止多次添加，但有可能多次下载，注意判断
    int addRecord(Record record);

    // 可能找不到，注意判断
    int deleteRecordById(int id);

    // 可能找不到，注意判断
    int updateRecordById(int id, int fav);

    // 可能找不到，注意判断
    Record queryRecordById(int id);
    // 可能找不到，注意判断
    List<Record> queryRecordByUserId(int userId);
    // 可能找不到，注意判断
    Record queryRecordByUserIdAndSongId(int userId, int songId);
    // 可能找不到，注意判断
    List<History> queryRecordByUserIdWithPage(int userId, int pageStart, int pageSize);
    // 可能找不到，注意判断
    Integer queryCountByUserId(int userId);

}
