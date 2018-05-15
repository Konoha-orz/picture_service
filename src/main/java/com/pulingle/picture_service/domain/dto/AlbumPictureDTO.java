package com.pulingle.picture_service.domain.dto;

import com.pulingle.picture_service.domain.entity.Picture;

import java.io.Serializable;
import java.util.ArrayList;

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
     *  图片信息数组
     */
    private ArrayList<Picture> pictureList;

    /**
     * 每个月显示的图片数
     */
    private int pictureNum;

    /**
     * 当前页面数
     */
    private int currentPage;

    /**
     * 页面显示几个月的图片
     */
    private int pageSize;

    /**
     * 月份
     */
    private String month;



    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public ArrayList<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(ArrayList<Picture> pictureList) {
        this.pictureList = pictureList;
    }

    public int getPictureNum() {
        return pictureNum;
    }

    public void setPictureNum(int pictureNum) {
        this.pictureNum = pictureNum;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }



}
