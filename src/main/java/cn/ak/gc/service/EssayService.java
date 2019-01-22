package cn.ak.gc.service;

import cn.ak.gc.domain.entities.Comment;
import cn.ak.gc.domain.entities.Essay;
import cn.ak.gc.domain.entities.Praise;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface EssayService {
    void saveEssay(Essay essay);
    JSONArray getEssays(JSONObject json);
    void savePraise(Praise praise);
    void deletePraise(Praise praise);
    List<Comment> getComments(Comment comment);
    void saveComment(Comment comment);
    void deleteEssay(String pkBlog);
}
