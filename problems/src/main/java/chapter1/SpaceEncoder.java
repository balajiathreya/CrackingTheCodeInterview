package chapter1;

/**
 * Created by baathreya on 3/27/15.
 *
 * Write a method to replace all spaces in a string with ‘%20’
 *
 * without using StringBuilder
 *
 */
public class SpaceEncoder {

    public static void main(String[] args) {
        SpaceEncoder encoder = new SpaceEncoder();
        System.out.println(encoder.encodeSpaceWithoutStringBuilder("blah"));
        System.out.println(encoder.encodeSpaceWithoutStringBuilder("bl a  h"));
        System.out.println(encoder.encodeSpaceWithoutStringBuilder(" blah "));
    }

    private String encodeSpaceWithStringBuilder(String str){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                builder.append("%20");
            }
            else {
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }

    private String encodeSpaceWithoutStringBuilder(String str){
        int spaceCount = 0;
        for(char s : str.toCharArray()){
            if(s == ' '){
                spaceCount++;
            }
        }
        if(spaceCount == 0){
            return str;
        }
        char[] encodedString = new char[str.length() + (2 * spaceCount)];
        int i = 0;
        for(char s : str.toCharArray()){
            if(s != ' '){
                encodedString[i++] = s;
            }
            else {
                encodedString[i++] = '%';
                encodedString[i++] = '2';
                encodedString[i++] = '0';
            }
        }
        return new String(encodedString);
    }
}
