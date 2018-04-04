package com.pulingle.picture_service.web;

import com.pulingle.picture_service.domain.dto.RespondBody;
import com.pulingle.picture_service.domain.entity.Album;
import com.pulingle.picture_service.service.AlbumService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by @杨健 on 2018/4/4 14:10
 *
 * @Des: 相册Controller
 */

@RestController
@RequestMapping(value = "album")
public class AlbumController {
    @Resource
    AlbumService albumService;

    /**
     * @param: album(相册实体)
     * @return: respondBody
     * @Des: 创建相册
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public RespondBody create(@RequestBody Album album){
        return albumService.createAlbum(album);
    }

    /**
     * @param: albumId(相册Id)
     * @return: respondBody
     * @Des: 查看对应相册的图片信息
     */
    @RequestMapping(value = "/queryPicturesByAlbumId",method = RequestMethod.POST)
    public RespondBody queryPicturesByAlbumId(@RequestBody Album album){
        return albumService.queryPicturesByAlbumId(album.getAlbumId());
    }

    /**
    * @param: userId(用户id)
    * @return: respondBody
    * @Des: 查询用户相册信息
    */
    @RequestMapping(value = "/queryAlbumsByUserId",method = RequestMethod.POST)
    public RespondBody queryAlbumsByUserId(@RequestBody Album album){
        return albumService.queryAlbumsByUserId(album.getUserId());
    }
}
