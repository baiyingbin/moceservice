package com.tencent.wxcloudrun.controller.tencent.product;

import com.tencent.wxcloudrun.controller.tencent.Utils;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.tiia.v20190529.TiiaClient;
import com.tencentcloudapi.tiia.v20190529.models.*;

import java.util.Map;

/**
 * 物品检测
 */
public class Product {
    /**
     * 商品识别-微信识物版
     */
    public String DetectProductBeta(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            TiiaClient client = DetectProductInstance.getInstance().getTiiaClient();
            DetectProductBetaRequest req = new DetectProductBetaRequest();
            req.setImageUrl(params.get("imageUrl"));
            req.setImageBase64(params.get("imageBase64"));
            req.setNeedLemma(Utils.type2Long(params,"needLemma",0));
            // 返回的resp是一个DetectProductBetaResponse的实例，与请求对象对应
            DetectProductBetaResponse resp = client.DetectProductBeta(req);
            // 输出json格式的字符串回包
            resultJson = DetectProductBetaResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
    /**
     * 商品识别
     */
    public String DetectProduct(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            TiiaClient client = DetectProductInstance.getInstance().getTiiaClient();
            DetectProductRequest req = new DetectProductRequest();
            req.setImageUrl(params.get("imageUrl"));
            req.setImageBase64(params.get("imageBase64"));
            // 返回的resp是一个DetectProductResponse的实例，与请求对象对应
            DetectProductResponse resp = client.DetectProduct(req);
            // 输出json格式的字符串回包
            resultJson = DetectProductResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 车辆识别-增强版
     */
    public String RecognizeCarPro(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            TiiaClient client = DetectProductInstance.getInstance().getTiiaClient();
            RecognizeCarProRequest req = new RecognizeCarProRequest();
            req.setImageUrl(params.get("imageUrl"));
            req.setImageBase64(params.get("imageBase64"));
            // 返回的resp是一个DetectProductResponse的实例，与请求对象对应
            RecognizeCarProResponse resp = client.RecognizeCarPro(req);
            // 输出json格式的字符串回包
            resultJson = DetectProductResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 车辆识别
     */
    public String RecognizeCar(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            TiiaClient client = DetectProductInstance.getInstance().getTiiaClient();
            RecognizeCarRequest req = new RecognizeCarRequest();
            req.setImageUrl(params.get("imageUrl"));
            req.setImageBase64(params.get("imageBase64"));
            // 返回的resp是一个DetectProductResponse的实例，与请求对象对应
            RecognizeCarResponse resp = client.RecognizeCar(req);
            // 输出json格式的字符串回包
            resultJson = RecognizeCarResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 不良行为识别
     */
    public String DetectMisbehavior(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            TiiaClient client = DetectProductInstance.getInstance().getTiiaClient();
            DetectMisbehaviorRequest req = new DetectMisbehaviorRequest();
            req.setImageUrl(params.get("imageUrl"));
            req.setImageBase64(params.get("imageBase64"));
            // 返回的resp是一个DetectProductResponse的实例，与请求对象对应
            DetectMisbehaviorResponse resp = client.DetectMisbehavior(req);
            // 输出json格式的字符串回包
            resultJson = DetectMisbehaviorResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }

    /**
     * 恶心检测
     */
    public String DetectDisgust(Map<String,String> params) {
        String resultJson = "";
        try{
            // 实例化要请求产品的client对象,clientProfile是可选的
            TiiaClient client = DetectProductInstance.getInstance().getTiiaClient();
            DetectDisgustRequest req = new DetectDisgustRequest();
            req.setImageUrl(params.get("imageUrl"));
            req.setImageBase64(params.get("imageBase64"));
            // 返回的resp是一个DetectProductResponse的实例，与请求对象对应
            DetectDisgustResponse resp = client.DetectDisgust(req);
            // 输出json格式的字符串回包
            resultJson = DetectDisgustResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            resultJson = e.toString();
        }
        return resultJson;
    }
}