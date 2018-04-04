package com.pulingle.picture_service.service.impl;

import com.pulingle.picture_service.domain.dto.RespondBody;
import com.pulingle.picture_service.domain.entity.Album;
import com.pulingle.picture_service.mapper.AlbumMapper;
import com.pulingle.picture_service.mapper.PictureMapper;
import com.pulingle.picture_service.service.AlbumService;
import com.pulingle.picture_service.utils.RespondBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by @杨健 on 2018/4/4 14:00
 *
 * @Des: 相册服务实现类
 */
@Service("albumService")
public class AlbumServiceImpl implements AlbumService{
    @Resource
    AlbumMapper albumMapper;

    @Resource
    PictureMapper pictureMapper;


    @Override
    public RespondBody createAlbum(Album album) {
        RespondBody respondBody;
        if(album.getTitle()==null||album.getUserId()==0)
            return RespondBuilder.buildErrorResponse("必填参数缺省");
        try{
            albumMapper.insert(album);
            respondBody=RespondBuilder.buildNormalResponse("相册创建成功，相册ID:"+album.getAlbumId());
        }catch (Exception e){
            e.printStackTrace();
            respondBody=RespondBuilder.buildErrorResponse(e.getMessage());
        }
        return respondBody;
    }

    @Override
    public RespondBody queryPicturesByAlbumId(long albumId) {
        RespondBody respondBody;
        if(albumId==0)
            return RespondBuilder.buildErrorResponse("albumId不能为0");
        try{
            List picturesList=pictureMapper.queryPictureByAlbumId(albumId);
            respondBody=RespondBuilder.buildNormalResponse(picturesList);
        }catch (Exception e){
           respondBody=RespondBuilder.buildErrorResponse(e.getMessage());
        }
        return  respondBody;
    }

    @Override
    public RespondBody queryAlbumsByUserId(long userId) {
        RespondBody respondBody;
        if(userId==0)
            return RespondBuilder.buildErrorResponse("userId不能为0");
        try{
            List<Map> albumList=albumMapper.queryAlbumsByUserId(userId);
            for(Map map:albumList){
                int albumId=(int)map.get("albumId");
                map.put("picturesNum",pictureMapper.countByAlbumId(albumId));
            }
            respondBody=RespondBuilder.buildNormalResponse(albumList);
        }catch (Exception e){
            respondBody=RespondBuilder.buildErrorResponse(e.getMessage());
        }
        return respondBody;
    }
}
