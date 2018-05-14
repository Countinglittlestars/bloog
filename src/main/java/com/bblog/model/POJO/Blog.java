package com.bblog.model.POJO;
//
//import javax.persistence.Column;
//import javax.persistence.Id;
//import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by moutian on 2018/2/28 0028.
 */
//@Table(name = "blog_blog")
public class Blog implements Serializable {
//    @Id

    private String blogId;
//    private String blogId;
    private String title;
    private String col;
    private String sign;
    private String content;
    private String summary;
    private Date releaseDate;
    private Integer clickHit;
    private Integer replyHit;
    private Date updateTime;

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

//    public Integer getBlogId() {
//        return blogId;
//
//
//    }


//        public void setBlogId(Integer blogId) {
//        this.blogId = blogId;
//    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getClickHit() {
        return clickHit;
    }

    public void setClickHit(Integer clickHit) {
        this.clickHit = clickHit;
    }

    public Integer getReplyHit() {
        return replyHit;
    }

    public void setReplyHit(Integer replyHit) {
        this.replyHit = replyHit;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId='" + blogId + '\'' +
                ", title='" + title + '\'' +
                ", col='" + col + '\'' +
                ", sign='" + sign + '\'' +
                ", content='" + content + '\'' +
                ", summary='" + summary + '\'' +
                ", releaseDate=" + releaseDate +
                ", clickHit=" + clickHit +
                ", replyHit=" + replyHit +
                ", updateTime=" + updateTime +
                '}';
    }
}