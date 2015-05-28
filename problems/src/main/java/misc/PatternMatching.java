package misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baathreya on 5/28/15.
 *
 * This was question from a phone interview for Apple. The question was you are given an string pattern and a list of strings.
 * Your solution should return 'accept' if the input string matches the string pattern; return 'reject' if the input string does
 * not match the string pattern.
 *
 * Examples:
 * pattern      |       string      |       output
 * _____________|___________________|_________________
 * abca         |       1231        |       accept
 *              |       abcd        |       reject
 *              |       pxtp        |       accept
 *              |       12311       |       reject
 *
 * Do you see the pattern here? There is a one-to-one mapping between characters of the strings.
 */
public class PatternMatching {
    private static final String ACCEPT = "accept";
    private static final String REJECT = "reject";
    private String pattern;

    public static void main(String[] args) {
        PatternMatching p = new PatternMatching("abca");
        p.isMatch("1231");
        p.isMatch("abcd");
        p.isMatch("pxtp");
        p.isMatch("12311");
    }

    public PatternMatching(String p){
        this.pattern = p;
    }

    public void isMatch(String s){
        if(s.length()!= pattern.length()){
            System.out.println(REJECT);
        }
        else {
            Map<Character, Character> characterMap = new HashMap<Character, Character>();
            for(int i=0; i < pattern.length(); i++){
                char c = s.charAt(i);
                char p = pattern.charAt(i);
                if(characterMap.containsKey(p)){
                    if(characterMap.get(p) != c){
                        System.out.println(REJECT);
                        return;
                    }
                }
                else {
                    characterMap.put(p,c);
                }
            }
            System.out.println(ACCEPT);
        }
    }

}
