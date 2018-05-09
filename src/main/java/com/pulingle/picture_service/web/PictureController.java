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
    * @param: albumPictureDTO
    * @return: RespondBody
    * @Des: 动态图片同步到照片墙
    */
    @RequestMapping(value = "/syncroAlbum",method = RequestMethod.POST)
    public RespondBody syncroAlbum(@RequestBody AlbumPictureDTO albumPictureDTO){
        return pictureService.syncroAlbum(albumPictureDTO);
    }

    /**
    * @param: userId,pageSize,pictureNum,currentPage
    * @return: RespondBody
    * @Des: 获取个人图片墙简略照片信息
    */
    @RequestMapping(value = "/queryAlbumPictureByForWall",method = RequestMethod.POST)
    public RespondBody queryAlbumPictureByForWall(@RequestBody AlbumPictureDTO albumPictureDTO){
        return pictureService.queryAlbumPictureByForWall(albumPictureDTO);
    }

    /**
     * @param: userId
     * @return: List<AlbumPicture>
     * @Des: 查询用户照片墙前n张照片
     */
    @RequestMapping(value = "/queryNewAlbumPicture",method = RequestMethod.POST)
    public RespondBody queryNewAlbumPicture(@RequestBody AlbumPictureDTO albumPictureDTO){
        return pictureService.queryNewAlbumPicture(albumPictureDTO.getUserId(),9);
    }

}
