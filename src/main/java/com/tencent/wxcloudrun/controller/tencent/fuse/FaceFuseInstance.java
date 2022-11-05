package com.tencent.wxcloudrun.controller.tencent.fuse;
import com.tencent.wxcloudrun.controller.tencent.Constant;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.facefusion.v20181201.FacefusionClient;

/**
 * 人脸融合部分
 * https://console.cloud.tencent.com/api/explorer?Product=facefusion&Version=2018-12-01&Action=FaceFusion
 */
public class FaceFuseInstance {

    public static volatile FaceFuseInstance faceInstance = null;

    private final FacefusionClient facefusionClient;

    /**
     * 构造函数，初始化腾讯接口请求的对象
     */
    private FaceFuseInstance(){
        // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
        // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
        Credential cred = new Credential(Constant.SecretId, Constant.SecretKey);
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(Constant.Face_Fusion_Endpoint);
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 人脸融合client
        facefusionClient = new FacefusionClient(cred, Constant.Region, clientProfile);
    }

    public synchronized static FaceFuseInstance getInstance(){
        if(faceInstance == null){
            synchronized (FaceFuseInstance.class){
                if(faceInstance == null){
                    faceInstance = new FaceFuseInstance();
                }
            }
        }
        return faceInstance;
    }

    public FacefusionClient getFaceFusionClient(){
        return facefusionClient;
    }
}
