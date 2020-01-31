package com.possible.hashcode;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HashCodePizza {
    private Path p;
    private int[] pizzaSlice;
    private int pizzaType;
    private int numOfParticipant;
    private int maxOrder;

    public HashCodePizza(String fileName){
        p = Paths.get(fileName).toAbsolutePath();
        getPizzaSlice(p);

    }

    private void getPizzaSlice(Path p){
        int pizzaSliceArray[] = new int[0];
        try (BufferedReader inputVal = new BufferedReader(new FileReader(String.valueOf(p)))){
            String eachLine = "";
            String [] lines  = new String [2];
            int counter = 0;
            while((eachLine = inputVal.readLine()) != null){
                lines[counter] = eachLine;
                counter++;
            }

            String [] lineOneSplit = lines[0].split(" ");
            numOfParticipant = Integer.parseInt(lineOneSplit[0]);
            pizzaType = Integer.parseInt(lineOneSplit[1]);
            pizzaSliceArray = new int [pizzaType];

            String [] lineTwoSplit = lines[1].split(" ");
            // int [] pizzaSliceArray = new int [eachLineSplit.length];
            for(int i = 0; i < lineTwoSplit.length; i++){
                pizzaSliceArray[i] = Integer.parseInt(lineTwoSplit[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        orderedPizza(pizzaSliceArray);
    }

    private void orderedPizza(int [] pizzaSlice){
        try(PrintWriter writeOrder = new PrintWriter(new FileWriter("./resultFile.txt"))){
            List<String> orderedSlice = new ArrayList<>();
            int orderedSliceIndex = pizzaType - 1;
            for(int index = orderedSliceIndex ; index >= 0; index--){
                int numOfPizzaSlice = pizzaSlice[index];
                if(numOfPizzaSlice < numOfParticipant){
                    numOfParticipant = numOfParticipant - numOfPizzaSlice;
                    orderedSlice.add(String.valueOf(index));
                    maxOrder++;
                }
            }

            Collections.reverse(orderedSlice);
            String[] tempsArray =  orderedSlice.toArray(new String[0]);
            writeOrder.println(maxOrder);

            for(String orderedIndex : tempsArray){
                writeOrder.printf("%s%s",orderedIndex," ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
