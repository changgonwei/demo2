package com.example.demo.offer;

import java.util.Arrays;
import java.util.HashSet;


public class ArrayText {

    public static void main(String args[]){
        int[] a=new int[]{1,2,3,5,5,3};
        Arrays.sort(a);
        HashSet s=new HashSet();
        for (int i = 0; i <a.length-1 ; i++) {
            if(a[i]==a[i+1]){
                s.add(a[i]);
            }

        }
        for (Object bb:s
             ) {
            System.out.println(bb);
        }


    }


}

