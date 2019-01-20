package cn.ak.gc.controller;

import cn.ak.gc.domain.entities.Comment;
import cn.ak.gc.domain.entities.Essay;
import cn.ak.gc.domain.entities.Praise;
import cn.ak.gc.domain.vo.ReturnModel;
import cn.ak.gc.service.EssayService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/essay")
public class EssayController {

    @Autowired
    EssayService essayService;

    /**
     * 保存文章
     * @param essay
     * @return 返回保存是否成功的状态
     * */
    @RequestMapping("/saveEssay")
    @ResponseBody
    public ReturnModel saveEssay(@RequestBody Essay essay) {
        ReturnModel model = new ReturnModel();
        essayService.saveEssay(essay);
        model.setSuccess(true);
        return model;
    }

    /**
     * 查询文章
     * @param json
     * @return 返回文章列表
     * */
    @RequestMapping("/getEssays")
    public ReturnModel getEssays(@RequestBody JSONObject json) {
        ReturnModel model = new ReturnModel();
        JSONArray list = essayService.getEssays(json);
        model.setData(list);
        model.setSuccess(true);
        return model;
    }

    /**
     * 点赞
     * @param praise
     * @return 返回是否成功状态
     * */
    @RequestMapping("/savePraise")
    public ReturnModel savePraise(@RequestBody Praise praise) {
        ReturnModel model = new ReturnModel();
        essayService.savePraise(praise);
        model.setSuccess(true);
        return model;
    }

    /**
     * 取消点赞
     * @param praise
     * @return 返回是否成功状态
     * */
    @RequestMapping("/deletePraise")
    public ReturnModel deletePraise(@RequestBody Praise praise) {
        ReturnModel model = new ReturnModel();
        essayService.deletePraise(praise);
        model.setSuccess(true);
        return model;
    }

    /**
     * 查询评论
     * @param comment
     * @return 返回该文章下的评论信息
     * */
    @RequestMapping("/getComments")
    public ReturnModel savePraise(@RequestBody Comment comment) {
        ReturnModel model = new ReturnModel();
        List<Comment> list = essayService.getComments(comment);
        model.setData(list);
        model.setSuccess(true);
        return model;
    }

    /**
     * 发布评论
     * @param comment
     * @return 返回是否成功状态
     * */
    @RequestMapping("/saveComment")
    public ReturnModel saveComment(@RequestBody Comment comment) {
        ReturnModel model = new ReturnModel();
        essayService.saveComment(comment);
        model.setSuccess(true);
        return model;
    }
}
