package com.hashmapshashfunctions.longestconsecutivesequence;

import java.util.HashMap;

public class LongestConsective {
    int size;
    int[] base;
    public int find(int k){
        int count=1;
        int number=base[k];
    for(int i=k;i<size-1;i++){
      if ((number+count)==base[i+1]){
          count++;
      }
    }
    return count;

    }
    HashMap<Integer,Integer> consectivemap=new HashMap<>();
    public void consective(int arr[]){
        base=arr;
        size= arr.length;
        for(int j=0;j<size;j++){
           consectivemap.put(j, find(j));

        }

    }

    public void maxConsecutive(){
        int max=Integer.MIN_VALUE;
        for (Integer value : consectivemap.values()) {
            // Compare each value with max and update max if needed
            if (value > max) {
                max = value;
            }
        }
        System.out.println("The longest consecutive sequence length :- "+max);
    }
}
