package com.pulingle.picture_service.web;

import com.pulingle.picture_service.domain.dto.PictureDTO;
import com.pulingle.picture_service.domain.dto.RespondBody;
import com.pulingle.picture_service.service.PictureService;
import com.pulingle.picture_service.utils.RespondBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
