package com.example.demo.offer;

public class DoubleArray {
     static boolean doubleArray(int targe,int[][] array){
        if(array==null||array.length<=0){
            return false;
        }
        int row=0;
        int cloumn=array[0].length-1;
        while(row<=array.length-1&&cloumn>=0){
            if(targe==array[row][cloumn]){
                return true;
            }else if(targe>array[row][cloumn]){
                    row++;
            }else{
                cloumn--;
            }
        }
        return false;
    }

    public static void main(String args[]){
        int[][] a={{1,2,5,8},{4,6,7,10},{3,9,12,15},{6,7,18,20}};
        int c=1;
        boolean s=DoubleArray.doubleArray(c,a);
        System.out.println(s);

    }
}
