package offer;

public class Q28Permutation {
    public static void permutation(String string){
        if (string==null||string.equals(""))
            return;
        StringBuilder stringBuilder=new StringBuilder(string);
        int index=0;
        permutation(stringBuilder,index);
    }
    public static void permutation(StringBuilder stringBuilder,int index){
        if (index==stringBuilder.length())
            System.out.println(stringBuilder);
        for (int i=index;i<stringBuilder.length();i++){
            char temp=stringBuilder.charAt(index);
            stringBuilder.setCharAt(index,stringBuilder.charAt(i));
            stringBuilder.setCharAt(i,temp);
            permutation(stringBuilder,index+1);
            stringBuilder.setCharAt(i,stringBuilder.charAt(index));
            stringBuilder.setCharAt(index,temp);
        }
    }

    public static void main(String[] args) {
        permutation("abcdef");
    }
}
