package cn.ak.gc.service.impl;

import cn.ak.gc.commen.utils.CommonDAO;
import cn.ak.gc.domain.entities.Comment;
import cn.ak.gc.domain.entities.Essay;
import cn.ak.gc.domain.entities.Praise;
import cn.ak.gc.domain.repository.EssayRepository;
import cn.ak.gc.service.EssayService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
        String id = UUID.randomUUID().toString();
        essay.setPk_blog(id);
        essay.setCreationTime(new Date());
        Jedis jedis = new Jedis();
        jedis.lpush("essayInfo", JSON.toJSONString(essay));
        Essay newEssay = new Essay();
        newEssay.setPk_blog(id);
        commonDAO.insertVOWithPK(newEssay);
    }

    @Override
    public JSONArray getEssays(JSONObject json) {
        long begin = System.currentTimeMillis();
        Jedis jedis = new Jedis();
        String userName = json.getString("userName");
        String blogTitle = json.getString("blogTitle");
        List<Map<String, Object>> list = essayRepository.getEssays(userName);
        List<String> essayInfo = jedis.lrange("essayInfo", 0, -1);
        long redis = System.currentTimeMillis();
        System.out.println("redis耗费时间：" + (redis - begin));
        JSONArray array = new JSONArray();
        essayInfo.forEach(essay -> {
            JSONObject jsonEssay = JSONObject.parseObject(essay);
            if (jsonEssay.getString("blogTitle").contains(blogTitle)) { // 搜索关键词
                for (Map<String, Object> aList : list) {
                    if (jsonEssay.getString("pk_blog").equals(aList.get("pk_blog"))) {
                        jsonEssay.put("commentNum", aList.get("commentNum"));
                        jsonEssay.put("praiseNum", aList.get("praiseNum"));
                        jsonEssay.put("isPraised", aList.get("isPraised"));
                        break;
                    }
                }
                array.add(jsonEssay);
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("遍历耗费时间：" + (end - redis));
        System.out.println("总共耗费时间：" + (end - begin));
        return array;
    }

    @Override
    public void savePraise(Praise praise) {
        praise.setPk_praise(UUID.randomUUID().toString());
        praise.setCreationTime(new Date());
        praiseCommonDAO.insertVOWithPK(praise);
    }

    @Override
    public void deletePraise(Praise praise) {
        JSONObject params = JSONObject.parseObject(JSON.toJSONString(praise));
        praiseCommonDAO.deleteWithParams("blog_praise", params);
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

    @Override
    public void deleteEssay(String pkBlog) {
        Essay essay = new Essay();
        JSONObject comment = new JSONObject();
        JSONObject praise = new JSONObject();
        essay.setPk_blog(pkBlog);
        comment.put("pk_blog", pkBlog);
        praise.put("pk_blog", pkBlog);
        commonDAO.deleteVO(essay); // 删除文章,评论和点赞
        commentCommonDAO.deleteWithParams("blog_comment", comment);
        praiseCommonDAO.deleteWithParams("blog_praise", praise);
        Jedis jedis = new Jedis();
        List<String> list = jedis.lrange("essayInfo", 0, -1);
        String currentEssay = list.stream().filter(item -> item.contains(pkBlog))
                .findAny().orElse(""); // 如果没有顺序上的需求,findAny会比findFirst快
        jedis.lrem("essayInfo", 0, currentEssay);
    }
}
