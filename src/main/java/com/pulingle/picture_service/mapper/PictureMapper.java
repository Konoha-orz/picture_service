package com.pulingle.picture_service.mapper;

import com.pulingle.picture_service.domain.entity.Picture;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by @杨健 on 2018/4/1 17:43
 *
 * @Des: 图片Mapper
 */
@Component("pictureMapper")
public interface PictureMapper {

    /**
     * 插入图片信息
     */
    int insert(Picture picture);

    /**
     *  查询相册图片信息
     */
     List<Map> queryPictureByAlbumId(long albumId);

     /**
      * 查询相册的图片数
      */
     int countByAlbumId(long albumId);

}
