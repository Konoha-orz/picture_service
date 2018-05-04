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
     * 用户Id
     */
    private long userId;

    /**
     * 上传文件
     */
    private MultipartFile file;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
