package com.kuang.controller;

import com.kuang.dto.GeneralRes;
import com.kuang.exception.SqlException;
import com.kuang.pojo.Record;
import com.kuang.pojo.Song;
import com.kuang.service.RecordService;
import com.kuang.service.SongService;
import com.kuang.service.UserService;
import com.kuang.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    @Qualifier("userServiceImpl")
    private UserService userService;
    @Autowired
    @Qualifier("songServiceImpl")
    private SongService songService;
    @Autowired
    @Qualifier("recordServiceImpl")
    private RecordService recordService;

    @RequestMapping("search")
    @ResponseBody
    public GeneralRes search(@RequestParam("text") String text, @RequestHeader("Authorization") String token) {
        GeneralRes res = new GeneralRes(200, "success", null, "");
        List<Song> songList = songService.querySongListByNameFromApi(text);
//        List<Song> songList = KuwoAPI.searchSongListApi(text, "1");
        Map<String, Object> data = new HashMap<>();
        data.put("list", songList);
        res.setData(data);
        return res;
    }

    @GetMapping("/search/download/{rid}")
    public ResponseEntity<InputStreamResource> downSong(@PathVariable String rid, @RequestHeader("Authorization") String token) throws IOException, SqlException {
//        String username = Token.parseToken(token);
//        int userId = userService.queryUserByName(username).getId();
        int userId = JwtUtil.getUserId(token);
        int songId = songService.querySongByRid(Integer.parseInt(rid)).getId();
        Record record = new Record(0, userId, songId, 0);
        try {
            recordService.addRecord(record);
        } catch (SqlException e) {
            System.err.println(e);
        }
        String fileType = ".mp3";
        InputStreamResource isr = new InputStreamResource(Files.newInputStream(Paths.get("D:\\0\\songs\\" + rid + fileType)));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("audio/mpeg"))
                .header("Content-disposition", "attachment; filename=" + rid + fileType)
                .body(isr);
    }
}
