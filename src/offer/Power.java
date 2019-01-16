package offer;

import company.huawei.question2.Main;

/**
 * Created by ionolab-DP on 2019/1/12.
 */
public class Power {
    public static boolean getIllegalArgument=false;

    /**
     * 主函数：注意输入指数可能为负数
     * @param base 基数
     * @param exponent 指数
     * @return
     */
    public static double Power(double base,int exponent){
        if (Math.abs(base-0.0)<0.0000001){
            getIllegalArgument=true;
            return 0.0;
        }
        double result=0.0;
        int absExponent= Math.abs(exponent);
        result=powerWithAbsExponent(base,absExponent);
        if (exponent<0)
            result=1.0/result;
        return result;

    }

    /**
     * 处理输入为正指数的情况，采用迭代的方法，相比于一次一次乘，可以更快的得到
     * @param base
     * @param exponent
     * @return
     */
    private static double powerWithAbsExponent(double base, int exponent){
        if (exponent==0){
            return 1;
        }
        if (exponent==1){
            return base;
        }
        double result=powerWithAbsExponent(base,exponent>>>1);
        result*=result;
        if ((exponent&1)==1)
            result*=base;
        return result;
    }
    public static void main(String[] args) {
//        double test=1.01;
//        test=test+1.02;
//        System.out.println(test);
//        System.out.println(Double.toString(test));
//        int big = 1234567890;
//        float approx = big;
//        System.out.println(big - (int)approx);

//        System.out.println(Power(1.2,5));
//        System.out.println(getIllegalArgument);
        System.out.println(Power(2,-3));
        System.out.println(getIllegalArgument);
    }
}
