import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Practice implements Comparable{
       private  int age;
       private String name ;


    public Practice(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Practice{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Practice)) return false;
        Practice practice = (Practice) o;
        return getAge() == practice.getAge() && getName().equals(practice.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName());
    }
    public static void main(String args[]){
        Practice obj1 = new Practice(12,"nebiat");
        Practice obj2 = new Practice(11,"aaron");
        boolean isEqual = obj1.equals(obj2);
        System.out.println("is obj1 and obj2 are equal " + isEqual);
        // sort
        Practice practice[] = {obj1,obj2};
        List<Practice> practiceList = Arrays.asList(practice);
        Collections.sort(practiceList,(a,b) -> a.compareTo(b));
        System.out.println(practiceList);


    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Practice)
        {
            Practice s = (Practice) o;
            return (this.name.compareTo(s.name) );
        }
        else
            return -1;
    }
}