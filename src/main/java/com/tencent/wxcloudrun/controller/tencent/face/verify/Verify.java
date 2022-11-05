package com.tencent.wxcloudrun.controller.tencent.face.verify;

import com.tencent.wxcloudrun.controller.tencent.face.FaceInstance;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.iai.v20200303.IaiClient;
import com.tencentcloudapi.iai.v20200303.models.VerifyFaceRequest;
import com.tencentcloudapi.iai.v20200303.models.VerifyFaceResponse;
import com.tencentcloudapi.iai.v20200303.models.VerifyPersonRequest;
import com.tencentcloudapi.iai.v20200303.models.VerifyPersonResponse;

import java.util.Map;

/**
 * 验证
 */
public class Verify {

    /**
     * 人脸验证
     */
    public String VerifyFace(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();
            VerifyFaceRequest req = new VerifyFaceRequest();
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));
            req.setPersonId(params.get("personId"));

            VerifyFaceResponse resp = client.VerifyFace(req);
            // 输出json格式的字符串回包
            resultJson = VerifyFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
    /**
     * 人员验证
     */
    public String VerifyPerson(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();
            VerifyPersonRequest req = new VerifyPersonRequest();
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));
            req.setPersonId(params.get("personId"));
            VerifyPersonResponse resp = client.VerifyPerson(req);
            // 输出json格式的字符串回包
            resultJson = VerifyPersonResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
}
