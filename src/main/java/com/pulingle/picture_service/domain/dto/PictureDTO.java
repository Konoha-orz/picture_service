package com.pulingle.picture_service.domain.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by @杨健 on 2018/4/2 14:53
 *
 * @Des: 图片上传传输对象
 */

public class PictureDTO implements Serializable{
    /**
     * 图片Id
     */
    private long pictureId;

    /**
     * 用户Id
     */
    private long userId;

    /**
     * 标题
     */
    private String  title;

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
     * 图片配字内容
     */
    private String content;

    /**
     * 若图片为相册图片，则有对应相册id
     */
    private String albumId;

    /**
     * 上传文件
     */
    private MultipartFile file;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getContent() {
        return content;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
