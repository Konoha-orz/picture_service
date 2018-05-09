package com.pulingle.picture_service.service;

import com.pulingle.picture_service.domain.dto.AlbumPictureDTO;
import com.pulingle.picture_service.domain.dto.PictureDTO;
import com.pulingle.picture_service.domain.dto.RespondBody;
import com.pulingle.picture_service.domain.entity.AlbumPicture;
import org.springframework.web.bind.annotation.ResponseBody;
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
    * @param: albumPictureDTO
    * @return: RespondBody
    * @Des: 动态图片同步到照片墙
    */
    RespondBody syncroAlbum(AlbumPictureDTO albumPictureDTO);

    /**
    * @param: userID,pageSize,pictureNum,currentPage
    * @return:
    * @Des: 获取用户照片墙照片信息
    */
    RespondBody queryAlbumPictureByForWall(AlbumPictureDTO albumPictureDTO);

    /**
     * @param: userId
     * @return: List<AlbumPicture>
     * @Des: 查询用户照片墙前n张照片
     */
    RespondBody queryNewAlbumPicture(long userId,int num);

}
