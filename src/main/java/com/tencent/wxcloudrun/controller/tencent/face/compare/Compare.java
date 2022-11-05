package com.tencent.wxcloudrun.controller.tencent.face.compare;

import com.tencent.wxcloudrun.controller.tencent.Utils;
import com.tencent.wxcloudrun.controller.tencent.face.FaceInstance;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.iai.v20200303.IaiClient;
import com.tencentcloudapi.iai.v20200303.models.CompareFaceRequest;
import com.tencentcloudapi.iai.v20200303.models.CompareFaceResponse;
import com.tencentcloudapi.iai.v20200303.models.CompareMaskFaceRequest;
import com.tencentcloudapi.iai.v20200303.models.CompareMaskFaceResponse;
import java.util.Map;

/**
 * 人脸比对
 */
public class Compare {

    /**
     * 人脸比对
     */
    public String CompareFace(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            CompareFaceRequest req = new CompareFaceRequest();
            req.setImageA(params.get("imageA"));
            req.setImageB(params.get("imageB"));
            req.setUrlA(params.get("urlA"));
            req.setUrlB(params.get("urlB"));
            req.setQualityControl(Utils.type2Long(params,"qualityControl",0));

            CompareFaceResponse resp = client.CompareFace(req);
            // 输出json格式的字符串回包
            resultJson = CompareFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 防疫场景人脸比对
     */
    public String CompareMaskFace(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            CompareMaskFaceRequest req = new CompareMaskFaceRequest();
            req.setImageA(params.get("imageA"));
            req.setImageB(params.get("imageB"));
            req.setUrlA(params.get("urlA"));
            req.setUrlB(params.get("urlB"));
            req.setQualityControl(Utils.type2Long(params,"qualityControl",0));

            CompareMaskFaceResponse resp = client.CompareMaskFace(req);
            // 输出json格式的字符串回包
            resultJson = CompareMaskFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
}
