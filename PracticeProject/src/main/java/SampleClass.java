import netscape.javascript.JSObject;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class SampleClass {
    public static void main(String args[]){

        List<String> list = Arrays.asList("3", "6", "8", "14", "15", "8");
        TreeSet<String> aSet = new TreeSet<>(list);

        aSet.stream().forEach(el -> System.out.println(el));
        System.out.println("==================");
        Integer x = Integer.valueOf("3") ;
       List<Integer > aList = list.stream().map(e -> Integer.valueOf(e)).
               filter(elem -> (elem %3)==0).collect(Collectors.toList());
       aList.forEach(el -> System.out.println(el));
        //http://localhost:8080/greeting?name=John
        //http://localhost:8080/greeting/123




    }

}
