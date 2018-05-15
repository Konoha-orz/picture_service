package com.pulingle.picture_service.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.pulingle.picture_service.domain.dto.AlbumPictureDTO;
import com.pulingle.picture_service.domain.dto.PictureDTO;
import com.pulingle.picture_service.domain.dto.RespondBody;
import com.pulingle.picture_service.domain.entity.AlbumPicture;
import com.pulingle.picture_service.domain.entity.Picture;
import com.pulingle.picture_service.mapper.AlbumPictureMapper;
import com.pulingle.picture_service.mapper.PictureMapper;
import com.pulingle.picture_service.service.PictureService;
import com.pulingle.picture_service.utils.RespondBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by 杨健 on 2018/3/30
 *
 * @Des: 图片上传服务实现类
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService {

    // endpoint以杭州为例，其它region请按实际情况填写，这里用的是ECS内网
    @Value("${oss.endpoint}")
    private String ENDPOINT;
    //生成的图片URL拼接的endpoint
    @Value("${oss.endpoint_url}")
    private String ENDPOINT_URL;
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
    @Value("${oss.accessKeyId}")
    private String ACCESS_KEY_ID;
    @Value("${oss.accessKeySecret}")
    private String ACCESS_KEY_SECRET;
    //Bucket名
    @Value("${oss.bucketName}")
    private String BUCKET_NAME;
    @Value("${oss.maxFileSize}")
    private long MAX_FILE_SIZE;
    @Value("${oss.urlPrefix}")
    private String URL_PREFIX;

    @Resource
    PictureMapper pictureMapper;

    @Resource
    AlbumPictureMapper albumPictureMapper;


    @Override
    public RespondBody uploadPicture(PictureDTO pictureDTO) {
        RespondBody respondBody = new RespondBody();
        //文件大小检测
        if (pictureDTO.getFile().getSize() > MAX_FILE_SIZE) {
            respondBody = RespondBuilder.buildErrorResponse("文件大小大于:" + MAX_FILE_SIZE + "字节");
            return respondBody;
        }
        try {
            // 创建OSSClient实例
            OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            String type = pictureDTO.getFile().getContentType();
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType(type);
            // 上传
            String keyName = UUID.randomUUID().toString();
            InputStream fileContent = pictureDTO.getFile().getInputStream();
            ossClient.putObject(BUCKET_NAME, keyName, fileContent, meta);
            // 关闭client
            ossClient.shutdown();

            //构建图片信息
            Picture picture = new Picture();
            picture.setUserId(pictureDTO.getUserId());
            Date date = new Date();
            picture.setUploadTime(date);
            picture.setPictureName(keyName);
            String pictureUrl = URL_PREFIX+BUCKET_NAME + "." + ENDPOINT_URL + "/" + keyName;
            picture.setPictureUrl(pictureUrl);
            picture.setSize(String.valueOf(pictureDTO.getFile().getSize()));
            picture.setType(type);
            //记录上传图片信息
            pictureMapper.insert(picture);
            respondBody = RespondBuilder.buildNormalResponse(picture);
        } catch (IOException ioE) {
            ioE.printStackTrace();
            respondBody = RespondBuilder.buildErrorResponse("IO错误,获取文件失败");
        }
        return respondBody;
    }

    @Override
    public RespondBody syncroAlbum(AlbumPictureDTO albumPictureDTO) {
        RespondBody respondBody;
        try{
            Date date=new Date();
            for(Picture picture:albumPictureDTO.getPictureList()) {
                picture.setUserId(albumPictureDTO.getUserId());
                picture.setUploadTime(date);
                albumPictureMapper.insert(picture);
            }
            respondBody=RespondBuilder.buildNormalResponse("照片同步成功");
        }catch (Exception e){
            e.printStackTrace();
            respondBody=RespondBuilder.buildErrorResponse(e.getMessage());
        }
        return respondBody;
    }

    @Override
    public RespondBody queryAlbumPictureByForWall(AlbumPictureDTO albumPictureDTO) {
        RespondBody respondBody;
        try {
            //返回数据列
            ArrayList resultList=new ArrayList();
            //根据当前页数，和页面显示月数计算应减去的月数，如查询当前月，就-0，查询上个月-1
            int currentMonth=(albumPictureDTO.getCurrentPage()-1)*albumPictureDTO.getPageSize();
            //获取月份记录数
            long recordNum=albumPictureMapper.queryAlbumMonth(albumPictureDTO.getUserId()).size();
            double d = (double) recordNum / (double) albumPictureDTO.getPageSize();
            long pageNum = (long) Math.ceil(d);
            for(int i=0;i<albumPictureDTO.getPageSize();i++) {
                //每个月的数据对象
                Map mothMap=new HashMap();
                List<Map> monthPictureList=albumPictureMapper.queryAlbumPictureByForWall(albumPictureDTO.getUserId(), albumPictureDTO.getPictureNum(),currentMonth);
                if(monthPictureList.size()!=0) {
                    if(monthPictureList.get(0).get("timeGroup")!=null) {
                        String month = String.valueOf(monthPictureList.get(0).get("timeGroup"));
                        mothMap.put("month", month);
                    }
                    mothMap.put("pictureInfoList", monthPictureList);
                    resultList.add(mothMap);
                }
                currentMonth++;
            }
            HashMap resultMap=new HashMap();
            resultMap.put("resultList",resultList);
            resultMap.put("pageNum",pageNum);
            resultMap.put("recordNum",recordNum);
            resultMap.put("currentPage",albumPictureDTO.getCurrentPage());
            resultMap.put("pageSize",albumPictureDTO.getPageSize());
            respondBody=RespondBuilder.buildNormalResponse(resultMap);
        }catch (Exception e){
            e.printStackTrace();
            respondBody=RespondBuilder.buildErrorResponse(e.getMessage());
        }
        return respondBody;
    }

    @Override
    public RespondBody queryNewAlbumPicture(long userId, int num) {
        RespondBody respondBody;
        try{
            List<Map> resultList=albumPictureMapper.queryNewAlbumPicture(userId,num);
            respondBody=RespondBuilder.buildNormalResponse(resultList);
        }catch (Exception e){
            e.printStackTrace();
            respondBody=RespondBuilder.buildErrorResponse(e.getMessage());
        }
        return respondBody;
    }

    @Override
    public RespondBody deleteAlbumPicture(long albumPictureId) {
        RespondBody respondBody;
        try{
            int i;
            if(albumPictureId==0)
                return RespondBuilder.buildErrorResponse("albumPictureId不能为0");
            else
                i=albumPictureMapper.deleteAlbumPicture(albumPictureId);
            respondBody=RespondBuilder.buildNormalResponse(i);
        }catch (Exception e){
            e.printStackTrace();
            respondBody=RespondBuilder.buildErrorResponse("图片删除错误");
        }
        return respondBody;
    }

    @Override
    public RespondBody queryAlbumPictureByMonth(long userId, String monthStr,int num) {
        RespondBody respondBody;
        List<Map> resultList;
        try{
            if(userId==0)
                return RespondBuilder.buildErrorResponse("用户ID不能为0");
            if(monthStr==null||monthStr.equals(""))
                return RespondBuilder.buildErrorResponse("月份不能空");
            resultList=albumPictureMapper.queryAlbumPictureByMonth(userId,monthStr,num);
            respondBody=RespondBuilder.buildNormalResponse(resultList);
        }catch (Exception e){
            e.printStackTrace();
            respondBody =RespondBuilder.buildErrorResponse("获取照片失败");
        }
        return respondBody;
    }
}