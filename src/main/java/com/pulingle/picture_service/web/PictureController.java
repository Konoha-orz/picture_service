package com.pulingle.picture_service.web;

import com.pulingle.picture_service.domain.dto.AlbumPictureDTO;
import com.pulingle.picture_service.domain.dto.PictureDTO;
import com.pulingle.picture_service.domain.dto.RespondBody;
import com.pulingle.picture_service.service.PictureService;
import com.pulingle.picture_service.utils.RespondBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * Created by 杨健 on 2018/3/30
 */

@RestController
@RequestMapping(value = "picture")
public class PictureController {
    @Resource
    private PictureService pictureService;

    /**
     * @param: pictureDTO（图片传输对象）
     * @return: respondBody
     * @Des: 上传图片服务
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public RespondBody upload(PictureDTO pictureDTO) {
        return pictureService.uploadPicture(pictureDTO);
    }

    /**
     * @param: pictureDTO（图片传输对象）
     * @return: respondBody
     * @Des: 上传图片服务
     */
    @RequestMapping(value = "/uploadAlbumPicture", method = RequestMethod.POST)
    public RespondBody uploadAlbumPicture(PictureDTO pictureDTO) {
        return pictureService.uploadAlbumPicture(pictureDTO);
    }

    /**
    * @param: albumPictureDTO
    * @return: RespondBody
    * @Des: 动态图片同步到照片墙
    */
    @RequestMapping(value = "/syncroAlbum",method = RequestMethod.POST)
    public RespondBody syncroAlbum(@RequestBody AlbumPictureDTO albumPictureDTO){
        return pictureService.syncroAlbum(albumPictureDTO);
    }

}
