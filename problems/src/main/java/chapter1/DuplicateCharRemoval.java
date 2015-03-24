package chapter1;

/**
 * Created by baathreya on 3/24/15.
 *
 * Design an algorithm and write code to remove duplicate characters in a string without using any
 * additional buffer
 *
 * NOTE: One or two additional variables are fine An extra copy of the array is not
 *
 * FOLLOW UP: Write the test cases for this method
 *
 * possible solutions:
 * hold a checkArray containing boolean for all characters.
 * can use a stringbuilder to avoid creating new strings. can't loop and modify the string at the same time, whatcha gonna
 * do? loop through the array and append characters to the string builder.
 */
public class DuplicateCharRemoval {


    public static void main(String[] args) {
        DuplicateCharRemoval removal = new DuplicateCharRemoval();
        System.out.println(removal.removeDuplicates("blahab"));
        System.out.println(removal.removeDuplicates("blblaaa"));
    }

    protected String removeDuplicates(String str){
        if(str == null){
            return null;
        }
        StringBuilder builder = new StringBuilder();
        boolean[] checkArray = new boolean[256];
        for(char c : str.toCharArray()){
            int b = (int) c;
            if(!checkArray[b]){
                checkArray[b] = true;
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
