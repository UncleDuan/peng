package jvm.chapter2;

/**
 * Created by ionolab-DP on 2019/1/2.
 * 1.Java默认的编码方式为GBK编码。
 * 2.GBK编码英文占一个字节，中文占两个字节，且这两个字节都是负数。
 *
 * 按字节截取，如果刚好截取到汉字的半个，不输出该汉字。
 */
public class GBKselect {
    public static void main(String[] args) throws Exception {
        String str="China中国,China我的国";
        byte[] buf = str.getBytes("GBK");
        int num=trimGBK(buf,17);
        System.out.println(str.substring(0,num));


    }

    private static int trimGBK(byte[] buf,int num) throws Exception {
        int countChinese=0;
        if (num>buf.length)
            throw new Exception("Index out of byte[]");
        for (int i=0;i<num;i++){
            if (buf[i]<0){
                countChinese++;
            }
        }
        if (countChinese%2==0)
            return num-countChinese/2;
        else
            return num-1-countChinese/2;
    }
}
