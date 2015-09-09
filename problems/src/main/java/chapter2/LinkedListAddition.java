package chapter2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by baathreya on 6/4/15.
 *
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1’s digit is at the head of the list. Write a function
 * that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (3 -> 1 -> 5), (5 -> 9 -> 2) Output: 8 -> 0 -> 8
 *
 */
public class LinkedListAddition {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,1,5}));
        LinkedList<Integer> list2 = new LinkedList<Integer>(Arrays.asList(new Integer[]{1,5,9,2}));
        System.out.println(add(list1, list2));
    }

    protected static LinkedList<Integer> add(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();
        int carry = 0;
        LinkedList<Integer> result = new LinkedList<Integer>();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            int sum = iterator1.next() + iterator2.next() + carry;
            carry = insertDigit(result, sum);
        }
        while (iterator2.hasNext()){
            carry = insertRemainingFromList(iterator2, carry, result);
        }
        while (iterator1.hasNext()){
            carry = insertRemainingFromList(iterator1, carry, result);
        }
        return result;
    }

    private static int insertDigit(LinkedList<Integer> result, int sum) {
        int carry;
        if(sum < 10) {
            result.add(sum);
            carry = 0;
        }
        else {
            result.add(sum % 10);
            carry = 1;
        }
        return carry;
    }

    private static int insertRemainingFromList(Iterator<Integer> iterator2, int carry, LinkedList<Integer> result) {
        int sum = iterator2.next() + carry;
        carry = insertDigit(result, sum);
        return carry;
    }
}
