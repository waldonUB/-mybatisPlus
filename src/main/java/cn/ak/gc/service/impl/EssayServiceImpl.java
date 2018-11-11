package cn.ak.gc.service.impl;

import cn.ak.gc.commen.utils.CommonDAO;
import cn.ak.gc.domain.entities.Comment;
import cn.ak.gc.domain.entities.Essay;
import cn.ak.gc.domain.entities.Praise;
import cn.ak.gc.domain.repository.EssayRepository;
import cn.ak.gc.service.EssayService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.*;

@Service
public class EssayServiceImpl implements EssayService {
    @Autowired
    CommonDAO<Essay> commonDAO;
    @Autowired
    CommonDAO<Praise> praiseCommonDAO;
    @Autowired
    CommonDAO<Comment> commentCommonDAO;
    @Autowired
    EssayRepository essayRepository;

    @Override
    public void saveEssay(Essay essay) {
        essay.setPk_blog(UUID.randomUUID().toString());
        essay.setCreationTime(new Date());
        Map<String, String> map = new HashMap<>();
        map.put("headImg", essay.getHeadImg());
        map.put("blogContent", essay.getBlogContent());
        Jedis jedis = new Jedis();
        commonDAO.insertVOWithPK(essay);
    }

    @Override
    public List<Map<String, Object>> getEssays(JSONObject json) {
        String userName = json.getString("userName");
        return essayRepository.getEssays(userName);
    }

    @Override
    public void savePraise(Praise praise) {
        praise.setPk_praise(UUID.randomUUID().toString());
        praise.setCreationTime(new Date());
        praiseCommonDAO.insertVOWithPK(praise);
    }

    @Override
    public List<Comment> getComments(Comment comment) {
        JSONObject json = new JSONObject();
        json.put("pk_blog", comment.getPk_blog());
        return commentCommonDAO.getEntities(comment, json);
    }

    @Override
    public void saveComment(Comment comment) {
        comment.setPk_comment(UUID.randomUUID().toString());
        comment.setCmTime(new Date());
        comment.setCreationTime(new Date());
        commentCommonDAO.insertVOWithPK(comment);
    }
}
