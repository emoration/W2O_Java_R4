package com.kuang.service;

import com.kuang.exception.KuwoApiException;
import com.kuang.exception.SqlException;
import com.kuang.pojo.Song;

import java.util.List;

public interface SongService {
    int addSong(Song song)throws SqlException;
    int addSongIgnore(Song song);

    int deleteSongById(int id)throws SqlException;

    Song querySongById(int id);
    Song querySongByRid(int rid);

    List<Song> querySongListByName(String name)throws SqlException;


    int addSongListIgnore(List<Song> songList);

    List<Song> querySongListByNameFromDatabase(String name)throws SqlException;
    List<Song> querySongListByNameFromApi(String name)throws KuwoApiException;


}
