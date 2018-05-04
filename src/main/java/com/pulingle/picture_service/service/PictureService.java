package com.pulingle.picture_service.service;

import com.pulingle.picture_service.domain.dto.AlbumPictureDTO;
import com.pulingle.picture_service.domain.dto.PictureDTO;
import com.pulingle.picture_service.domain.dto.RespondBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by 杨健 on 2018/3/30
 *
 * @Des: 图片服务
 */

public interface PictureService {
    /**
    * @param: pictureDTO（图片传输对象）
    * @return: respondBody
    * @Des: 上传图片服务
    */
    RespondBody uploadPicture(PictureDTO pictureDTO) ;

    /**
     * @param: pictureDTO（图片传输对象）
     * @return: respondBody
     * @Des: 上传照片墙图片服务
     */
    RespondBody uploadAlbumPicture(PictureDTO pictureDTO) ;

    /**
    * @param: albumPictureDTO
    * @return: RespondBody
    * @Des: 动态图片同步到照片墙
    */
    RespondBody syncroAlbum(AlbumPictureDTO albumPictureDTO);

}
