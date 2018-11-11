package cn.ak.gc.service;

import cn.ak.gc.domain.entities.Comment;
import cn.ak.gc.domain.entities.Essay;
import cn.ak.gc.domain.entities.Praise;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface EssayService {
    void saveEssay(Essay essay);
    List<Map<String, Object>> getEssays(JSONObject json);
    void savePraise(Praise praise);
    List<Comment> getComments(Comment comment);
    void saveComment(Comment comment);
}
