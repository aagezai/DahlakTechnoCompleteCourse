import java.util.*;

public class StackInLinkedIn {
    //If two English words have the same characters and the occurrence number of each character
    // Function to find and print pair
    static Map<Integer, Integer> chkPair(int A[], int size, int x) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < (size - 1); i++) {
            for (int j = (i + 1); j < size; j++) {
                if (A[i] + A[j] == x) {

                     map.put(A[i],A[j]);
                }
            }
        }

        return map;
    }
    static void findTriplets(int[] arr, int n)
    {
        boolean found = false;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                        found = true;
                    }
                }
            }
        }

        // If no triplet with 0 sum found in array
        if (found == false)
            System.out.println(" not exist ");
    }
    // Returns true if arr[]
    // has a subarray with sero sum
    static Boolean subArrayExists(int arr[])
    {
        // Creates an empty hashset hs
        Set<Integer> hs = new HashSet<Integer>();

        // Initialize sum of elements
        int sum = 0;

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            // Add current element to sum
            sum += arr[i];

            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash set
            if (arr[i] == 0
                    || sum == 0
                    || hs.contains(sum))
                return true;

            // Add sum to hash set
            hs.add(sum);
        }

        // We reach here only when there is
        // no subarray with 0 sum
        return false;
    }

    public static void main(String args[]){
       String w1 = "adcbbd";
       String w2 = "acbbd";
       char[] w1char = w1.toCharArray();
       char[] w2char = w2.toCharArray();
        Arrays.sort(w1char);
        Arrays.sort(w2char);

        HashMap<Character,Integer> map = new HashMap<>();

        if(Arrays.equals(w1char,w2char)){
            for (char c: w2char ) {
                if(map.containsKey(Character.valueOf(c))){

                    map.put(Character.valueOf(c),map.get(Character.valueOf(c))+1);
                }
                else {
                    map.put(Character.valueOf(c),1);
                }

            }
            for(Map.Entry<Character,Integer> mapEntry : map.entrySet()){
                System.out.println(mapEntry.getKey()+"   "+ mapEntry.getValue());
            }

        }else {
            System.out.println("They are not equal");
        }
        // array whose sum is to number
        int A[] = {1, 2, 4, 7, 11, 15,8};
        int x = 15;
        int size = A.length;

        Map<Integer,Integer> map1 = StackInLinkedIn.chkPair(A, size, x);
        for(Map.Entry<Integer,Integer> mapEntry : map1.entrySet()){
            System.out.println("Pair with a given sum " + x +
                    " is (" + mapEntry.getKey() + ", " + mapEntry.getValue() + ")");
        }
        // three elements whose sume is 0
        int arr[] = { 0, -1, 2, -3, 1 };
        int n = arr.length;
        findTriplets(arr, n);

        //has a subarray with sero sum
        int arrOf[] = { -3, 2, 3, 1, 6 ,-6};
        if (subArrayExists(arrOf))
            System.out.println(
                    "Found a subarray with 0 sum");
        else
            System.out.println("No Such Sub Array Exists!");
    }





}
