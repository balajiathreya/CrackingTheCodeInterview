package chapter3;

import utils.Stack;

/**
 * Created by baathreya on 5/25/15.
 *
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the
 * minimum element? Push, pop and min should all operate in O(1) time.
 */
public class StackWithMin extends Stack {

    public static void main(String[] args) {
        testStackWithMin2();
    }

    private static void testStackWithMin1() {
        StackWithMin1 stackWithMin = new StackWithMin1();
        stackWithMin.push(0);
        stackWithMin.push(1);
        stackWithMin.push(2343);
        stackWithMin.push(-3434);
        stackWithMin.push(53);
        stackWithMin.push(1911);
        stackWithMin.push(19);
        stackWithMin.push(91);
        stackWithMin.push(-123);
        System.out.println(stackWithMin.getMin());
        stackWithMin.push(-12312332);
        stackWithMin.pop();
        System.out.println(stackWithMin.getMin());
        stackWithMin.push(-12312332);
        stackWithMin.push(-12312332);
        stackWithMin.push(-12312332);
        System.out.println(stackWithMin.getMin());
    }

    private static void testStackWithMin2() {
        StackWithMin2 stackWithMin = new StackWithMin2();
        stackWithMin.push(0);
        stackWithMin.push(1);
        stackWithMin.push(2343);
        stackWithMin.push(-3434);
        stackWithMin.push(53);
        stackWithMin.push(1911);
        stackWithMin.push(19);
        stackWithMin.push(91);
        stackWithMin.push(-123);
        System.out.println(stackWithMin.getMin());
        stackWithMin.push(-12312332);
        stackWithMin.pop();
        System.out.println(stackWithMin.getMin());
        stackWithMin.push(-12312332);
        stackWithMin.push(-12312332);
        stackWithMin.push(-12312332);
        System.out.println(stackWithMin.getMin());
    }
}

class StackWithMin2 extends Stack {
    private Stack minStack;

    public StackWithMin2(){
        super();
        minStack = new Stack();
        minStack.push(Integer.MAX_VALUE);
    }

    @Override
    public void push(int x){
        int min = minStack.peek();
        if(x <= min){
            minStack.push(x);
        }
        list.add(x);
        top++;
    }

    @Override
    public int pop(){
        int x = list.get(top);
        top--;
        int min = minStack.peek();
        if(x == min){
            minStack.pop();
        }
        return x;
    }

    public int getMin() {
        return minStack.peek();
    }
}

// this doesn't work - got to use stack as min
class StackWithMin1 extends Stack {
    int firstMin = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;

    @Override
    public void push(int x){
        if(x < firstMin) {
            secondMin = firstMin;
            firstMin = x;
        }
        else if(x < secondMin) {
            secondMin = x;
        }
        list.add(x);
        ++top;
    }

    @Override
    public int pop(){
        int x = list.get(--top);
        if(x == firstMin){
            firstMin = secondMin;
            secondMin = Integer.MAX_VALUE;
        }
        return x;
    }

    public int getMin() {
        return firstMin;
    }
}
