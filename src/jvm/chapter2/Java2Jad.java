package jvm.chapter2;

import java.io.*;

/**
 * Created by ionolab-DP on 2019/1/2.
 * 将E:\java文件夹的所有.java文件复制到E:\jad文件夹，并将后缀名改为.jad。
 */

public class Java2Jad {
    public static void main(String[] args) throws Exception{
        File srcDir=new File("E:\\java");
        if (!(srcDir.exists()&&srcDir.isDirectory()))
            throw new  Exception("Directory not exist");
        File[] files=srcDir.listFiles(
            new FilenameFilter(){
                public boolean accept(File dir,String name){
                    return name.endsWith(".java");
                }
            }
        );

        System.out.println(files.length);
        File destDir=new File("E:\\jad");
        if (!destDir.exists())
            destDir.mkdir();
        for (File f:files){
            FileInputStream fileInputStream=new FileInputStream(f);
            String destFileName=f.getName().replace("java$","jad");
            FileOutputStream fileOutputStream=new FileOutputStream(new File(destDir,destFileName));
            copy(fileInputStream,fileOutputStream);
            fileInputStream.close();
            fileOutputStream.close();
        }


    }


    private static void copy(FileInputStream fileInputStream,FileOutputStream fileOutputStream) throws IOException {
        int len =0;
        byte[] buf=new byte[1024];
        while ((len=fileInputStream.read(buf))!=-1){
            fileOutputStream.write(buf,0,len);
        }
    }
}
