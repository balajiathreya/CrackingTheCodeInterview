package chapter3;

/**
 * Created by baathreya on 5/25/15.
 *
 * Describe how you could use a single array to implement three stacks
 */
public abstract class StacksWithArray {
    protected int arraySize;
    protected int[] buffer;
    protected int[] top = new int[3];
    protected int[] end = new int[3];
    public abstract void push(int x, int stackIndex) throws IllegalArgumentException;
    public abstract int pop(int stackIndex);
    public StacksWithArray(int size){
        this.arraySize = size;
        buffer = new int[arraySize];
        int fac = size/3;
        end[0] = fac - 1;
        end[1] = end[0] + fac;
        end[2] = size - 1;
        top[0] = -1;
        top[1] = end[0];
        top[2] = end[1];
    }

    public static void main(String[] args) {
        testStackWIthArrays1();
    }

    private static void testStackWIthArrays1() {
        StacksWithArray1 stacksWithArray1 = new StacksWithArray1(10);
        stacksWithArray1.push(0,0);
        stacksWithArray1.push(1,0);
        stacksWithArray1.push(2,0);
        stacksWithArray1.push(3,1);
        stacksWithArray1.push(4,1);
        stacksWithArray1.push(5,1);
        stacksWithArray1.push(6,2);
        stacksWithArray1.push(7,2);
        stacksWithArray1.push(8,2);
        stacksWithArray1.push(9,2);
        try{
            stacksWithArray1.push(11,0);
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(stacksWithArray1.pop(2));
        System.out.println(stacksWithArray1.pop(2));
        System.out.println(stacksWithArray1.pop(2));
        System.out.println(stacksWithArray1.pop(2));
    }
}


class StacksWithArray1 extends StacksWithArray {
    public StacksWithArray1(int s){ super(s); }
    @Override
    public void push(int x, int stackIndex) throws IllegalArgumentException {
        if(top[stackIndex] == end[stackIndex]) {
            throw new IllegalArgumentException("Stack " + stackIndex + " is already full ");
        }
        else {
            int t = top[stackIndex];
            buffer[++t] = x;
            top[stackIndex] = t;
            System.out.println("Inserted " + x + " at index " + t);
        }

    }
    @Override
    public int pop(int stackIndex) {
        int t = top[stackIndex];
        int x = buffer[t];
        top[stackIndex] = --t;
        return x;
    }

}
