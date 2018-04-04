package com.pulingle.picture_service.service;

import com.pulingle.picture_service.domain.dto.RespondBody;
import com.pulingle.picture_service.domain.entity.Album;

/**
 * Created by @杨健 on 2018/4/4 13:58
 *
 * @Des: 相册服务
 */

public interface AlbumService {
    /**
    * @param: album(相册实体)
    * @return: respondBody
    * @Des: 创建相册
    */
    RespondBody createAlbum(Album album);

    /**
    * @param: albumId(相册Id)
    * @return: respondBody
    * @Des: 查看对应相册的图片信息
    */
    RespondBody queryPicturesByAlbumId(long albumId);

    /**
    * @param: userId 用户id
    * @return: respondBody
    * @Des: 查询用户相册信息
    */
    RespondBody queryAlbumsByUserId(long userId);
}
