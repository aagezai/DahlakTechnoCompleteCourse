import java.util.Arrays;

public class CoreJavaSample {
    public static  void main(String agrs[]){

        String original = "rA89293cEC@Ar";
        original = original.replaceAll("[^a-zA-Z]","").toLowerCase();
        String originalReverse = new StringBuilder(original).reverse().toString();

        System.out.println(original.equals(originalReverse));

    }
}
