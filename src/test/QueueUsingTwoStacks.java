package test;

import java.util.Stack;

public class QueueUsingTwoStacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    private void implementQueue(int[] arr)
    {
        for(int element:arr)
        {
            stack1.push(element);
        }
        while(!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
    }

    private int peek()
    {
        if(!stack2.isEmpty()) {
            return stack2.peek();
        }
        return -1;
    }

    private int pop()
    {
        if(!stack2.isEmpty()) {
            return stack2.pop();
        }
        return -1;
    }

    private void printQueue()
    {
        System.out.println();
        while(!stack2.isEmpty())
        {
            System.out.print(stack2.pop()+ " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        QueueUsingTwoStacks queueUsingTwoStacks = new QueueUsingTwoStacks();
        queueUsingTwoStacks.implementQueue(arr);
        System.out.println("peek "+ queueUsingTwoStacks.peek()+ " pop "+ queueUsingTwoStacks.pop());
        queueUsingTwoStacks.printQueue();
    }

}
