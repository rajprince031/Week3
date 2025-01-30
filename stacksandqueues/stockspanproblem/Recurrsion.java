package com.stacksandqueues.stockspanproblem;

import java.util.Stack;

public class Recurrsion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(100);
        stack.push(80);
        stack.push(60);
        stack.push(70);
        stack.push(60);
        stack.push(75);
        stack.push(85);
        int[] span = new int[stack.size()];
        for(int i=span.length-1; i>=0; i--) {
            int top = stack.pop();
            calculateSpan(stack, top, 1, span, i);
        }

        for(int i : span){
            System.out.print(i+" ");
        }

    }

    private static void calculateSpan(Stack<Integer> stack, int top, int count, int[] span, int index) {
        if(stack.isEmpty() || stack.peek() > top){
            span[index] = count;
            return;
        }
        int temp = stack.pop();
        calculateSpan(stack,top,count+1,span,index);
        stack.push(temp);
    }
}
