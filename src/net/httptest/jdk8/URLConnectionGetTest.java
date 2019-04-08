package net.httptest.jdk8;

import java.io.*;
import java.net.*;
import java.util.*;


public class URLConnectionGetTest
{
   public static void main(String[] args)
   {
      try
      {
         String urlName = "http://www.baidu.com";

         URL url = new URL(urlName);
         URLConnection connection = url.openConnection(); 
         connection.connect();

         // http请求头

         Map<String, List<String>> headers = connection.getHeaderFields();
         for (Map.Entry<String, List<String>> entry : headers.entrySet())
         {
            String key = entry.getKey();
            for (String value : entry.getValue())
               System.out.println(key + ": " + value);
         }

         //打印请求头

         System.out.println("----------");
         System.out.println("getContentType: " + connection.getContentType());
         System.out.println("getContentLength: " + connection.getContentLength());
         System.out.println("getContentEncoding: " + connection.getContentEncoding());
         System.out.println("getDate: " + connection.getDate());
         System.out.println("getExpiration: " + connection.getExpiration());
         System.out.println("getLastModifed: " + connection.getLastModified());
         System.out.println("----------");

         BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

         // 打印输出
         String line = "";
         while((line=br.readLine()) != null)
         {
        	 System.out.println(line);
         }
         br.close();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}
   