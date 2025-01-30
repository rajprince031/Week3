package com.stacksandqueues.implementingqueueusingstack;
public class Main {
    public static void main(String[] agrs){
        QueueUsingStack queue = new QueueUsingStack();

        //Adding and removing elements from the queue
        queue.enqueue(4);
        queue.enqueue(6);
        System.out.println(queue.dequeue());
        queue.enqueue(8);
        queue.dequeue();
        queue.enqueue(9);
        queue.enqueue(18);


        //Display the peek of the queue
        System.out.println(queue.queuePeek());

        //Dequeue and display all the elements
        while(!queue.isQueueEmpty()){
            System.out.print(queue.dequeue()+" ");
        }
        System.out.println();

        //Check the queue is empty or not
        if(queue.isQueueEmpty()){
            System.out.println("Queue is Empty");
        }else{
            System.out.println("Queue is not Empty");
        }

    }
}
