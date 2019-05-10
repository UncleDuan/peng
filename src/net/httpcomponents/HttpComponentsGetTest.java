package net.httpcomponents;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpComponentsGetTest {

    private static Logger logger=Logger.getLogger(HttpComponentsGetTest.class);
    public final static void main(String[] args) throws Exception {
    	
    	CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)   //连接超时时间
                .setConnectionRequestTimeout(5000) // 请求超时时间
                .setSocketTimeout(5000)
                .setRedirectsEnabled(true)//跳转
                .build();
        
        HttpGet httpGet = new HttpGet("http://www.baidusasdasdas.com");
        httpGet.setConfig(requestConfig);
        String srtResult = "";
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                srtResult = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");//获取网页
                System.out.println(srtResult);
            }else
            {
                logger.info(String.format("网页请求异常，状态码为%s",httpResponse.getStatusLine().getStatusCode()));
            }
        } catch (IOException e) {
            logger.info("网页请求失败",e);
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.info("关闭连接失败",e);
            }
        }
    }
}

