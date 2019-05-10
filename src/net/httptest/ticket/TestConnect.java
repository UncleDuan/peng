package net.httptest.ticket;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestConnect {
    public static void main(String[] args) throws IOException {

        String str="http://e.hiphotos.baidu.com/image/pic/item/72f082025aafa40f2ff771cba864034f78f019f6.jpg";
        String urlString="https://kyfw.12306.cn/otn/passcodeNew/getPassCodeNew?module=login&rand=sjrand&"+Math.random();
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.connect();

    }
}
