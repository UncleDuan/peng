package jvm.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ionolab-DP on 2019/1/3.
 */
public class OverrideEquals {
    public static void main(String[] args) throws IOException {
        Map results=new HashMap();
        InputStream inputStream=OverrideEquals.class.getResourceAsStream("info.txt");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        String line=null;
        while ((line=bufferedReader.readLine())!=null){

        }


    }

    static class User{

        public String name;
        public Integer value;
    }
}
