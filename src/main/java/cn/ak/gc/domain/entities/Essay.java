package cn.ak.gc.domain.entities;

import cn.ak.gc.commen.annotation.Column;
import cn.ak.gc.commen.annotation.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 社区话题模块实体类
 * @author waldon
 * */
@Entity(tableName = "blog_info", primaryKey = "pk_blog")
public class Essay implements Serializable {
    /** 话题主键 */
    private String pk_blog;
    /** 用户主键 */
    private String userId;
    /** 用户名 */
    private String userName;
    /** 用户头像 */
    private String headImg;
    /** 话题标题 */
    private String blogTitle;
    /** 话题内容 */
    private String blogContent;
    /** 话题分类 */
    private String blogClassify;
    /**创建人*/
    @Column(column = "creator")
    private String creator;
    /**创建时间*/
    @Column(column = "creation_time")
    private Date creationTime;
    /**修改人*/
    @Column(column = "modifier")
    private String modifier;
    /**修改时间*/
    @Column(column = "modify_time")
    private Date modifyTime;

    public String getPk_blog() {
        return pk_blog;
    }

    public void setPk_blog(String pk_blog) {
        this.pk_blog = pk_blog;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getBlogClassify() {
        return blogClassify;
    }

    public void setBlogClassify(String blogClassify) {
        this.blogClassify = blogClassify;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
