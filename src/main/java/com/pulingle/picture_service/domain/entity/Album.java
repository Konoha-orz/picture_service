package com.pulingle.picture_service.domain.entity;

import java.io.Serializable;

/**
 * Created by @杨健 on 2018/4/4 12:32
 *
 * @Des: 相册实体类
 */

public class Album implements Serializable{

    /**
     * 相册id
     */
    private long albumId;

    /**
     * 用户Id
     */
    private long userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片Id列表
     */
    private String pictureList;

    /**
     * 叙述/内容
     */
    private String content;

    /**
     * 相册背景
     */
    private String background;

    /**
     * 相册布局
     */
    private String layout;

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictureList() {
        return pictureList;
    }

    public void setPictureList(String pictureList) {
        this.pictureList = pictureList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", pictureList='" + pictureList + '\'' +
                ", content='" + content + '\'' +
                ", background='" + background + '\'' +
                ", layout='" + layout + '\'' +
                '}';
    }
}
