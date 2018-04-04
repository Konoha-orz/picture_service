package com.pulingle.picture_service.mapper;

import com.pulingle.picture_service.domain.entity.Album;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by @杨健 on 2018/4/4 13:00
 *
 * @Des: 相册Mapper
 */
@Component("albumMapper")
public interface AlbumMapper {
    /**
     * 创建相册
     */
    int insert(Album album);

    /**
     * 查询用户相册信息
     */
     List<Map> queryAlbumsByUserId(long userId);


}
