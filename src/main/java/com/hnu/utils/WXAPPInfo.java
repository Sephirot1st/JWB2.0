package com.hnu.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class WXAPPInfo {

    public static String appid="wxb038b5f6187b1412";//微信小程序的appid
    public static String secret="34c21292b816bec5b5ad90562be44476";//微信小程序的secret

    public static String accessToken="";
    public static long aging=0;
    public static long getTime=0;

    /**
     * 获取访问微信服务端的token
     * @return token，失败返回null
     */
    public static String getAccess_token(){
        if(accessToken.equals("")){
            JSONObject object = getAccessToken();
            if(object==null){
                return null;
            }
            accessToken = object.getString("access_token");
            aging = object.getLongValue("expires_in");
            getTime = System.currentTimeMillis()/1000;
            return accessToken;
        }else {
            if((System.currentTimeMillis()/1000-getTime)<aging){
                return accessToken;
            }else {
                JSONObject object = getAccessToken();
                if(object==null){
                    return null;
                }
                accessToken = object.getString("access_token");
                aging = object.getLongValue("expires_in");
                getTime = System.currentTimeMillis()/1000;
                return accessToken;
            }
        }
    }

    /**
     * 获取小程序全局唯一后台接口调用凭据（access_token）。调用绝大多数后台接口时都需使用 access_token
     * @return 请求成功时，返回一个JSON对象，包含access_token和有效时长（以秒为时间单位）
     */
    public static JSONObject getAccessToken(){
        Map<String,String> req = new LinkedHashMap<>();
        req.put("grant_type","client_credential");
        req.put("appid",appid);
        req.put("secret",secret);
        String res = WebRequestUtil.wrGET("https://api.weixin.qq.com/cgi-bin/token",req);
        JSONObject object = isJSON(res);
        if(object == null){
            return null;
        }
        if(object.containsKey("access_token")){
            return object;
        }
        return null;
    }

    /**
     * 判断字符串是否是JSON
     * @param src 待判断的字符串
     * @return 是JSON返回一个JSON对象，否则返回null
     */
    public static JSONObject isJSON(String src){
        try {
            JSONObject res = JSONObject.parseObject(src);
            return res;
        }catch (RuntimeException e){
            return null;
        }
    }

    public static JSONArray isJSONArray(String src){
        try {
            JSONArray res = JSONArray.parseArray(src);
            return res;
        }catch (RuntimeException e){
            return null;
        }
    }

}
