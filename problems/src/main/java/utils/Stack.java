package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baathreya on 5/25/15.
 */
public class Stack {
    protected List<Integer> list = new ArrayList();
    protected int top = -1;

    public void push(int x){
        top++;
        list.add(x);
    }

    public int pop(){
        int x = list.get(top);
        top--;
        return x;
    }

    public int peek(){
        return list.get(top);
    }
}
