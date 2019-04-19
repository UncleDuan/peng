package net.httpcomponents;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpComponentsPostTest {

    public final static void main(String[] args) throws Exception {
    	
    	//��ȡ�ɹرյ� httpCilent
        //CloseableHttpClient httpClient = HttpClients.createDefault();
    	CloseableHttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
    	//���ó�ʱʱ��
        RequestConfig requestConfig = RequestConfig.custom().
                setConnectTimeout(10000).setConnectionRequestTimeout(10000)
                .setSocketTimeout(10000).setRedirectsEnabled(false).build();
         
        HttpPost httpPost = new HttpPost("https://tools.usps.com/go/ZipLookupAction.action");
        //���ó�ʱʱ��
        httpPost.setConfig(requestConfig);
        
        //װ��post�������
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>(); 
        list.add(new BasicNameValuePair("tAddress", URLEncoder.encode("1 Market Street", "UTF-8")));  //�������
        list.add(new BasicNameValuePair("tCity", URLEncoder.encode("San Francisco", "UTF-8"))); //�������
        list.add(new BasicNameValuePair("sState", "CA")); //�������
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8"); 
            //����post�������
            httpPost.setEntity(entity);
            httpPost.setHeader("User-Agent", "HTTPie/0.9.2");
            //httpPost.setHeader("Content-Type","application/form-data");
            HttpResponse httpResponse = httpClient.execute(httpPost);
            String strResult = "";
            if(httpResponse != null){ 
                System.out.println(httpResponse.getStatusLine().getStatusCode());
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    strResult = EntityUtils.toString(httpResponse.getEntity());
                }
                else {
                    strResult = "Error Response: " + httpResponse.getStatusLine().toString();
                } 
            }else{
                 
            }
            System.out.println(strResult);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(httpClient != null){
                    httpClient.close(); //�ͷ���Դ
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

