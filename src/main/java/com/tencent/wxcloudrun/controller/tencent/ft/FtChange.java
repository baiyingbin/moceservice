package com.tencent.wxcloudrun.controller.tencent.ft;
import com.tencent.wxcloudrun.controller.tencent.Utils;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.ft.v20200304.FtClient;
import com.tencentcloudapi.ft.v20200304.models.AgeInfo;
import com.tencentcloudapi.ft.v20200304.models.CancelFaceMorphJobRequest;
import com.tencentcloudapi.ft.v20200304.models.CancelFaceMorphJobResponse;
import com.tencentcloudapi.ft.v20200304.models.ChangeAgePicRequest;
import com.tencentcloudapi.ft.v20200304.models.ChangeAgePicResponse;
import com.tencentcloudapi.ft.v20200304.models.FaceCartoonPicRequest;
import com.tencentcloudapi.ft.v20200304.models.FaceCartoonPicResponse;
import com.tencentcloudapi.ft.v20200304.models.GenderInfo;
import com.tencentcloudapi.ft.v20200304.models.GradientInfo;
import com.tencentcloudapi.ft.v20200304.models.MorphFaceRequest;
import com.tencentcloudapi.ft.v20200304.models.MorphFaceResponse;
import com.tencentcloudapi.ft.v20200304.models.SwapGenderPicRequest;
import com.tencentcloudapi.ft.v20200304.models.SwapGenderPicResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FtChange {

    /**
     * 人脸年龄变化
     */
    public String ChangeAgePic(Map<String,String> params,List<Map<String,String>> ageInfoList) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            FtClient client = FtChangeInstance.getInstance(SecretId,SecretKey).getFtClient();
            ChangeAgePicRequest req = new ChangeAgePicRequest();
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));

            AgeInfo[] ageInFos = new AgeInfo[ageInfoList.size()];
            for (int i=0;i<ageInfoList.size();i++){
                AgeInfo ageInfo = new AgeInfo();
                ageInfo.setAge(Utils.type2Long(ageInfoList.get(i),"age",10));
                ageInFos[i] = ageInfo;
            }
            req.setAgeInfos(ageInFos);

            req.setRspImgType(params.get("rspImgType"));

            ChangeAgePicResponse resp = client.ChangeAgePic(req);
            // 输出json格式的字符串回包
            resultJson = ChangeAgePicResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
    /**
     * 人脸性别转变
     */
    public String SwapGenderPic(Map<String,String> params,List<Map<String,String>> genderInfoList) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            FtClient client = FtChangeInstance.getInstance(SecretId,SecretKey).getFtClient();
            SwapGenderPicRequest req = new SwapGenderPicRequest();
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));

            GenderInfo[] genderInFos = new GenderInfo[genderInfoList.size()];
            for (int i=0;i<genderInfoList.size();i++){
                GenderInfo genderInfo = new GenderInfo();
                genderInfo.setGender(Utils.type2Long(genderInfoList.get(i),"gender",1));
                genderInFos[i] = genderInfo;
            }
            req.setGenderInfos(genderInFos);

            req.setRspImgType(params.get("rspImgType"));
            // 返回的resp是一个SwapGenderPicResponse的实例，与请求对象对应
            SwapGenderPicResponse resp = client.SwapGenderPic(req);

            // 输出json格式的字符串回包
            resultJson = SwapGenderPicResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 人像动漫化
     */
    @PostMapping(value = "/api/tencent/FaceCartoonPic")
    public String FaceCartoonPic(@RequestBody Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            FtClient client = FtChangeInstance.getInstance(SecretId,SecretKey).getFtClient();
            FaceCartoonPicRequest req = new FaceCartoonPicRequest();
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));
            req.setRspImgType(params.get("rspImgType"));
            req.setDisableGlobalEffect(params.get("disableGlobalEffect"));
            FaceCartoonPicResponse resp = client.FaceCartoonPic(req);
            // 输出json格式的字符串回包
            resultJson = FaceCartoonPicResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 人像渐变
     */
    public String MorphFace(Map<String,String> params, String [] images, String [] urls, List<Map<String, String>> gradientInfoMapList) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            FtClient client = FtChangeInstance.getInstance(SecretId,SecretKey).getFtClient();

            MorphFaceRequest req = new MorphFaceRequest();

            //设置渐变的多张图image
            req.setImages(images);

            //设置渐变的多张图url
            req.setUrls(urls);

            GradientInfo[] gradientInFos = new GradientInfo[gradientInfoMapList.size()];
            for (int i=0;i<gradientInfoMapList.size();i++){
                //设置多张图片中的某一张渐变信息
                GradientInfo gradientInfo = new GradientInfo();
                //设置图片展示的时长
                gradientInfo.setTempo(Utils.type2Float(gradientInfoMapList.get(i),"tempo",(float) 0.5));
                //设置图片人像渐变的最长时间
                gradientInfo.setMorphTime(Utils.type2Float(gradientInfoMapList.get(i),"morphTime",(float) 0.5));
                gradientInFos[i] = gradientInfo;
            }
            //设置人脸渐变参数
            req.setGradientInfos(gradientInFos);

            req.setFps(Utils.type2Long(params,"fps",10));
            req.setOutputType(Utils.type2Long(params,"outputType",0));
            req.setOutputWidth(Utils.type2Long(params,"outputWidth",720));
            req.setOutputHeight(Utils.type2Long(params,"outputHeight",1280));
            // 返回的resp是一个MorphFaceResponse的实例，与请求对象对应
            MorphFaceResponse resp = client.MorphFace(req);
            // 输出json格式的字符串回包
            resultJson = MorphFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }


    /**
     * 撤销人像渐变任务
     */
    public String CancelFaceMorphJob(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            FtClient client = FtChangeInstance.getInstance(SecretId,SecretKey).getFtClient();
            CancelFaceMorphJobRequest req = new CancelFaceMorphJobRequest();
            req.setJobId(params.get("jobId"));
            // 返回的resp是一个CancelFaceMorphJobResponse的实例，与请求对象对应
            CancelFaceMorphJobResponse resp = client.CancelFaceMorphJob(req);
            // 输出json格式的字符串回包
            resultJson = CancelFaceMorphJobResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

}
