package com.kuang.controller;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.kuang.config.MyConfig;
import com.kuang.dto.history.GetHistoryResData;
import com.kuang.dto.history.PutHistoryReq;
import com.kuang.dto.history.DeleteHistoryReq;
import com.kuang.dto.GeneralRes;
import com.kuang.exception.SqlException;
import com.kuang.pojo.Record;
import com.kuang.pojo.Song;
import com.kuang.service.RecordService;
import com.kuang.service.SongService;
import com.kuang.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class RecordController {

    @Autowired
    private MyConfig myConfig;
    @Autowired
    @Qualifier("songServiceImpl")
    private SongService songService;
    @Autowired
    @Qualifier("recordServiceImpl")
    private RecordService recordService;

    @GetMapping("user/history")
    @ResponseBody
    public GeneralRes getHistory(@RequestParam int page, @RequestHeader("Authorization") String token) {
        try {
            int userId = JwtUtil.getUserId(token);
            GetHistoryResData getHistoryResData = recordService.queryRecordSongByUserIdWithPageAndCount(userId, page, myConfig.getRecordNumberPerPage());
            return GeneralRes.GoodRes200(getHistoryResData);
        } catch (JWTDecodeException e) {
            e.printStackTrace();
            return GeneralRes.BackendErrorRes500("util jwt error", "util jwt error");
        } catch (SqlException e) {
            e.printStackTrace();
            return GeneralRes.BackendErrorRes500(e.getMessage(), e.getMessage());
        }
    }

    @DeleteMapping("user/history")
    @ResponseBody
    public GeneralRes deleteHistory(@RequestBody DeleteHistoryReq deleteHistoryReq, @RequestHeader("Authorization") String token) {
        try {
            if (deleteHistoryReq.getType() == 0) {
                recordService.deleteRecordById(deleteHistoryReq.getId());
            } else {
                recordService.deleteRecordByIdList(deleteHistoryReq.getList());
            }
            return GeneralRes.GoodRes200(null);
        } catch (SqlException e) {
            e.printStackTrace();
            return GeneralRes.BackendErrorRes500(e.getMessage(), e.getMessage());
        }
    }

    @PutMapping("user/history/lc")
    @ResponseBody
    public GeneralRes putHistory(@RequestBody PutHistoryReq putHistoryReq, @RequestHeader("Authorization") String token) {
        int id = putHistoryReq.getId();
        int fav = putHistoryReq.getFav();
        try {
            recordService.updateRecordById(id, fav);
            Record record = recordService.queryRecordById(id);
            Song song = songService.querySongById(record.getSongId());
            return GeneralRes.GoodRes200(song);
        } catch (SqlException e) {
            e.printStackTrace();
            return GeneralRes.BackendErrorRes500(e.getMessage(), e.getMessage());
        }
    }
}
