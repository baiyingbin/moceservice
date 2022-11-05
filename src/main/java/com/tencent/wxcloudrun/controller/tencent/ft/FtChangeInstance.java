package com.tencent.wxcloudrun.controller.tencent.ft;
import com.tencent.wxcloudrun.controller.tencent.Constant;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.ft.v20200304.FtClient;

/**
 * 人像变换部分
 * https://console.cloud.tencent.com/api/explorer?Product=ft&Version=2020-03-04&Action=ChangeAgePic
 */
public class FtChangeInstance {

    public static volatile FtChangeInstance faceInstance = null;

    private final FtClient ftClient;

    /**
     * 构造函数，初始化腾讯接口请求的对象
     */
    private FtChangeInstance(){
        // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
        // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
        Credential cred = new Credential(Constant.SecretId, Constant.SecretKey);
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(Constant.Face_Ft_Endpoint);
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 人像变换
        ftClient = new FtClient(cred,  Constant.Region, clientProfile);
    }

    public synchronized static FtChangeInstance getInstance(){
        if(faceInstance == null){
            synchronized (FtChangeInstance.class){
                if(faceInstance == null){
                    faceInstance = new FtChangeInstance();
                }
            }
        }
        return faceInstance;
    }

    public FtClient getFtClient(){
        return ftClient;
    }

}
