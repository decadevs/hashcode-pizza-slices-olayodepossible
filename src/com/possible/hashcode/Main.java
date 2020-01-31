package com.possible.hashcode;


import java.io.*;

public class Main {
    private static HashCodePizza configParser;
    public static void main(String[] args){

       String fileName = "hashcode.txt";
       configParser = new HashCodePizza(fileName);
    }
}
