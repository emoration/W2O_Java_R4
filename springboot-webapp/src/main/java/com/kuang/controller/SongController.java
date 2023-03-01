package com.kuang.controller;

import com.kuang.config.MyConfig;
import com.kuang.dto.GeneralRes;
import com.kuang.exception.KuwoApiException;
import com.kuang.exception.SqlException;
import com.kuang.pojo.Record;
import com.kuang.pojo.Song;
import com.kuang.service.RecordService;
import com.kuang.service.SongService;
import com.kuang.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class SongController {

    @Autowired
    @Qualifier("songServiceImpl")
    private SongService songService;
    @Autowired
    @Qualifier("recordServiceImpl")
    private RecordService recordService;

    @Autowired
    private MyConfig myConfig;

    @RequestMapping("search")
    @ResponseBody
    public GeneralRes search(@RequestParam("text") String text, @RequestHeader("Authorization") String token) {
        try {
            List<Song> songList;
            if (myConfig.isSearchFromTrueKuwoApiOrFalseDatabase()) {
                songList = songService.querySongListByNameFromApi(text);
                if(myConfig.isAddApiSearchResultToDatabase()) {
                    songService.addSongListIgnore(songList);
                }
            } else {
                songList = songService.querySongListByNameFromDatabase(text);
            }
            Map<String, Object> data = new HashMap<>();
            data.put("list", songList);
            return GeneralRes.GoodRes200(data);
        } catch (SqlException | KuwoApiException e) {
            e.printStackTrace();
            return GeneralRes.BackendErrorRes500(e.getMessage(), e.getMessage());
        }
    }

    @GetMapping("/search/download/{rid}")
    public ResponseEntity<InputStreamResource> downSong(@PathVariable String rid, @RequestHeader("Authorization") String token) throws IOException, SqlException {

        int userId = JwtUtil.getUserId(token);
        int songId = songService.querySongByRid(Integer.parseInt(rid)).getId();
        Record record = new Record(0, userId, songId, 0);
        if (recordService.queryRecordByUserIdAndSongId(userId, songId) == null) {
            try {
                recordService.addRecord(record);
            } catch (SqlException e) {
                System.err.println(e);
            }
        }
        String musicPath = ResourceUtils.getURL("classpath:").getPath().substring(1) + "songs/";
        String fileType = ".mp3";
        InputStreamResource isr = new InputStreamResource(Files.newInputStream(Paths.get(musicPath + rid + fileType)));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("audio/mpeg"))
                .header("Content-disposition", "attachment; filename=" + rid + fileType)
                .body(isr);
    }
}
