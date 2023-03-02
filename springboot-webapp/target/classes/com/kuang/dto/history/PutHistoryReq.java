package com.kuang.dto.history;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接收 put历史记录的request参数 的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PutHistoryReq {
    private int id;
    private int fav;
}
