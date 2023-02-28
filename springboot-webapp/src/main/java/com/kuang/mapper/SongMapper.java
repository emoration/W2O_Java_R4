package com.kuang.mapper;

import com.kuang.pojo.Song;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SongMapper {
    int addSong(Song song);
    int addSongIgnore(Song song);
    int deleteSongById(int id);
    Song querySongById(int id);
    Song querySongByRid(int rid);
    List<Song> querySongListByName(String name);
}
