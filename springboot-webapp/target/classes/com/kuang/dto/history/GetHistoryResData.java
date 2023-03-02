package com.kuang.dto.history;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 返回 get历史记录的response参数的data参数 的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetHistoryResData {
    List<History> list;
    int count;
}
