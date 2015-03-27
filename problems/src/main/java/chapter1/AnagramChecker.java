package chapter1;

/**
 * Created by baathreya on 3/25/15.
 *
 * Write a method to decide if two strings are anagrams or not
 *
 */
public class AnagramChecker {

    public static void main(String[] args) {
        AnagramChecker checker = new AnagramChecker();
        System.out.println(checker.isAnagram("blah","blew"));
        System.out.println(checker.isAnagram("blah","halbxxx"));
        System.out.println(checker.isAnagram("blahx","halbxxx"));
        System.out.println(checker.isAnagram("blah","halb"));
    }


    private boolean isAnagram(String str1, String str2){
        int[] checkArray = new int[256];
        if(str1 == null && str2 == null){
            return true;
        }
        else if(str1 == null || str2 == null || str1.length() != str2.length()){
            return false;
        }
        for(int i = 0 ; i < str1.length(); i++){
            int c = (int) str1.charAt(i);
            checkArray[c]++;
        }

        for (int i = 0; i < str2.length(); i++){
            int c = (int) str2.charAt(i);
            if(checkArray[c] == 0){
                return false;
            }
            else {
                checkArray[c]--;
            }
        }
// is it possible to get rid of this for loop?
        for(int i = 0; i < str1.length(); i++){
            int c = (int) str1.charAt(i);
            if(checkArray[c] != 0){
                return false;
            }
        }
        return true;
    }
}
