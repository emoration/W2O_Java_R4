package com.kuang.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class UserSong {
    private String name;
    private String artist;
    private String album;
    private String duration;
    private int fav;
    private int rid;
    private int id;
}
