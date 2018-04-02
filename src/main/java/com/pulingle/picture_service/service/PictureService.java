package com.pulingle.picture_service.service;

import com.pulingle.picture_service.domain.dto.PictureDTO;
import com.pulingle.picture_service.domain.dto.RespondBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by 杨健 on 2018/3/30
 *
 * @Des: 图片上传服务
 */

public interface PictureService {
    RespondBody uploadPicture(PictureDTO pictureDTO) ;
}
