package company.huawei.question3;

/**
 * Created by ionolab-DP on 2018/12/28.
 */
import java.util.*;
public class Main{

    public static void main(String[] args){
        Map<String,Integer> cv=new HashMap<String,Integer>();
        cv.put("0",0);
        cv.put("1",1);
        cv.put("2",2);
        cv.put("3",3);
        cv.put("4",4);
        cv.put("5",5);
        cv.put("6",6);
        cv.put("7",7);
        cv.put("8",8);
        cv.put("9",9);
        cv.put("A",10);
        cv.put("B",11);
        cv.put("C",12);
        cv.put("D",13);
        cv.put("E",14);
        cv.put("F",15);
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            int result=0;
            if(s.length()>=3){
                if (s.substring(0,2).equals("0x")) {
                    int i=2;
                    for (i = 2; i < s.length(); i++) {
                        if (cv.containsKey(s.substring(i, i + 1))) {
                            result = cv.get(s.substring(i, i + 1)) + result * 16;
                        } else {
                            break;
                        }
                    }
                    if (i==s.length())
                    System.out.println(result);
                    else {
                        System.out.println("ILLEGAL ARGUMENT!:Hex format only contains \"A-F\"");
                    }
                }else{
                    System.out.println("ILLEGAL ARGUMENT!:The suffix should be \"0x\"");
                }
            }else{
                System.out.println("ILLEGAL ARGUMENT!:Wrong hex format,need suffix");
            }
        }
    }

}