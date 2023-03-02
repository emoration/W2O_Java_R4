package com.kuang.dto.history;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作为 包含音乐信息的历史记录 的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class History {

    private String name;
    private String artist;
    private String album;
    private String duration;
    private int fav;
    private int rid;
    private int id;
}
