package com.stacksandqueues.stockspanproblem;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        //Create a stack array to store the stock price
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        //Create a span array to store the span of the stock price
        int[] span = new int[prices.length];

        //take a stack to calculate the span of the stock
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<prices.length; i++){

            while(!stack.isEmpty() && prices[stack.peek()] <= prices[i]){
                stack.pop();
            }

            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            stack.push(i);
        }

        //Display the span
        for(int i : span){
            System.out.print(i+" ");
        }

    }

}
