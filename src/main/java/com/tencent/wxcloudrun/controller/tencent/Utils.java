package com.tencent.wxcloudrun.controller.tencent;

import java.util.Map;

public class Utils {


    public static long type2Long(Map<String,String> params, String key, long defaultValue){
        if(params.containsKey(key)){
            String maxFaceNum = params.get(key);
            if(maxFaceNum != null && !maxFaceNum.isEmpty()){
                return Long.parseLong(maxFaceNum);
            }
        }
        return defaultValue;
    }
    public static float type2Float(Map<String,String> params, String key, float defaultValue){
        if(params.containsKey(key)){
            String maxFaceNum = params.get(key);
            if(maxFaceNum != null && !maxFaceNum.isEmpty()){
                return Float.parseFloat(maxFaceNum);
            }
        }
        return defaultValue;
    }
}
