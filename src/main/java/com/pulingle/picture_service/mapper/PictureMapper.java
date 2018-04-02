package com.pulingle.picture_service.mapper;

import com.pulingle.picture_service.domain.entity.Picture;
import org.springframework.stereotype.Component;

/**
 * Created by @杨健 on 2018/4/1 17:43
 *
 * @Des: 图片Mapper
 */
@Component("pictureMapper")
public interface PictureMapper {
    int insert(Picture picture);
}
