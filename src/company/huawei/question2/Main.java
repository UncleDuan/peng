package company.huawei.question2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int num=scanner.nextInt();
            int[] data=new int[10001];
            for (int i=0;i<num;i++){
                int input=scanner.nextInt();
                data[input]=1;
            }
            for (int i=0;i<1001;i++){
                if (data[i]==1){
                    System.out.println(i);
                }
            }

        }
    }
}
