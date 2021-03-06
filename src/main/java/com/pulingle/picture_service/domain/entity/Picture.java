package com.pulingle.picture_service.domain.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by @杨健 on 2018/4/2 13:11
 *
 * @Des: Picture实体类
 */

public class Picture implements Serializable{
    /**
     * 图片Id
     */
    private long pictureId;

    /**
     * 用户Id
     */
    private long userId;


    /**
     * 图片文件名
     */
    private String pictureName;

    /**
     * 图片url
     */
    private String pictureUrl;

    /**
     * 上传时间
     */
    private Date uploadTime;

    /**
     * 文件大小
     */
    private String size;

    /**
     * 图片类型
     */
    private String type;

    public long getPictureId() {
        return pictureId;
    }

    public void setPictureId(long pictureId) {
        this.pictureId = pictureId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
