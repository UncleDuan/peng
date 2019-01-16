package offer;

/**
 * Created by ionolab-DP on 2019/1/12.
 */
public class NumberOf1 {
    public static int number(int num){
        int count=0;

        for(int i=0;i<32;i++){
            if ((num&1)==1){
                count++;
            }
            num=num>>>1;
        }
        return count;

    }

    /**
     * 把一个整数减去1，再和原整数做与运算，就会把整数最右边一个1变成0；
     * 利用上述性质就可以有多少个1，进行多少次操作。
     *
     *
     * @param num 整数
     * @return 整数中1的个数，负数采用补码表示
     */
    public static int number2(int num){
        int count=0;

        while (num!=0){
            count++;
            num=num&(num-1);
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(number2(-1));
    }
}
