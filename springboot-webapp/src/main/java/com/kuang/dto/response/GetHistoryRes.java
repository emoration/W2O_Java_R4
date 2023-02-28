package com.kuang.dto.response;

import com.kuang.dto.history.History;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetHistoryRes {
    List<History> list;
    private int count;
}

