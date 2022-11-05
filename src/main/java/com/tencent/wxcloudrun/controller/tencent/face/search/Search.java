package com.tencent.wxcloudrun.controller.tencent.face.search;

import com.tencent.wxcloudrun.controller.tencent.Utils;
import com.tencent.wxcloudrun.controller.tencent.face.FaceInstance;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.iai.v20200303.IaiClient;
import com.tencentcloudapi.iai.v20200303.models.SearchFacesRequest;
import com.tencentcloudapi.iai.v20200303.models.SearchFacesResponse;
import com.tencentcloudapi.iai.v20200303.models.SearchFacesReturnsByGroupRequest;
import com.tencentcloudapi.iai.v20200303.models.SearchFacesReturnsByGroupResponse;
import com.tencentcloudapi.iai.v20200303.models.SearchPersonsRequest;
import com.tencentcloudapi.iai.v20200303.models.SearchPersonsResponse;
import com.tencentcloudapi.iai.v20200303.models.SearchPersonsReturnsByGroupRequest;
import com.tencentcloudapi.iai.v20200303.models.SearchPersonsReturnsByGroupResponse;

import java.util.Map;

/**
 * 搜索人脸、人员、库
 */
public class Search {

    /**
     * 人脸搜索
     */
    public String SearchFaces(Map<String,String> params,String[] groupIds) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey);

            SearchFacesRequest req = new SearchFacesRequest();
            req.setGroupIds(groupIds);
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));
            req.setMaxFaceNum(Utils.type2Long(params,"maxFaceNum",1));
            req.setMinFaceSize(Utils.type2Long(params,"minFaceSize",34));
            req.setMaxPersonNum(Utils.type2Long(params,"maxPersonNum",5));
            req.setNeedPersonInfo(Utils.type2Long(params,"needPersonInfo",0));

            // 返回的resp是一个SearchFacesResponse的实例，与请求对象对应
            SearchFacesResponse resp = client.SearchFaces(req);
            // 输出json格式的字符串回包
            resultJson = SearchFacesResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 人员搜索
     */
    public String SearchPersons(Map<String,String> params,String[] groupIds) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey);

            SearchPersonsRequest req = new SearchPersonsRequest();
            req.setGroupIds(groupIds);
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));
            req.setMaxFaceNum(Utils.type2Long(params,"maxFaceNum",1));
            req.setMinFaceSize(Utils.type2Long(params,"minFaceSize",34));
            req.setMaxPersonNum(Utils.type2Long(params,"maxPersonNum",5));
            req.setNeedPersonInfo(Utils.type2Long(params,"needPersonInfo",0));

            SearchPersonsResponse resp = client.SearchPersons(req);
            // 输出json格式的字符串回包
            resultJson = SearchPersonsResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
    /**
     * 人脸搜索分库返回
     */
    public String SearchFacesReturnsByGroup(Map<String,String> params,String[] groupIds) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey);

            SearchFacesReturnsByGroupRequest req = new SearchFacesReturnsByGroupRequest();
            req.setGroupIds(groupIds);
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));
            req.setMaxFaceNum(Utils.type2Long(params,"maxFaceNum",1));
            req.setMinFaceSize(Utils.type2Long(params,"minFaceSize",34));
            req.setMaxPersonNumPerGroup(Utils.type2Long(params,"maxPersonNumPerGroup",5));
            req.setNeedPersonInfo(Utils.type2Long(params,"needPersonInfo",0));

            SearchFacesReturnsByGroupResponse resp = client.SearchFacesReturnsByGroup(req);
            // 输出json格式的字符串回包
            resultJson = SearchFacesReturnsByGroupResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
    /**
     * 人员搜索按库返回
     */
    public String SearchPersonsReturnsByGroup(Map<String,String> params,String[] groupIds) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey);

            SearchPersonsReturnsByGroupRequest req = new SearchPersonsReturnsByGroupRequest();
            req.setGroupIds(groupIds);
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));
            req.setMaxFaceNum(Utils.type2Long(params,"maxFaceNum",1));
            req.setMinFaceSize(Utils.type2Long(params,"minFaceSize",34));
            req.setMaxPersonNumPerGroup(Utils.type2Long(params,"maxPersonNumPerGroup",5));
            req.setNeedPersonInfo(Utils.type2Long(params,"needPersonInfo",0));

            SearchPersonsReturnsByGroupResponse resp = client.SearchPersonsReturnsByGroup(req);
            // 输出json格式的字符串回包
            resultJson = SearchPersonsReturnsByGroupResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
}
