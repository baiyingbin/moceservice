package com.tencent.wxcloudrun.controller.tencent.face.detect;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.controller.tencent.Utils;
import com.tencent.wxcloudrun.controller.tencent.face.FaceInstance;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.iai.v20200303.IaiClient;
import com.tencentcloudapi.iai.v20200303.models.DetectFaceAttributesRequest;
import com.tencentcloudapi.iai.v20200303.models.DetectFaceAttributesResponse;
import com.tencentcloudapi.iai.v20200303.models.DetectFaceRequest;
import com.tencentcloudapi.iai.v20200303.models.DetectFaceResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * 人脸检测
 */
@RestController
public class Detect {

    /**
     * 人脸检测与分析
     */
    @PostMapping(value = "/api/tencent/DetectFace")
    public String  DetectFace(@RequestBody Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey);
            DetectFaceRequest req = new DetectFaceRequest();
            req.setMaxFaceNum(Utils.type2Long(params,"maxFaceNum",1));
            req.setMinFaceSize(Utils.type2Long(params,"minFaceSize",34));
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));
            req.setNeedFaceAttributes(Utils.type2Long(params,"needFaceAttributes",1));
            req.setNeedQualityDetection(Utils.type2Long(params,"needQualityDetection",1));
            req.setNeedRotateDetection(Utils.type2Long(params,"needRotateDetection",1));
            DetectFaceResponse resp = client.DetectFace(req);
            // 输出json格式的字符串回包
            resultJson = DetectFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
    /**
     * 人脸检测与属性分析
     * 查看属性详细介绍：
     *      https://cloud.tencent.com/document/api/867/45020#FaceDetailAttributesInfo
     */
    @PostMapping(value = "/api/tencent/DetectFaceAttributes")
    public String  DetectFaceAttributes(@RequestBody Map<String,String> params) {
        String resultJson = "";
        try{
            String SecretId = params.get("SecretId");
            String SecretKey = params.get("SecretKey");
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance(SecretId,SecretKey);
            DetectFaceAttributesRequest req = new DetectFaceAttributesRequest();
            req.setMaxFaceNum(Utils.type2Long(params,"maxFaceNum",1));
            req.setImage(params.get("image"));
            req.setUrl(params.get("url"));
            //用逗号分割多个属性
            //None,Age,Beauty,Emotion,Eye,Eyebrow,
            //Gender,Hair,Hat,Headpose,Mask,Mouth,Moustache,Nose,Shape,Skin,Smile
            //req.setFaceAttributesType((params.get("faceAttributesType")));
            //默认展示所有
            req.setFaceAttributesType("None,Age,Beauty,Emotion,Eye,Eyebrow,Gender,Hair,Hat,Headpose,Mask,Mouth,Moustache,Nose,Shape,Skin,Smile");
            DetectFaceAttributesResponse resp = client.DetectFaceAttributes(req);
            // 输出json格式的字符串回包
            resultJson = DetectFaceAttributesResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

}
