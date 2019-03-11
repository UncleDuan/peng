package offer;

import java.util.HashMap;

/**
 * Created by pengsel on 2019/2/20.
 */
public class Q34GetUglyNumber {
    public static int getUglyNumber(int index) {
        if (index < 7)return index;
        int[] res=new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, i;
        for (i = 1; i < index; ++i)
        {
            res[i] = min(res[t2] * 2, min(res[t3]*3, res[t5]*5));
            if (res[i] == res[t2] * 2)t2++;
            if (res[i] == res[t3] * 3)t3++;
            if (res[i] == res[t5] * 5)t5++;
        }
        return res[index - 1];
    }


    private static int min(int num1,int num2){
        return num1<num2?num1:num2;
    }

    public static void main(String[] args) {
        for (int i=1;i<10;i++){
            System.out.println(getUglyNumber(i));
        }

    }
}
