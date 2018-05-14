package com.bblog.model.POJO;

//import javax.persistence.Column;
//import javax.persistence.Id;
//import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by moutian on 2018/2/28 0028.
 */

public class Comment implements Serializable {
    private String cId;
    private String aId;
    private String bId;
    private String comment;
    private Date createTime;
    private String available;
    private String aName;

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cId='" + cId + '\'' +
                ", aId='" + aId + '\'' +
                ", bId='" + bId + '\'' +
                ", comment='" + comment + '\'' +
                ", createTime=" + createTime +
                ", available='" + available + '\'' +
                ", aName='" + aName + '\'' +
                '}';
    }
}

