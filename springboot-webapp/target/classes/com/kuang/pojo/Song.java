package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
//    {
//        "name": "兰亭序",
//            "artist": "周杰伦",
//            "album": "魔杰座",
//            "duration": "04:13",
//            "rid": 1
//    }
    private int id;
    private String name;
    private String artist;
    private String album;
    private String duration;
    private int rid;
}
