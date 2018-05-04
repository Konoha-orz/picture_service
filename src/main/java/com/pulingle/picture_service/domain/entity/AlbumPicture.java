package com.pulingle.picture_service.domain.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by @杨健 on 2018/5/1 17:18
 *
 * @Des: 照片墙照片实体类
 */

public class AlbumPicture implements Serializable {
    /**
     * 照片id
     */
    private String albumPictureId;

    /**
     * 用户id
     */
    private long userId;

    /**
     *  照片URL
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

    public String getAlbumPictureId() {
        return albumPictureId;
    }

    public void setAlbumPictureId(String albumPictureId) {
        this.albumPictureId = albumPictureId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
