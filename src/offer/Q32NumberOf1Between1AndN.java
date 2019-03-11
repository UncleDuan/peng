package offer;

/**
 * Created by pengsel on 2019/2/18.
 */
public class Q32NumberOf1Between1AndN {

    public static int numberOf1Between1AndN(int n,int digit){
        //扩展成包含digit{1,...,9}的个数,为0时不符合，因为：
        //1.范围不是从0开始的；
        //2.最后一个循环会多加一个base，相当于把n前面添加一个0也算进去了。
        if(n<digit)
            return 0;
        int count = 0;
        int base = 1;
        int round = n;
        int weight;
        while(round>0){
            weight = round%10;
            round/=10;
            if(weight==digit)
                count+=round*base+(n%base)+1;
            else if(weight>digit)
                count+=round*base+base;
            else
                count+=round*base;
            base*=10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndN(12,0));
    }

}
