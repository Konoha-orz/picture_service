package com.pulingle.picture_service.mapper;

import com.pulingle.picture_service.domain.entity.AlbumPicture;
import com.pulingle.picture_service.domain.entity.Picture;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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
    int insert(Picture picture);

    /**
    * @param: userId
    * @return: List<AlbumPicture>
    * @Des: 获取用户照片墙照片信息
    */
    List<Map> queryAlbumPictureByForWall(@Param("userId")long userId,@Param("pictureNum")int pictureNum,@Param("monthNum")int monthNum);

    /**
    * @param: userId
    * @return: List<String>
    * @Des: 查询照片墙中还有的月份分组
    */
    List<String> queryAlbumMonth(@Param("userId")long userId);

    /**
    * @param: userId
    * @return: List<AlbumPicture>
    * @Des: 查询用户照片墙前n张照片
    */
    List<Map> queryNewAlbumPicture(@Param("userId")long userId,@Param("num")int num);

    /**
    * @param: albumPictureId
    * @return: int
    * @Des: 删除照片墙中的照片
    */
    int deleteAlbumPicture(@Param("albumPictureId")long albumPictureId);

    /**
    * @param: userId,monthStr
    * @return: List<Map>
    * @Des: 查询某用户某个年月的照片墙照片
    */
    List<Map> queryAlbumPictureByMonth(@Param("userId")long userId,@Param("monthStr")String monthStr,@Param("num")int num);
}
