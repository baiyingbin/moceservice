package com.tencent.wxcloudrun.controller.tencent.fuse;

import com.tencent.wxcloudrun.controller.tencent.Utils;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.facefusion.v20181201.FacefusionClient;
import com.tencentcloudapi.facefusion.v20181201.models.DescribeMaterialListRequest;
import com.tencentcloudapi.facefusion.v20181201.models.DescribeMaterialListResponse;
import com.tencentcloudapi.facefusion.v20181201.models.FaceFusionLiteRequest;
import com.tencentcloudapi.facefusion.v20181201.models.FaceFusionLiteResponse;
import com.tencentcloudapi.facefusion.v20181201.models.FaceFusionRequest;
import com.tencentcloudapi.facefusion.v20181201.models.FaceFusionResponse;
import com.tencentcloudapi.facefusion.v20181201.models.FuseFaceRequest;
import com.tencentcloudapi.facefusion.v20181201.models.FuseFaceResponse;
import com.tencentcloudapi.facefusion.v20181201.models.MergeInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 人脸融合
 */
@RestController
public class Fuse {
    /**
     * 选脸融合
     */
    @PostMapping(value = "/api/tencent/FuseFace")
    public String FuseFace(@RequestBody Map<String,String> params,@RequestBody List<Map<String,String>> mergeInfoList) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            FacefusionClient client = FaceFuseInstance.getInstance().getFaceFusionClient();

            // 实例化一个请求对象,每个接口都会对应一个request对象
            FuseFaceRequest req = new FuseFaceRequest();
            req.setProjectId(params.get("projectId"));
            req.setModelId(params.get("modelId"));
            req.setRspImgType(params.get("rspImgType"));

            MergeInfo[] mergeInFos = new MergeInfo[mergeInfoList.size()];
            for (int i=0;i<mergeInfoList.size();i++){
                MergeInfo mergeInfo = new MergeInfo();
                mergeInfo.setImage(mergeInfoList.get(i).get("image"));
                mergeInfo.setUrl(mergeInfoList.get(i).get("url"));
                mergeInFos[i] = mergeInfo;
            }
            req.setMergeInfos(mergeInFos);

            // 返回的resp是一个FuseFaceResponse的实例，与请求对象对应
            FuseFaceResponse resp = client.FuseFace(req);
            // 输出json格式的字符串回包
            resultJson = FuseFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
    /**
     * 人脸融合
     */
    @PostMapping(value = "/api/tencent/FaceFusion")
    public String FaceFusion(@RequestBody Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            FacefusionClient client = FaceFuseInstance.getInstance().getFaceFusionClient();

            // 实例化一个请求对象,每个接口都会对应一个request对象
            FaceFusionRequest req = new FaceFusionRequest();
            req.setProjectId(params.get("projectId"));
            req.setModelId(params.get("modelId"));
            req.setRspImgType(params.get("rspImgType"));
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));
            // 返回的resp是一个FuseFaceResponse的实例，与请求对象对应
            FaceFusionResponse resp = client.FaceFusion(req);
            // 输出json格式的字符串回包
            resultJson = FaceFusionResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
    /**
     * 人脸融合(活动专用版)
     */
    @PostMapping(value = "/api/tencent/FaceFusionLite")
    public String FaceFusionLite(@RequestBody Map<String,String> params, @RequestBody List<Map<String,String>> mergeInfoList) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            FacefusionClient client = FaceFuseInstance.getInstance().getFaceFusionClient();
            FaceFusionLiteRequest req = new FaceFusionLiteRequest();
            req.setProjectId(params.get("projectId"));
            req.setModelId(params.get("modelId"));

            MergeInfo[] mergeInFos = new MergeInfo[mergeInfoList.size()];
            for (int i=0;i<mergeInfoList.size();i++){
                MergeInfo mergeInfo = new MergeInfo();
                mergeInfo.setImage(mergeInfoList.get(i).get("image"));
                mergeInfo.setUrl(mergeInfoList.get(i).get("url"));
                mergeInFos[i] = mergeInfo;
            }
            req.setMergeInfos(mergeInFos);

            // 返回的resp是一个FaceFusionLiteResponse的实例，与请求对象对应
            FaceFusionLiteResponse resp = client.FaceFusionLite(req);
            // 输出json格式的字符串回包
            resultJson = FaceFusionLiteResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 查询素材列表
     */
    @PostMapping(value = "/api/tencent/DescribeMaterialList")
    public String DescribeMaterialList(@RequestBody Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            FacefusionClient client = FaceFuseInstance.getInstance().getFaceFusionClient();
            DescribeMaterialListRequest req = new DescribeMaterialListRequest();
            req.setActivityId(Utils.type2Long(params,"activityId",-1));
            req.setMaterialId(params.get("materialId"));
            req.setLimit(Utils.type2Long(params,"limit",10));
            req.setOffset(Utils.type2Long(params,"offset",0));
            // 返回的resp是一个DescribeMaterialListResponse的实例，与请求对象对应
            DescribeMaterialListResponse resp = client.DescribeMaterialList(req);
            // 输出json格式的字符串回包
            resultJson = DescribeMaterialListResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
}