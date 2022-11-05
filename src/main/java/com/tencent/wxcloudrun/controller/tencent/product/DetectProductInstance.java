package com.tencent.wxcloudrun.controller.tencent.product;
import com.tencent.wxcloudrun.controller.tencent.Constant;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.tiia.v20190529.TiiaClient;

/**
 * 物品检测部分
 * https://console.cloud.tencent.com/api/explorer?Product=tiia&Version=2019-05-29&Action=DetectProductBeta
 */
public class DetectProductInstance {

    public static volatile DetectProductInstance faceInstance = null;

    private final TiiaClient tiiaClient;

    /**
     * 构造函数，初始化腾讯接口请求的对象
     */
    private DetectProductInstance(String SecretId, String SecretKey){
        // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
        // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
        Credential cred = new Credential(SecretId, SecretKey);
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(Constant.Product_Tiia_Endpoint);
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 人脸融合client
        tiiaClient = new TiiaClient(cred, Constant.Region, clientProfile);
    }

    public synchronized static DetectProductInstance getInstance(String SecretId, String SecretKey){
        if(faceInstance == null){
            synchronized (DetectProductInstance.class){
                if(faceInstance == null){
                    faceInstance = new DetectProductInstance(SecretId,SecretKey);
                }
            }
        }
        return faceInstance;
    }

    public TiiaClient getTiiaClient(){
        return tiiaClient;
    }
}
