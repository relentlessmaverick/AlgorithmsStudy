package com.lists;

import java.util.Stack;

/*
 * Implement a Queue Using Stacks
 * Basic Assumption : No pop or peek operations will be called on an empty queue
 */

public class QueueUsingStacks {
	Stack<Integer> inStack;
    Stack<Integer> outStack;
    
    /** Initialize your data structure here. */
    public QueueUsingStacks() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!outStack.isEmpty()) {
            return outStack.pop();
        }else{
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }    
    }
    
    /** Get the front element. */
    public int peek() {
         if(!outStack.isEmpty()) {
            return outStack.peek();
        }else{
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
            return outStack.peek();    
         }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (inStack.isEmpty() && outStack.isEmpty());
    }

}
