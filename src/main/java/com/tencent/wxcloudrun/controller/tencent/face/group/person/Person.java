package com.tencent.wxcloudrun.controller.tencent.face.group.person;

import com.tencent.wxcloudrun.controller.tencent.Utils;
import com.tencent.wxcloudrun.controller.tencent.face.FaceInstance;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.iai.v20200303.IaiClient;
import com.tencentcloudapi.iai.v20200303.models.CopyPersonRequest;
import com.tencentcloudapi.iai.v20200303.models.CopyPersonResponse;
import com.tencentcloudapi.iai.v20200303.models.CreateFaceRequest;
import com.tencentcloudapi.iai.v20200303.models.CreateFaceResponse;
import com.tencentcloudapi.iai.v20200303.models.CreatePersonRequest;
import com.tencentcloudapi.iai.v20200303.models.CreatePersonResponse;
import com.tencentcloudapi.iai.v20200303.models.DeleteFaceRequest;
import com.tencentcloudapi.iai.v20200303.models.DeleteFaceResponse;
import com.tencentcloudapi.iai.v20200303.models.DeletePersonFromGroupRequest;
import com.tencentcloudapi.iai.v20200303.models.DeletePersonFromGroupResponse;
import com.tencentcloudapi.iai.v20200303.models.DeletePersonRequest;
import com.tencentcloudapi.iai.v20200303.models.DeletePersonResponse;
import com.tencentcloudapi.iai.v20200303.models.GetPersonBaseInfoRequest;
import com.tencentcloudapi.iai.v20200303.models.GetPersonBaseInfoResponse;
import com.tencentcloudapi.iai.v20200303.models.GetPersonGroupInfoRequest;
import com.tencentcloudapi.iai.v20200303.models.GetPersonGroupInfoResponse;
import com.tencentcloudapi.iai.v20200303.models.GetPersonListNumRequest;
import com.tencentcloudapi.iai.v20200303.models.GetPersonListNumResponse;
import com.tencentcloudapi.iai.v20200303.models.GetPersonListRequest;
import com.tencentcloudapi.iai.v20200303.models.GetPersonListResponse;
import com.tencentcloudapi.iai.v20200303.models.ModifyPersonBaseInfoRequest;
import com.tencentcloudapi.iai.v20200303.models.ModifyPersonBaseInfoResponse;
import com.tencentcloudapi.iai.v20200303.models.ModifyPersonGroupInfoRequest;
import com.tencentcloudapi.iai.v20200303.models.ModifyPersonGroupInfoResponse;

import java.util.Map;

public class Person {
    /**
     * 创建人员
     */
    public String CreatePerson(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            CreatePersonRequest req = new CreatePersonRequest();
            req.setGroupId(params.get("groupId"));
            req.setPersonName(params.get("personName"));
            req.setPersonId(params.get("personId"));
            req.setGender(Utils.type2Long(params,"gender",1));
            req.setUrl(params.get("url"));
            req.setImage(params.get("image"));

            CreatePersonResponse resp = client.CreatePerson(req);
            // 输出json格式的字符串回包
            resultJson = CreatePersonResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
    /**
     * 删除人员
     */
    public String DeletePerson(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            DeletePersonRequest req = new DeletePersonRequest();
            req.setPersonId(params.get("personId"));
            // 返回的resp是一个DeletePersonResponse的实例，与请求对象对应
            DeletePersonResponse resp = client.DeletePerson(req);
            // 输出json格式的字符串回包
            resultJson = DeletePersonResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 修改人员基础信息
     */
    public String ModifyPersonBaseInfo(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            ModifyPersonBaseInfoRequest req = new ModifyPersonBaseInfoRequest();
            req.setPersonName(params.get("personName"));
            req.setPersonId(params.get("personId"));
            req.setGender(Utils.type2Long(params,"gender",1));
            ModifyPersonBaseInfoResponse resp = client.ModifyPersonBaseInfo(req);
            // 输出json格式的字符串回包
            resultJson = ModifyPersonBaseInfoResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 人员库删除人员
     */
    public String DeletePersonFromGroup(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            DeletePersonFromGroupRequest req = new DeletePersonFromGroupRequest();
            req.setGroupId(params.get("groupId"));
            req.setPersonId(params.get("personId"));

            DeletePersonFromGroupResponse resp = client.DeletePersonFromGroup(req);
            // 输出json格式的字符串回包
            resultJson = DeletePersonFromGroupResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 修改人员描述信息
     */
    public String ModifyPersonGroupInfo(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            ModifyPersonGroupInfoRequest req = new ModifyPersonGroupInfoRequest();
            req.setGroupId(params.get("groupId"));
            req.setPersonId(params.get("personId"));

            ModifyPersonGroupInfoResponse resp = client.ModifyPersonGroupInfo(req);
            // 输出json格式的字符串回包
            resultJson = ModifyPersonGroupInfoResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 复制人员
     */
    public String CopyPerson(Map<String,String> params,String[] groupIds) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            CopyPersonRequest req = new CopyPersonRequest();
            req.setPersonId(params.get("personId"));
            req.setGroupIds(groupIds);

            CopyPersonResponse resp = client.CopyPerson(req);
            // 输出json格式的字符串回包
            resultJson = CopyPersonResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 增加人脸
     */
    public String CreateFace(Map<String,String> params,String[] images,String[] urls) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            CreateFaceRequest req = new CreateFaceRequest();
            req.setImages(images);
            req.setUrls(urls);
            req.setPersonId(params.get("personId"));

            CreateFaceResponse resp = client.CreateFace(req);
            // 输出json格式的字符串回包
            resultJson = CreateFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 删除人脸
     */
    public String DeleteFace(Map<String,String> params,String[] faceIds) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            DeleteFaceRequest req = new DeleteFaceRequest();
            req.setPersonId(params.get("personId"));
            req.setFaceIds(faceIds);

            DeleteFaceResponse resp = client.DeleteFace(req);
            // 输出json格式的字符串回包
            resultJson = DeleteFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 获取人员归属信息
     */
    public String GetPersonGroupInfo(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            GetPersonGroupInfoRequest req = new GetPersonGroupInfoRequest();
            req.setPersonId(params.get("personId"));
            req.setOffset(Utils.type2Long(params,"offset",0));
            req.setLimit(Utils.type2Long(params,"limit",10));
            GetPersonGroupInfoResponse resp = client.GetPersonGroupInfo(req);
            // 输出json格式的字符串回包
            resultJson = GetPersonGroupInfoResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 获取人员基础信息
     */
    public String GetPersonBaseInfo(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            GetPersonBaseInfoRequest req = new GetPersonBaseInfoRequest();
            req.setPersonId(params.get("personId"));
            GetPersonBaseInfoResponse resp = client.GetPersonBaseInfo(req);

            // 输出json格式的字符串回包
            resultJson = GetPersonBaseInfoResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 获取人员列表
     */
    public String GetPersonList(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            GetPersonListRequest req = new GetPersonListRequest();
            req.setGroupId(params.get("groupId"));
            req.setOffset(Utils.type2Long(params,"offset",0));
            req.setLimit(Utils.type2Long(params,"limit",10));
            GetPersonListResponse resp = client.GetPersonList(req);

            // 输出json格式的字符串回包
            resultJson = GetPersonListResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 获取人员列表长度
     */
    public String GetPersonListNum(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            GetPersonListNumRequest req = new GetPersonListNumRequest();
            req.setGroupId(params.get("groupId"));
            GetPersonListNumResponse resp = client.GetPersonListNum(req);
            // 输出json格式的字符串回包
            resultJson = GetPersonListNumResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
}
