package org.jaden.jpa.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * HttpReq请求封装
 */
public final class HttpClientUtils {

    public enum ContentType{
        APPLICATION_JSON("application/json");
        String value;
        ContentType(String value){
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    public enum CharSet{
        UTF_8("UTF-8");
        String value;
        CharSet(String value){
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }
    private static final String UTF_8 = "UTF-8";
    private static final String APPLICATION_JSON = "application/json";
    private static final int TIMEOUT = 120000;//设置延时20分钟

    /**
     * 声明回调接口
     */
    public abstract class HttpRequestCallBack{

       abstract void onStart();
       abstract void onFinshi();
       abstract void onSuccess();
       abstract void onFail(String error);

    }

    /**
     * 私有构造函数
     */
    private HttpClientUtils() {
    }



    /**
     * 发送POST请求
     * 请求参数为字符串
     *
     * @param url
     * @param requestBody
     * @return
     * @throws Exception
     */
    public static String httpPostReqStringEntity(String url, String requestBody) throws Exception {
        if (StringUtils.isBlank(url)) {
            return null;
        }

        CloseableHttpClient defaultHttp = getDefaultHttpClient();
        HttpPost httpPost = httpPost(url);

        RequestConfig build = getRequestConfig();//设置超时时间

        httpPost.setConfig(build);
        StringEntity stringEntity = new StringEntity(requestBody, "UTF-8");
        stringEntity.setContentEncoding(UTF_8);
        stringEntity.setContentType(APPLICATION_JSON);
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse executeResult = defaultHttp.execute(httpPost);
        HttpEntity entity = executeResult.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");

        httpPost.releaseConnection();//释放连接
        closeHttpClient(defaultHttp);//关闭请求
        return result;
    }



    /**
     * 发送POST请求
     * 请求参数为字符串
     *
     * @param url
     * @param requestBody
     * @return
     * @throws Exception
     */
    public static <FormatType> FormatType doPost(String url,
                                                      HttpClientUtils.CharSet charSet,
                                                      HttpClientUtils.ContentType contentType,
                                                      String requestBody,
                                                      Class<FormatType> formatType,HttpRequestCallBack callBack) {
        try {
            if (callBack != null) {
                callBack.onStart();
            }

            if (StringUtils.isBlank(url)) {
                return null;
            }

            FormatType formatTypeResult = JSONObject.parseObject(doPost(url, charSet, contentType, requestBody), formatType);
            if (callBack != null) {
                callBack.onSuccess();
            }
            return formatTypeResult;
        } catch (Exception e) {
            callBack.onFail(e.getMessage());
        }
        return null;
    }

    /**
     * post请求
     * @param url
     * @param charSet
     * @param contentType
     * @param requestBody
     * @return
     * @throws Exception
     */
    private static String doPost(String url, CharSet charSet, ContentType contentType, String requestBody) throws Exception {
        CloseableHttpClient defaultHttp = getDefaultHttpClient();
        HttpPost httpPost = httpPost(url);

        RequestConfig build = getRequestConfig();//设置超时时间

        httpPost.setConfig(build);
        StringEntity stringEntity = new StringEntity(requestBody);
        if (charSet != null) {
            stringEntity.setContentEncoding(charSet.value);
        }else{
            stringEntity.setContentEncoding(UTF_8);
        }

        if (contentType != null) {
            stringEntity.setContentType(contentType.value);
        }else{
            stringEntity.setContentType(APPLICATION_JSON);
        }
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse executeResult = defaultHttp.execute(httpPost);
        HttpEntity entity = executeResult.getEntity();
        String result = EntityUtils.toString(entity);

        httpPost.releaseConnection();//释放连接
        closeHttpClient(defaultHttp);//关闭请求
        return result;
    }


    /**
     *
     * @param url
     * 发送POST请求
     * 请求参数为字符串
     * @param requestBody
     * @return
     * @throws Exception
     */
//    public static <FormatType> List<FormatType> httpPostReqStringEntity(String url, String requestBody, ResolveResult<List<FormatType>> resolveResult) throws Exception {
//        if (StringUtils.isBlank(url)) {
//            return null;
//        }
//
//        if (resolveResult == null) {
//            return null;
//        }
//
//        CloseableHttpClient defaultHttp = getDefaultHttpClient();
//        HttpPost httpPost = httpPost(url);
//
//        RequestConfig build = getRequestConfig();//设置超时时间
//
//        httpPost.setConfig(build);
//        StringEntity stringEntity = new StringEntity(requestBody);
//        stringEntity.setContentEncoding(UTF_8);
//        stringEntity.setContentType(APPLICATION_JSON);
//        httpPost.setEntity(stringEntity);
//        CloseableHttpResponse executeResult = defaultHttp.execute(httpPost);
//        HttpEntity entity = executeResult.getEntity();
//        String result = EntityUtils.toString(entity);
//
//        httpPost.releaseConnection();//释放连接
//        closeHttpClient(defaultHttp);//关闭请求
//
//        return resolveResult.analysisResult(result);
//    }

    /**
     * 发送POST请求
     * 请求参数key value
     *
     * @param url
     * @param requestMap
     * @return
     * @throws Exception
     */
    public static String httpPostReqEntity(String url, Map<String, String> requestMap,String contentType) throws Exception {
        if (StringUtils.isBlank(url)) {
            return null;
        }

        CloseableHttpClient defaultHttp = getDefaultHttpClient();

        HttpPost httpPost = httpPost(url);
        RequestConfig build = getRequestConfig();//设置超时时间
        httpPost.setConfig(build);
        //设置参数
        List<NameValuePair> list = new ArrayList();
        if (requestMap != null && !requestMap.isEmpty()) {
            Set<String> strings = requestMap.keySet();
            for (String key : strings) {
                list.add(new BasicNameValuePair(key, requestMap.get(key)));
            }
        }

        UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(list, UTF_8);
        if(StringUtils.isNotBlank(contentType)){
            if(APPLICATION_JSON.equals(contentType)){
                uefEntity.setContentType(APPLICATION_JSON);
            }else{
                uefEntity.setContentType(contentType);
            }
        }


        httpPost.setEntity(uefEntity);
        CloseableHttpResponse executeResult = defaultHttp.execute(httpPost);
        HttpEntity entity = executeResult.getEntity();
        String result = EntityUtils.toString(entity, UTF_8);

        httpPost.releaseConnection();//释放连接
        closeHttpClient(defaultHttp);//关闭请求
        return result;
    }

    /**
     * GET请求
     *
     * @param url
     * @param requestBody
     * @return
     * @throws Exception
     */
    public static String httpGetReq(String url, String requestBody) throws Exception {
        if (StringUtils.isBlank(url)) {
            return null;
        }

        CloseableHttpClient defaultHttp = getDefaultHttpClient();
        HttpGet httpGet = httpGet(url);
        RequestConfig build = getRequestConfig();//设置超时时间
        httpGet.setConfig(build);
        //创建参数列表

        CloseableHttpResponse executeResult = defaultHttp.execute(httpGet);
        HttpEntity entity = executeResult.getEntity();
        String result = EntityUtils.toString(entity);
        httpGet.releaseConnection();//释放连接
        closeHttpClient(defaultHttp);//关闭请求
        return result;
    }

    /**
     * 创建POST请求
     *
     * @param url
     * @return
     */
    private static HttpPost httpPost(String url) {
        return new HttpPost(url);
    }

    /**
     * 创建GET请求
     *
     * @param url
     * @return
     */
    private static HttpGet httpGet(String url) {
        return new HttpGet(url);
    }

    /**
     * 获取默认请求
     *
     * @return
     */
    private static CloseableHttpClient getDefaultHttpClient() {
        return HttpClients.createDefault();
    }

    /**
     * 关闭请求客户端
     *
     * @param client
     * @throws Exception
     */
    private static void closeHttpClient(CloseableHttpClient client) throws Exception {
        if (client != null) {
            client.close();
        }
    }

    /**
     * 设置超时时间 20分钟
     *
     * @return
     */
    private static RequestConfig getRequestConfig() {
        return RequestConfig.custom()
                .setSocketTimeout(TIMEOUT)
                .setConnectTimeout(TIMEOUT)
                .setConnectionRequestTimeout(TIMEOUT)
                .build();
    }
}
