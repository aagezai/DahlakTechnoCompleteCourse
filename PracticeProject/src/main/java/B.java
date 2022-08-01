import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B extends A{

    public static void main(String args[]){
       Integer arr[] = new Integer[] {1,2,3,4,5,6};// ->[4,3,2,1,5,6]
        Integer [] reversedArr = reverse(arr,4);
        System.out.println(Arrays.deepToString(reversedArr));
        System.out.println(reverseString("abcd"));


    }
    public static Integer[] reverse(Integer arr[], int target){
        List<Integer> list1= Arrays.stream(arr).skip(target).collect(Collectors.toList());
        List<Integer> list= Arrays.stream(arr).limit(target).
         sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        list.addAll(list1);
        return list.toArray(Integer[]::new);
    }
    public static String reverseString(String str){
        String reverseStr = "";
        for (int i=str.length()-1; i>= 0;i--){
            reverseStr+=str.charAt(i);
        }
        return reverseStr;
    }

}
