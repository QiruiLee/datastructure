package src.com.lqr.sparsearray;/**
  *@Description TODO
  *@Author lqr
  *@Date 2023/2/16 11:13
  *@Version 1.0
  **/
public class SparseArray
{
    public static void main(String[] args) {
        //1.定义一个原始数组
        int[][] array= new int[11][11];
        array[1][2]=1;
        array[2][3]=2;
        //2.遍历
        for(int[] row:array){
            for (int value:row){
                System.out.printf("%d\t",value);
            }
            System.out.println();
        }
        //3.转换成稀疏数组
        int valueCount=0;
        for(int[] row:array){
            for (int value:row){
                if(value!=0) {
                    valueCount++;
                }
            }
        }
        int[][] sparseArray = new int[valueCount+1][3];
        int count=0;
        sparseArray[0][0]=array.length;
        sparseArray[0][1]=array[0].length;
        sparseArray[0][2]=valueCount;
        int rowNum=0;
        for(int[] row:array){
            rowNum++;
            int colNum=0;
            for (int value:row){
                colNum++;
                if(value!=0) {
                    count++;
                    sparseArray[count][0]=rowNum;
                    sparseArray[count][1]=colNum;
                    sparseArray[count][2]=value;
                }
            }
        }
        //4.稀疏数组输出
        for (int[] row : sparseArray) {
            System.out.printf("%d\t%d\t%d\t\n",row[0],row[1],row[2]);
        }
        //5.转回普通数组
        int [][]newArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        boolean flag=false;
        for (int[] value : sparseArray) {
            if(flag){
            newArray[value[0]-1][value[1]-1]=value[2];
            }
            flag=true;
        }
        //6.输出普通数组
        for (int[] row : newArray) {
            for (int cell : row) {
                System.out.printf("%d\t",cell);
            }
            System.out.println();
        }
    }
}
