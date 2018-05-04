package com.pulingle.picture_service.mapper;

import com.pulingle.picture_service.domain.entity.AlbumPicture;
import org.springframework.stereotype.Component;

/**
 * Created by @杨健 on 2018/5/1 17:22
 *
 * @Des: 照片墙照片Mapper
 */
@Component("albumPictureMapper")
public interface AlbumPictureMapper {
    /**
    * @param: albumPicture
    * @return: int
    * @Des: 插入一条照片墙照片记录
    */
    int insert(AlbumPicture albumPicture);
}
