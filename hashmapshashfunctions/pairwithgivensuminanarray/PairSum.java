package com.hashmapshashfunctions.pairwithgivensuminanarray;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class PairSum{
    HashMap<Map.Entry<Integer,Integer>,Integer> result = new HashMap<>();
    int[] res;
    int number;
    public void pair(int[] arr,int number){
        this.number=number;
        res=arr;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++) {
                Map.Entry<Integer, Integer> key = new AbstractMap.SimpleEntry<>(i, j);
                ;
                sum = sum + arr[j];
                result.put(key, sum);
            }
        }
    }
    public void display() {
        for (Map.Entry<Map.Entry<Integer, Integer>, Integer> entry : result.entrySet()) {
            if(entry.getValue()==number){
                System.out.println("Subarray (" + entry.getKey().getKey() + ", " + entry.getKey().getValue() + ") → Sum: " + entry.getValue());
                System.out.println("The sub array ");
                System.out.print("[");
                for(int i=entry.getKey().getKey();i<entry.getKey().getValue()+1;i++){
                    System.out.print(res[i]);
                    if(i!=entry.getKey().getValue()){
                        System.out.print(",");
                    }
                }
                System.out.println("]");
            }
        }
    }}






