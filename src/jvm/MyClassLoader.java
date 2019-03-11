package jvm;

import java.io.*;

/**
 * Created by pengsel on 2019/3/7.
 */
public class MyClassLoader extends ClassLoader{
    private String path;
    private String classLoaderName;

    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    /**
     * 寻找类文件
     * @param name
     * @return
     */
    @Override
    public Class findClass(String name){
        byte[] b=loadClassData(name);
        return defineClass(name,b,0,b.length);
    }

    //加载类文件
    private byte[] loadClassData(String name){
        name=path+name+".class";
        System.out.println(name);
        InputStream in=null;
        ByteArrayOutputStream out=null;
        try {
            in=new FileInputStream(new File(name));
            out=new ByteArrayOutputStream();
            int i=0;
            while ((i=in.read())!=-1){
                out.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }
}
