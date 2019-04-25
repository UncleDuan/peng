package net.webserver;

import java.io.IOException;
import java.io.InputStream;

public class Receive {
    InputStream ins=null;
    public Receive(InputStream ins){
        this.ins=ins;
    }
    public String parse(){
        StringBuffer receiveStr=new StringBuffer(2048);
        int i;
        byte[] buffer=new byte[2048];
        try {
            i=ins.read(buffer);

        } catch (IOException e) {
            i=-1;
        }
        for (int j=0;j<i;j++){
            receiveStr.append((char) buffer[j]);
        }
        return getURI(receiveStr.toString());
    }

    private String getURI(String receiveStr){
        int i1,i2;
        i1=receiveStr.indexOf(' ');
        if (i1!=-1){
            i2=receiveStr.substring(i1+1).indexOf(' ');
            if (i2!=-1)
                return receiveStr.substring(i1,i2);
        }
        return null;
    }
}
