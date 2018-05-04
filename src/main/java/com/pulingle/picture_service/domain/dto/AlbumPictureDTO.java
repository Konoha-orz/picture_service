package com.pulingle.picture_service.domain.dto;

import java.io.Serializable;

/**
 * Created by @杨健 on 2018/5/1 18:08
 *
 * @Des: 照片墙图片DTO
 */

public class AlbumPictureDTO implements Serializable {
    /**
     * 用户ID
     */
    private long userId;

    /**
     *  图片URL数组
     */
    private String[] pictureList;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String[] getPictureList() {
        return pictureList;
    }

    public void setPictureList(String[] pictureList) {
        this.pictureList = pictureList;
    }
}
