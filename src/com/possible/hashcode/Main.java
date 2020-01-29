package com.possible.hashcode;


import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Main {
   private static HashCodePizza configParser;
    public static void main(String[] args)throws FileNotFoundException{
        int a = 17;
        int max = 0;
        int arr [] = {2, 6, 5, 8};
        int arr1[] = new int[arr.length];
        System.arraycopy(arr,0,arr1,0, arr.length);
        Arrays.sort(arr1);


        for(int i = arr1.length -1 ; i >= 0; i--){
            if(arr1[i] < a){
                a = a - arr1[i];
                System.out.printf("%d%s",i," ");
                max++;
            }
        }
        System.out.println();
        System.out.println(max);
    }
}
