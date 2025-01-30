package com.stacksandqueues.implementingqueueusingstack;

import java.util.Stack;

public class QueueUsingStack {
    //Instance Variable
    Stack<Integer> stack;

    //constructor to initial the instance variable
    public QueueUsingStack() {
        this.stack = new Stack<>();
    }

    //enqueue Method
    public void enqueue(int value) {
        stack.push(value);
    }

    //dequeue method
    public int dequeue(){
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()){
            temp.push(stack.pop());
        }
        int deletedElement = temp.pop();
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return deletedElement;
    }

    //peek method
    public int queuePeek(){
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()){
            temp.push(stack.pop());
        }
        int deletedElement = temp.peek();
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return deletedElement;
    }

    //Check is Empty
    public boolean isQueueEmpty(){
        return stack.isEmpty();
    }



}