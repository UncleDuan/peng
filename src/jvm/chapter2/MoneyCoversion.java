package jvm.chapter2;

/**
 * Created by ionolab-DP on 2019/1/5.
 */
public class MoneyCoversion {

    private static final String[] amounts = {"零","壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖",};
    private static final String[] units={"元","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟","万"};

    public static String coversion(int money){
        StringBuffer stringBuffer=new StringBuffer();
        int amountPointer=0;
        int unitPointer=0;
        while (money!=0){
            stringBuffer.insert(0,units[unitPointer++]);
            amountPointer=money%10;
            stringBuffer.insert(0,amounts[amountPointer]);
            money=money/10;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        int num=124005638;
        System.out.println(coversion(num));
    }
}