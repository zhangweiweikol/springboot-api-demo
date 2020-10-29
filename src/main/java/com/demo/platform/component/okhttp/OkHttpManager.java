package com.demo.platform.component.okhttp;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Component
public class OkHttpManager {


    //MEDIA_TYPE <==> Content-Type
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    //MEDIA_TYPE_TEXT post请求不是application/x-www-form-urlencoded的，全部直接返回，不作处理，
    // 即不会解析表单数据来放到request parameter map中。所以通过request.getParameter(name)是获取不到的。
    // 只能使用最原始的方式，读取输入流来获取。
    private static final MediaType MEDIA_TYPE_TEXT = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");


    @Autowired
    OkHttpClient okhttpClient;


    public String sendByGetUrl(String url) throws Exception {
        String result;
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = null;
        try {
            response = okhttpClient.newCall(request).execute();
            assert response.body() != null;
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception();
        }
        return result;
    }


    public String sendByPostJson(String url, String json) throws Exception {
        String reStr = null;
        RequestBody body = RequestBody.create(json, MEDIA_TYPE_JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = null;
        try {
            response = okhttpClient.newCall(request).execute();
            assert response.body() != null;
            reStr = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception();
        }
        return reStr;
    }



    public String sendByPostMap(String url, Map<String, String> params) throws Exception {
        String result;
        StringBuilder content = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            content.append(entry.getKey()).append("=").append(entry.getValue());
            if (iterator.hasNext()) {
                content.append("&");
            }
        }

        RequestBody requestBody = RequestBody.create(content.toString(), MEDIA_TYPE_TEXT);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = null;
        try {
            response = okhttpClient.newCall(request).execute();
            assert response.body() != null;
            result = response.body().string();
            System.out.println("result = " + result);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception();
        }
        return result;
    }



    public  ResponseBody upload(String url, String filePath, String fileName) throws Exception {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file",
                        fileName,
                        RequestBody.create(MediaType.parse("multipart/form-data"),
                        new File(filePath)))
                .build();

        Request request = new Request.Builder()
                .header("Authorization", "Client-ID " + UUID.randomUUID())
                .url(url)
                .post(requestBody)
                .build();

        Response response = okhttpClient.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        return response.body();
    }



    public String doDelete(String url, Map<String, String> params, Map<String, String> headerParam) throws Exception {
        FormBody formBody =addParamToBuilder(params);
        Request.Builder request = buildHeader(headerParam);
        Request buildRequest = request.delete(formBody).url(url).build();
        return execute(buildRequest);
    }


    public String doPutJson(String url, Map<String,String> headermap, String json) throws Exception {
        return exectePut(url, json,headermap, MEDIA_TYPE_JSON);
    }

    public String exectePut(String url, String data, Map<String, String> headerMap, MediaType contentType) throws Exception {
        RequestBody requestBody = RequestBody.create(contentType, data);
        Request.Builder builder = buildHeader(headerMap);
        Request request = builder.put(requestBody).url(url).build();
        return execute(request);
    }


    public String doPut(String url, Map<String, String> params, Map<String, String> headerParam) throws Exception {
        FormBody formBody = addParamToBuilder(params);
        Request.Builder request = buildHeader(headerParam);
        Request buildRequest = request.put(formBody).url(url).build();
        return execute(buildRequest);
    }












    private FormBody addParamToBuilder(Map<String, String> params){
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
        return builder.build();
    }

    private  Request.Builder buildHeader(Map<String, String> headerParam){
        Request.Builder request = new Request.Builder();
        if (!Objects.isNull(headerParam) && headerParam.size() > 0) {
            for (Map.Entry<String, String> entry : headerParam.entrySet()) {
                request.addHeader(entry.getKey(), entry.getValue());
            }
        }
        return request;
    }


    private String execute(Request request) throws Exception {
        Response response = null;
        try {
            response = okhttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return new String(response.body().bytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return "";
    }

}