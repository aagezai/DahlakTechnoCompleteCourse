import javax.xml.transform.stream.StreamSource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
       /* Given a string s, return the longest palindromic substring in s.
                Example 1:

        Input: s = "babadmadam"
        Output: "madam"
        as "madam" is having 5 characters. ababdbbbbababmbd
               */
        String s = "babadmadam";
        String longSubString="";
        StringBuffer subString = new StringBuffer();
        int max =0;
        for(int i =0 ; i<s.length(); i++){
            for(int j=i+1;j<s.length()-1;j++){
                subString.append(s.charAt(i)).append(s.charAt(j));
               if(isPalindram(subString)) {
                   if(subString.length()>max){

                       max =subString.length();
                       longSubString = subString.toString();
                   }
               }
            }
        }
        System.out.println("++++" + longSubString);


    }

    private static boolean isPalindram(StringBuffer subString) {
        System.out.println(subString.toString()+" "+subString.reverse().toString()+"  "+ subString.equals(subString.reverse())) ;
       return subString.equals(subString.reverse());

    }
}
