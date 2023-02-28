package com.kuang.service;

import com.kuang.pojo.Song;

import java.util.List;

public interface SongService {
    int addSong(Song song);

    int addSongIgnore(Song song);

    int addSongListIgnore(List<Song> songList);

    int deleteSongById(int id);

    Song querySongById(int id);

    Song querySongByRid(int rid);

    List<Song> querySongListByNameFromDatabase(String name);

    List<Song> querySongListByNameFromApi(String name);

}
