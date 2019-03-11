package jvm;

/**
 * Created by pengsel on 2019/3/7.
 */
public class MyClassLoaderTest {
    public static void main(String[] args) {
        MyClassLoader myClassLoader=new MyClassLoader("C:\\Users\\ionolab-DP\\IdeaProjects\\interview\\target\\classes\\jvm\\","myClassLoader");
        Class c= null;
        try {
            c = myClassLoader.loadClass("AboutIO");
            System.out.println(c.getClassLoader());
            c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
