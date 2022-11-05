package com.tencent.wxcloudrun.controller.tencent.face;
import com.tencent.wxcloudrun.controller.tencent.Constant;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.iai.v20200303.IaiClient;

/**
 * 人脸识别部分
 * https://console.cloud.tencent.com/api/explorer?Product=iai&Version=2020-03-03&Action=DetectFace
 */
public class FaceInstance {

    /**
     * 构造函数，初始化腾讯接口请求的对象
     */
    public static IaiClient getInstance(String SecretId,String SecretKey){
        // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
        // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取

        Credential cred = new Credential(SecretId, SecretKey);
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(Constant.Face_Detect_Endpoint);
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 人脸识别client
        return new IaiClient(cred, Constant.Region, clientProfile);
    }

}
