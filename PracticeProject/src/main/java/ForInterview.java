import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForInterview {
    public static void main(String args[]){

        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4},6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,3},6)));
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

       // System.out.println(s1==s2);
        System.out.println(s2==s3);
        System.out.println(s2.equals(s3));
        StringBuffer stringBuffer = new StringBuffer(s1);
        String s11 = stringBuffer.reverse().toString();
        List<String> list1;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int arrIndex =0;
        for(int i =0; i<nums.length; i++){
            for(int j = 0;j<nums.length-1;j++){
                if( i!=j) {// don't check to itself
                    if (nums[i] + nums[j] == target) {
                        arr[arrIndex] = i;
                        arr[arrIndex + 1] = j;
                        break;
                    }
                }
            }
        }
        Arrays.sort(arr);
     return arr;
    }

}
