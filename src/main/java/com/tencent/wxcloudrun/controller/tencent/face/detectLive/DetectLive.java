package com.tencent.wxcloudrun.controller.tencent.face.detectLive;

import com.tencent.wxcloudrun.controller.tencent.face.FaceInstance;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.iai.v20200303.IaiClient;
import com.tencentcloudapi.iai.v20200303.models.DetectLiveFaceAccurateRequest;
import com.tencentcloudapi.iai.v20200303.models.DetectLiveFaceAccurateResponse;
import com.tencentcloudapi.iai.v20200303.models.DetectLiveFaceRequest;
import com.tencentcloudapi.iai.v20200303.models.DetectLiveFaceResponse;

import java.util.Map;

/**
 * 人脸静态活体检测
 */
public class DetectLive {
    /**
     * 人脸静态活体检测
     */
    public String DetectLiveFace(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey);
            DetectLiveFaceRequest req = new DetectLiveFaceRequest();
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));

            DetectLiveFaceResponse resp = client.DetectLiveFace(req);
            // 输出json格式的字符串回包
            resultJson = DetectLiveFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 人脸静态活体检测（高精度版）
     */
    public String DetectLiveFaceAccurate(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey);
            DetectLiveFaceAccurateRequest req = new DetectLiveFaceAccurateRequest();
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));

            DetectLiveFaceAccurateResponse resp = client.DetectLiveFaceAccurate(req);
            // 输出json格式的字符串回包
            resultJson = DetectLiveFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
}
