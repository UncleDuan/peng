package jvm;

import java.io.*;
import org.junit.Test;
/**
 * Created by ionolab-DP on 2018/12/29.
 */
public class AboutIO {
    public static void main(String[] args) {

    }

    @Test
    public void outputStream(){
        String str="待处理的字符串";
        //文件写
        try {
            File file=new File("myFile.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(str.getBytes("UTF-8"));
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileWriter(){
        String str="待处理的字符串";
        //文件读
        try {
            File file=new File("myFileByFileWriter.txt");
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printWriter(){
        String str="待处理的字符串";
        try {
            PrintWriter printWriter=new PrintWriter("myFileByPrintWriter.txt");
            printWriter.write(str);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileReader(){
        try {
            FileReader fileReader=new FileReader("C:\\Users\\ionolab-DP\\IdeaProjects\\interview\\myFileByPrintWriter.txt");
            char[] buf=new char[1024];
            int len=fileReader.read(buf);
            String myStr=new String(buf,0,len);
            System.out.println(myStr);
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileInputStream(){
        try {
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\ionolab-DP\\IdeaProjects\\interview\\myFileByPrintWriter.txt");
            byte[] buf=new byte[1024];
            int len=fileInputStream.read(buf);
            String myStr=new String(buf,0,len,"UTF-8");
            System.out.println(myStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bufferedReader(){
        try {
            BufferedReader bufferedReader=new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(
                            "C:\\Users\\ionolab-DP\\IdeaProjects\\interview\\myFileByPrintWriter.txt"),"UTF-8"));
            String myStr=bufferedReader.readLine();
            bufferedReader.close();
            System.out.println(myStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
