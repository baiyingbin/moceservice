package com.tencent.wxcloudrun.controller.tencent.face.analyze;
import com.tencent.wxcloudrun.controller.tencent.face.FaceInstance;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.iai.v20200303.IaiClient;
import com.tencentcloudapi.iai.v20200303.models.AnalyzeDenseLandmarksRequest;
import com.tencentcloudapi.iai.v20200303.models.AnalyzeDenseLandmarksResponse;
import com.tencentcloudapi.iai.v20200303.models.AnalyzeFaceRequest;
import com.tencentcloudapi.iai.v20200303.models.AnalyzeFaceResponse;
import java.util.Map;

/**
 * 五官分析
 */
public class Analyze {

    /**
     * 五官定位
     */
    public String AnalyzeFace(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            // 实例化一个请求对象,每个接口都会对应一个request对象
            AnalyzeFaceRequest req = new AnalyzeFaceRequest();

            req.setUrl(params.get("url"));
            req.setImage(params.get("image"));

            // 返回的resp是一个AnalyzeFaceResponse的实例，与请求对象对应
            AnalyzeFaceResponse resp = client.AnalyzeFace(req);
            // 输出json格式的字符串回包
            resultJson = AnalyzeFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 稠密关键点
     */
    public String AnalyzeDenseLandmarks(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = FaceInstance.getInstance().getIaiClient();

            // 实例化一个请求对象,每个接口都会对应一个request对象
            AnalyzeDenseLandmarksRequest req = new AnalyzeDenseLandmarksRequest();

            req.setUrl(params.get("url"));
            req.setImage(params.get("image"));

            // 返回的resp是一个AnalyzeDenseLandmarksResponse的实例，与请求对象对应
            AnalyzeDenseLandmarksResponse resp = client.AnalyzeDenseLandmarks(req);
            // 输出json格式的字符串回包
            resultJson = AnalyzeDenseLandmarksResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
}
