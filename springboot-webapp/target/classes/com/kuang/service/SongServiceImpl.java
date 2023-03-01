package com.kuang.service;

import com.kuang.exception.KuwoApiException;
import com.kuang.exception.SqlException;
import com.kuang.mapper.SongMapper;
import com.kuang.pojo.Song;
import com.kuang.util.KuwoAPI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongServiceImpl implements SongService {

    @Autowired
    private SongMapper songMapper;

    @Override
    public int addSong(Song song) throws SqlException {
        return songMapper.addSong(song);
    }

    @Override
    public int addSongIgnore(Song song) {
        return songMapper.addSongIgnore(song);
    }

    @Override
    public int deleteSongById(int id) throws SqlException {
        try {
            querySongById(id);
        } catch (SqlException e) {
            throw new SqlException("delete song not found");
        }
        return songMapper.deleteSongById(id);
    }

    @Override
    public Song querySongById(int id) throws SqlException {
        Song song = songMapper.querySongById(id);
        if (song == null) {
            throw new SqlException("query song not found");
        }
        return song;
    }

    @Override
    public Song querySongByRid(int rid) throws SqlException {
        Song song = songMapper.querySongByRid(rid);
        if (song == null) {
            throw new SqlException("query song not found");
        }
        return song;
    }

    @Override
    public List<Song> querySongListByName(String name) throws SqlException {
        List<Song> songList = songMapper.querySongListByName(name);
        if (songList == null) {
            throw new SqlException("query song list not found");
        }
        return songList;
    }

    @Override
    public int addSongListIgnore(List<Song> songList) {
        int theReturn = 0;
        for (Song song : songList) {
            theReturn += songMapper.addSongIgnore(song);
        }
        return theReturn;
    }

    @Override
    public List<Song> querySongListByNameFromDatabase(String name) throws SqlException {
        return querySongListByName(name);
    }

    @Override
    public List<Song> querySongListByNameFromApi(String name) throws KuwoApiException {
        return KuwoAPI.searchSongListApi(name, "1");
    }
}
