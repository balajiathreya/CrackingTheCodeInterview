package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baathreya on 9/9/15.
 *
 * Write a function that compute the sum of the numbers in a given list using recursion.
 */
public class ListAdditionByRecursion {

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6};
        System.out.println(add(0L,new ArrayList<Integer>(Arrays.asList(arr)),0 ));
    }

    private static long add(long num, List<Integer> list, int index) {
        if(list == null || list.size() == 0 || index == list.size()){
            return num;
        }
        else {
            long res = num + list.get(index);
            index++;
            return add(res, list, index);
        }
    }
}
