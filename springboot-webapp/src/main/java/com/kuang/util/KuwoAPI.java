package com.kuang.util;

import com.kuang.exception.KuwoApiException;
import com.kuang.pojo.Song;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KuwoAPI {

    public static List<Song> searchSongListApi(String songName, String pn) throws KuwoApiException {
        try {

            RestTemplate restTemplate = new RestTemplate();
            String url = "http://www.kuwo.cn/api/www/search/searchMusicBykeyWord" +
                    "?key={key}&pn={pn}&rn={rn}&httpsStatus={httpsStatus}&reqId={reqId}";
//        http://www.kuwo.cn/api/www/search/searchMusicBykeyWord?key=b&pn=1&rn=20&httpsStatus=1&reqId=0dfc19f0-b722-11ed-9c6e-c11a80c472e9
            //①：请求头
            MultiValueMap<String, String> headers = new HttpHeaders();
//        headers.add("header-1", "V1");
//        headers.add("header-2", "Spring");
//        headers.add("header-2", "SpringBoot");
            headers.add("Connection", "keep-alive");
            headers.add("Accept", "application/json, text/plain, */*");
            headers.add("csrf", "YYPYR01LPK");
            headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36 Core/1.94.192.400 QQBrowser/11.5.5250.400");
            headers.add("Referer", "http://www.kuwo.cn/search/list?key=" + songName);
            headers.add("Accept-Language", "zh-CN,zh;q=0.9");
            headers.add("Cookie", "_ga=GA1.2.1452806546.1675305690; Hm_lvt_cdb524f42f0ce19b169a8071123a4797=1675305690,1676885802,1677558385; _gid=GA1.2.985535456.1677558386; Hm_lpvt_cdb524f42f0ce19b169a8071123a4797=1677558397; kw_token=YYPYR01LPK; _gat=1");

            //②：url中的2个参数
            Map<String, String> uriVariables = new HashMap<>();
            uriVariables.put("key", songName);
            uriVariables.put("pn", pn);
            uriVariables.put("rn", "20");
            uriVariables.put("httpsStatus", "1");
            uriVariables.put("reqId", "0dfc19f0-b722-11ed-9c6e-c11a80c472e9");
            //③：HttpEntity：HTTP实体，内部包含了请求头和请求体
            HttpEntity requestEntity = new HttpEntity(
                    null,//body部分，get请求没有body，所以为null
                    headers //头
            );
            //④：使用exchange发送请求
            ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange(
                    url, //url
                    HttpMethod.GET, //请求方式
                    requestEntity, //请求实体（头、body）
                    new ParameterizedTypeReference<Map<String, Object>>() {
                    }
                    ,//返回的结果类型
                    uriVariables //url中的占位符对应的值
            );
            Map<String, Object> result = responseEntity.getBody();
            return parseSongByMap(result);
        } catch (RuntimeException e) {
            throw new KuwoApiException(e);
        }
    }

    private static List<Song> parseSongByMap(Map<String, Object> result) {
        List<Song> songList = new ArrayList<>();
        Map<String, Object> data = (Map<String, Object>) result.get("data");
        List<Map<String, Object>> list = (List<Map<String, Object>>) data.get("list");
        for (Map<String, Object> music : list) {
            Song song = new Song();
            song.setName((String) music.get("name"));
            song.setArtist((String) music.get("artist"));
            song.setAlbum((String) music.get("album"));
            song.setRid((Integer) music.get("rid"));//duration
            song.setDuration(secondToMinuteAndSecond((Integer) music.get("duration")));
            songList.add(song);
        }
        return songList;
    }

    private static String secondToMinuteAndSecond(int second) {
        int minute = second / 60;
        second %= 60;
        return minute + ":" + second;
    }
}
