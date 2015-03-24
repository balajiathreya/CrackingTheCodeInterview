package chapter1;

/**
 * Created by baathreya on 3/24/15.
 *
 * Implement an algorithm to determine if a string has all unique characters What if you can
 * not use additional data structures?
 *
 *
 * assumptions:
 * can be any character, not just alphanumeric = restrict to ASCII characters - that reduces your problem to 128 characters.
 * Extended ASCII has 256 characters. Use this.
 *
 * UTF8 characters occupy 1-4 bytes. I think there are ~ 1 million possible code points in UTF8.
 *
 * ASCII is 7 bits while Extended ASCII is 8 bits.
 *
 *
 */
public class StringWithUniqueCharacters {

    public static void main(String[] args){

        StringWithUniqueCharacters test = new StringWithUniqueCharacters();
        System.out.println(test.hasUniqueCharacters("blaha"));
    }


    private boolean hasUniqueCharacters(String str){
        boolean[] checkArray = new boolean[256];
        for(char c : str.toCharArray()){
            int b = (int) c;
            if(checkArray[b]){
                return false;
            }
            else {
                checkArray[b] = true;
            }
        }
        return true;
    }
}
