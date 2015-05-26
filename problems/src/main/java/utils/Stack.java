package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baathreya on 5/25/15.
 */
public class Stack {
    protected List<Integer> list = new ArrayList();
    protected int top;

    public void push(int x){
        list.add(x);
        top++;
    }

    public int pop(){
        int x = list.get(--top);
        return x;
    }

    public int peek(){
        return list.get(top);
    }
}
