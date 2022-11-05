package com.tencent.wxcloudrun.controller.tencent.face.group;
import com.tencent.wxcloudrun.controller.tencent.Utils;
import com.tencent.wxcloudrun.controller.tencent.face.FaceInstance;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.iai.v20200303.IaiClient;
import com.tencentcloudapi.iai.v20200303.models.CreateGroupRequest;
import com.tencentcloudapi.iai.v20200303.models.CreateGroupResponse;
import com.tencentcloudapi.iai.v20200303.models.DeleteGroupRequest;
import com.tencentcloudapi.iai.v20200303.models.DeleteGroupResponse;
import com.tencentcloudapi.iai.v20200303.models.GetGroupInfoRequest;
import com.tencentcloudapi.iai.v20200303.models.GetGroupInfoResponse;
import com.tencentcloudapi.iai.v20200303.models.GetGroupListRequest;
import com.tencentcloudapi.iai.v20200303.models.GetGroupListResponse;
import com.tencentcloudapi.iai.v20200303.models.GetUpgradeGroupFaceModelVersionJobListRequest;
import com.tencentcloudapi.iai.v20200303.models.GetUpgradeGroupFaceModelVersionJobListResponse;
import com.tencentcloudapi.iai.v20200303.models.GetUpgradeGroupFaceModelVersionResultRequest;
import com.tencentcloudapi.iai.v20200303.models.GetUpgradeGroupFaceModelVersionResultResponse;
import com.tencentcloudapi.iai.v20200303.models.ModifyGroupRequest;
import com.tencentcloudapi.iai.v20200303.models.ModifyGroupResponse;
import com.tencentcloudapi.iai.v20200303.models.RevertGroupFaceModelVersionRequest;
import com.tencentcloudapi.iai.v20200303.models.RevertGroupFaceModelVersionResponse;
import com.tencentcloudapi.iai.v20200303.models.UpgradeGroupFaceModelVersionRequest;
import com.tencentcloudapi.iai.v20200303.models.UpgradeGroupFaceModelVersionResponse;

import java.util.Map;

/**
 * 人员库管理
 */
public class Group {

    /**
     * 创建人员库
     */
    public String CreateGroup(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            CreateGroupRequest req = new CreateGroupRequest();
            req.setGroupName(params.get("groupName"));
            req.setGroupId(params.get("groupId"));
            req.setTag(params.get("tag"));

            CreateGroupResponse resp = client.CreateGroup(req);
            // 输出json格式的字符串回包
            resultJson = CreateGroupResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 删除人员库
     */
    public String DeleteGroup(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            DeleteGroupRequest req = new DeleteGroupRequest();
            req.setGroupId(params.get("groupId"));

            DeleteGroupResponse resp = client.DeleteGroup(req);
            // 输出json格式的字符串回包
            resultJson = DeleteGroupResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 获取人员库信息
     */
    public String GetGroupInfo(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            GetGroupInfoRequest req = new GetGroupInfoRequest();
            req.setGroupId(params.get("groupId"));

            GetGroupInfoResponse resp = client.GetGroupInfo(req);
            // 输出json格式的字符串回包
            resultJson = GetGroupInfoResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 获取人员库列表
     */
    public String GetGroupList(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            GetGroupListRequest req = new GetGroupListRequest();
            req.setOffset(Utils.type2Long(params,"offset",0));
            req.setLimit(Utils.type2Long(params,"limit",10));

            GetGroupListResponse resp = client.GetGroupList(req);
            // 输出json格式的字符串回包
            resultJson = GetGroupListResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 修改人员库
     */
    public String ModifyGroup(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            ModifyGroupRequest req = new ModifyGroupRequest();
            req.setGroupName(params.get("groupName"));
            req.setGroupId(params.get("groupId"));

            ModifyGroupResponse resp = client.ModifyGroup(req);
            // 输出json格式的字符串回包
            resultJson = ModifyGroupResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 人员库升级
     */
    public String UpgradeGroupFaceModelVersion(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            UpgradeGroupFaceModelVersionRequest req = new UpgradeGroupFaceModelVersionRequest();
            req.setGroupId(params.get("groupId"));

            UpgradeGroupFaceModelVersionResponse resp = client.UpgradeGroupFaceModelVersion(req);
            // 输出json格式的字符串回包
            resultJson = UpgradeGroupFaceModelVersionResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 人员库版本回滚
     */
    public String RevertGroupFaceModelVersion(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            RevertGroupFaceModelVersionRequest req = new RevertGroupFaceModelVersionRequest();
            req.setJobId(params.get("jobId"));

            RevertGroupFaceModelVersionResponse resp = client.RevertGroupFaceModelVersion(req);
            // 输出json格式的字符串回包
            resultJson = RevertGroupFaceModelVersionResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 获取人员库任务升级列表
     */
    public String GetUpgradeGroupFaceModelVersionJobList(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            GetUpgradeGroupFaceModelVersionJobListRequest req = new GetUpgradeGroupFaceModelVersionJobListRequest();
            req.setOffset(Utils.type2Long(params,"offset",0));
            req.setLimit(Utils.type2Long(params,"limit",10));
            GetUpgradeGroupFaceModelVersionJobListResponse resp = client.GetUpgradeGroupFaceModelVersionJobList(req);
            // 输出json格式的字符串回包
            resultJson = GetUpgradeGroupFaceModelVersionJobListResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 人员库升级结果查询
     */
    public String GetUpgradeGroupFaceModelVersionResult(Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey).getIaiClient();

            GetUpgradeGroupFaceModelVersionResultRequest req = new GetUpgradeGroupFaceModelVersionResultRequest();
            req.setJobId(params.get("jobId"));

            GetUpgradeGroupFaceModelVersionResultResponse resp = client.GetUpgradeGroupFaceModelVersionResult(req);
            // 输出json格式的字符串回包
            resultJson = GetUpgradeGroupFaceModelVersionResultResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

}
