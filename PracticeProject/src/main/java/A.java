import java.util.Arrays;

public class A {
    public static void main(String args[]) {
        int[] arr = new int[20];
        int prev = 0;
        for (int i = 0; i < arr.length; i++) {

            if (i == 0) {
                arr[i] = prev;


            } else if ((prev-i ) >0) {
                prev = arr[i-1];
                arr[i] = prev-1;
            } else if ((i-prev >0)) {
                prev = arr[i-1];
                arr[i] = i+prev;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}