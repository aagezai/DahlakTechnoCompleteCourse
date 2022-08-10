import java.util.*;

public class A {
    public static void main(String args[]) {
        Integer arr[] = {10,20,30,40,10,20};
        List<Integer> list = Arrays.asList(arr);
        Set<Integer> hashSet = new HashSet<>();
        list.stream().filter(el -> !hashSet.add(el)).forEach(System.out::println);
        String givenString = "welcome to java and java welcome";
        String[] strArr = givenString.split(" ");
       // Arrays.stream(strArr).forEach(System.out::print);
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(2,"two");
        hashMap.put(1,"one");
        hashMap.put(3,"three");

        hashMap.entrySet().stream().sorted(Comparator.comparing(el->el.getKey())).forEach(System.out::println);



    }



}