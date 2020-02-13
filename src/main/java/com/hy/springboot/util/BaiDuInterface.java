package com.hy.springboot.util;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;

//24.f75b1d5924829414af8ed7ef60402a5f.2592000.1578758968.282335-18013433
public class BaiDuInterface {


    /**
     *
     * @param filePath 文件路径
     * @return
     */
    public static String general(String filePath) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";
        try {
            // 本地文件路径

            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.f75b1d5924829414af8ed7ef60402a5f.2592000.1578758968.282335-18013433";

            String json = HttpUtil.post(url, accessToken, param);
            String result = "";
            JSONObject dataJson = new JSONObject(json);// 把字符串转成json数据
            JSONArray face_lists = dataJson.getJSONArray("words_result");
            for (int i = 0; i < face_lists.length(); i++) {// 循环数组，取出想要的数据
                JSONObject face1 = (JSONObject) face_lists.get(i);
                System.out.println("location"+face1.get("words"));
                String lists = face1.get("words").toString();
                result += lists;
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}