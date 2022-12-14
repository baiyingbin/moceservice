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
     * ????????????
     */
    public String CreatePerson(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // ???????????????????????????client??????,clientProfile????????????
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            CreatePersonRequest req = new CreatePersonRequest();
            req.setGroupId(params.get("groupId"));
            req.setPersonName(params.get("personName"));
            req.setPersonId(params.get("personId"));
            req.setGender(Utils.type2Long(params,"gender",1));
            req.setUrl(params.get("url"));
            req.setImage(params.get("image"));

            CreatePersonResponse resp = client.CreatePerson(req);
            // ??????json????????????????????????
            resultJson = CreatePersonResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
    /**
     * ????????????
     */
    public String DeletePerson(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // ???????????????????????????client??????,clientProfile????????????
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            DeletePersonRequest req = new DeletePersonRequest();
            req.setPersonId(params.get("personId"));
            // ?????????resp?????????DeletePersonResponse?????????????????????????????????
            DeletePersonResponse resp = client.DeletePerson(req);
            // ??????json????????????????????????
            resultJson = DeletePersonResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * ????????????????????????
     */
    public String ModifyPersonBaseInfo(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // ???????????????????????????client??????,clientProfile????????????
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            ModifyPersonBaseInfoRequest req = new ModifyPersonBaseInfoRequest();
            req.setPersonName(params.get("personName"));
            req.setPersonId(params.get("personId"));
            req.setGender(Utils.type2Long(params,"gender",1));
            ModifyPersonBaseInfoResponse resp = client.ModifyPersonBaseInfo(req);
            // ??????json????????????????????????
            resultJson = ModifyPersonBaseInfoResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * ?????????????????????
     */
    public String DeletePersonFromGroup(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // ???????????????????????????client??????,clientProfile????????????
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            DeletePersonFromGroupRequest req = new DeletePersonFromGroupRequest();
            req.setGroupId(params.get("groupId"));
            req.setPersonId(params.get("personId"));

            DeletePersonFromGroupResponse resp = client.DeletePersonFromGroup(req);
            // ??????json????????????????????????
            resultJson = DeletePersonFromGroupResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * ????????????????????????
     */
    public String ModifyPersonGroupInfo(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // ???????????????????????????client??????,clientProfile????????????
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            ModifyPersonGroupInfoRequest req = new ModifyPersonGroupInfoRequest();
            req.setGroupId(params.get("groupId"));
            req.setPersonId(params.get("personId"));

            ModifyPersonGroupInfoResponse resp = client.ModifyPersonGroupInfo(req);
            // ??????json????????????????????????
            resultJson = ModifyPersonGroupInfoResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * ????????????
     */
    public String CopyPerson(Map<String,String> params,String[] groupIds) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // ???????????????????????????client??????,clientProfile????????????
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            CopyPersonRequest req = new CopyPersonRequest();
            req.setPersonId(params.get("personId"));
            req.setGroupIds(groupIds);

            CopyPersonResponse resp = client.CopyPerson(req);
            // ??????json????????????????????????
            resultJson = CopyPersonResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * ????????????
     */
    public String CreateFace(Map<String,String> params,String[] images,String[] urls) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // ???????????????????????????client??????,clientProfile????????????
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            CreateFaceRequest req = new CreateFaceRequest();
            req.setImages(images);
            req.setUrls(urls);
            req.setPersonId(params.get("personId"));

            CreateFaceResponse resp = client.CreateFace(req);
            // ??????json????????????????????????
            resultJson = CreateFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * ????????????
     */
    public String DeleteFace(Map<String,String> params,String[] faceIds) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // ???????????????????????????client??????,clientProfile????????????
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            DeleteFaceRequest req = new DeleteFaceRequest();
            req.setPersonId(params.get("personId"));
            req.setFaceIds(faceIds);

            DeleteFaceResponse resp = client.DeleteFace(req);
            // ??????json????????????????????????
            resultJson = DeleteFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * ????????????????????????
     */
    public String GetPersonGroupInfo(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // ???????????????????????????client??????,clientProfile????????????
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            GetPersonGroupInfoRequest req = new GetPersonGroupInfoRequest();
            req.setPersonId(params.get("personId"));
            req.setOffset(Utils.type2Long(params,"offset",0));
            req.setLimit(Utils.type2Long(params,"limit",10));
            GetPersonGroupInfoResponse resp = client.GetPersonGroupInfo(req);
            // ??????json????????????????????????
            resultJson = GetPersonGroupInfoResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * ????????????????????????
     */
    public String GetPersonBaseInfo(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // ???????????????????????????client??????,clientProfile????????????
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            GetPersonBaseInfoRequest req = new GetPersonBaseInfoRequest();
            req.setPersonId(params.get("personId"));
            GetPersonBaseInfoResponse resp = client.GetPersonBaseInfo(req);

            // ??????json????????????????????????
            resultJson = GetPersonBaseInfoResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * ??????????????????
     */
    public String GetPersonList(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // ???????????????????????????client??????,clientProfile????????????
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            GetPersonListRequest req = new GetPersonListRequest();
            req.setGroupId(params.get("groupId"));
            req.setOffset(Utils.type2Long(params,"offset",0));
            req.setLimit(Utils.type2Long(params,"limit",10));
            GetPersonListResponse resp = client.GetPersonList(req);

            // ??????json????????????????????????
            resultJson = GetPersonListResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * ????????????????????????
     */
    public String GetPersonListNum(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // ???????????????????????????client??????,clientProfile????????????
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            GetPersonListNumRequest req = new GetPersonListNumRequest();
            req.setGroupId(params.get("groupId"));
            GetPersonListNumResponse resp = client.GetPersonListNum(req);
            // ??????json????????????????????????
            resultJson = GetPersonListNumResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
}
