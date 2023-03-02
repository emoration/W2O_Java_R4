package com.kuang.dto.history;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 接收 delete历史记录的request参数 的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteHistoryReq {
    int type;
    int id;
    List<Integer> list;
}
