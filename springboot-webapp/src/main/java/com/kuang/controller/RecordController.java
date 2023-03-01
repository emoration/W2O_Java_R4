package com.kuang.controller;

import com.kuang.constant.QueryParm;
import com.kuang.dto.history.PutHistoryReq;
import com.kuang.dto.history.DeleteHistoryReq;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class RecordController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("songServiceImpl")
    private SongService songService;
    @Autowired
    @Qualifier("recordServiceImpl")
    private RecordService recordService;

    @GetMapping("user/history")
    @ResponseBody
    public GeneralRes getHistory(@RequestParam int page, @RequestHeader("Authorization") String token) throws SqlException {
        GeneralRes res = new GeneralRes(200, "success", null, "");
//        String username = Token.parseToken(token);
//        int userId = userService.queryUserByName(username).getId();
        int userId = JwtUtil.getUserId(token);
        res.setData(recordService.queryRecordSongByUserIdWithPageAndCount(userId, page, QueryParm.PAGE_SIZE));
        return res;
    }

    @DeleteMapping("user/history")
    @ResponseBody
    public GeneralRes deleteHistory(@RequestBody DeleteHistoryReq deleteHistoryReq, @RequestHeader("Authorization") String token) throws SqlException {
        GeneralRes res = new GeneralRes(200, "success", null, "");
        if (deleteHistoryReq.getType() == 0) {
            recordService.deleteRecordById(deleteHistoryReq.getId());
        } else {
            recordService.deleteRecordByIdList(deleteHistoryReq.getList());
        }
        return res;
    }

    @PutMapping("user/history/lc")
    @ResponseBody
    public GeneralRes putHistory(@RequestBody PutHistoryReq putHistoryReq, @RequestHeader("Authorization") String token) throws SqlException {
        GeneralRes res = new GeneralRes(200, "success", null, "");
        int id = putHistoryReq.getId();
        int fav = putHistoryReq.getFav();
        recordService.updateRecordById(id, fav);
        Record record = recordService.queryRecordById(id);
        Song song = songService.querySongById(record.getSongId());
        res.setData(song);
        return res;
    }
}
