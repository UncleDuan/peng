package jvm;

/**
 * Created by ionolab-DP on 2018/12/28.
 */
public class TryAndReturn {
    public static void main(String[] args) {
        int result=new TryAndReturn().test();
        System.out.println(result);
    }

    public static int test(){
        int x=1;
        try {
            return x;
        }
        finally {
            x++;

            System.out.println(x);
            return x;
        }
    }
}
