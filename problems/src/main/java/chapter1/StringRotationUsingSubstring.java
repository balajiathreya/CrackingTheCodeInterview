package chapter1;

/**
 * Created by baathreya on 4/3/15.
 *
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to
 * isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
 *
 * note: isStringRotation(s1, s2) = isStringRotation(s2, s1);
 */
public class StringRotationUsingSubstring {


    public static void main(String[] args) {
        StringRotationUsingSubstring obj = new StringRotationUsingSubstring();
        System.out.println(obj.isStringRotation("erbottlewat", "waterbottle")); //true
        System.out.println(obj.isStringRotation("waterbottle", "erbottlewat")); //true
        System.out.println(obj.isStringRotation("blah", "ahlb")); //false
        System.out.println(obj.isStringRotation("blah", "ahbl")); //true
        System.out.println(obj.isStringRotation("apple", "pleap")); //true
        System.out.println(obj.isStringRotation("pleap", "apple")); //true
        System.out.println(obj.isStringRotation("ppale", "apple")); //false

    }

    /**
     *
     * @param s1
     * @param s2
     * @return true if s2 is a rotation of s1
     */
    private boolean isStringRotation(String s1, String s2){
        StringBuilder builder = new StringBuilder();
        builder.append(s1).append(s1);
        return isSubstring(builder.toString(), s2);
    }


    private boolean isSubstring(String str, String substring){
        return str.toLowerCase().contains(substring.toLowerCase());
    }
}
