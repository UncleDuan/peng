package offer;

public class Q20PrintMatrixClockwisely {
    public static void printMatrixClockwisely(int[][] array){
        if (array==null||array.length==0||(array.length==1&&array[0].length==0))
            return;
        int start=0;
        int row=array.length;
        int column=array[0].length;
        while (row>(2*start)&&column>(2*start)){
            printCircleClockwisely(array,start,row,column);
            start++;
        }
    }

    public static void printCircleClockwisely(int[][] array,int start,int row,int column){
        int endRow=row-start-1;
        int endColumn=column-start-1;
        //过程1，从(start,start)到(start,endColumn)
        for (int i=start;i<=endColumn;i++){
            System.out.println(array[start][i]);
        }
        //过程2，从(start+1,endColumn)到(endRow,endColumn)
        if (endRow>start){
            for (int i=start+1;i<=endRow;i++)
                System.out.println(array[i][endColumn]);
        }
        //过程3，从(endRow,endColumn-1)到(endRow,start)
        if (start<endColumn){
            for (int i=endColumn-1;i>=start;i--)
                System.out.println(array[endRow][i]);
        }
        //过程4，从(endRow-1,start)到(start+1,start)，完成一圈循环
        if (endRow>(start+1)&&start<endColumn)
            for (int i=endRow-1;i>start;i--)
                System.out.println(array[i][start]);
    }

    public static void main(String[] args) {
        int[][] array={{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        printMatrixClockwisely(array);
    }
}
