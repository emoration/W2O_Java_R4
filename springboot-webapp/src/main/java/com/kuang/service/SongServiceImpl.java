package com.kuang.service;

import com.kuang.mapper.SongMapper;
import com.kuang.pojo.Song;
import com.kuang.utils.KuwoAPI;
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
    public int addSong(Song song) {
        return songMapper.addSong(song);
    }

    @Override
    public int addSongIgnore(Song song) {
        return songMapper.addSongIgnore(song);
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
    public int deleteSongById(int id) {
        return songMapper.deleteSongById(id);
    }

    @Override
    public Song querySongById(int id) {
        return songMapper.querySongById(id);
    }

    @Override
    public Song querySongByRid(int rid) {
        return songMapper.querySongByRid(rid);
    }

    @Override
    public List<Song> querySongListByNameFromDatabase(String name) {
        return songMapper.querySongListByName(name);
    }

    @Override
    public List<Song> querySongListByNameFromApi(String name) {
        List<Song> songList = KuwoAPI.searchSongListApi(name, "1");
        addSongListIgnore(songList);
        return songList;
    }

}
