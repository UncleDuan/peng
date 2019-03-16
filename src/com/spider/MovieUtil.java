package com.spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by pengsel on 2019/3/1.
 */
public class MovieUtil {
    public static String getHtmlResourceByUrl(String url,String encoding){
        StringBuffer buffer=new StringBuffer();
        URL urlObj=null;
        URLConnection uc=null;
        InputStreamReader isr=null;
        BufferedReader reader=null;

        try {
            //建立网络连接
            urlObj=new URL(url);
            //打开网络连接
            uc=urlObj.openConnection();
            //建立文件输入流
            isr=new InputStreamReader(uc.getInputStream(),encoding);
            //建立文件缓冲流
            reader=new BufferedReader(isr);

            //建立临时变量
            String temp=null;
            while ((temp=reader.readLine())!=null){
                buffer.append(temp+"\n");
            }

        }catch (MalformedURLException e){
            e.printStackTrace();
            System.out.println("网络连接错误");
        }catch (java.io.IOException e) {
            e.printStackTrace();
        }finally {
            if (null!=isr)
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


        return buffer.toString();

    }

    public static void main(String[] args) {
        String url="https://blog.csdn.net/qq_37107280/article/details/73246274";
        System.out.println(getHtmlResourceByUrl(url,"utf-8"));
    }
}
