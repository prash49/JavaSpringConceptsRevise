import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

public class TrickyCodeSnippets {
    private static boolean flag = true;
    static int count = 0;

    public static void main(String[] args) {
        new Thread( () -> {
            while (flag) {}
        } ).start();
        flag= false;


        // why above code never termincate?
        // because we using flag in thread where while running loop jvm optimizes the loop by caching flag
        // fix use volatile

        Integer a = 127, b= 127;
        Integer c = 128,d = 128;
        System.out.println("a == b :"+ (a == b)); // true
        System.out.println("c == d :"+ (c == d)); // false
        //Integer Object caches from -128 to 127

        String string = "Helllo";
        {
            string = null;
        }
        // intializer block runs first hence string = null will be loaded.


        new Thread(
                () -> {
                    while (count < 5){
                        System.out.println(count);
                    }
                }
        ).start();

        new Thread( () -> count++).start();

        // infinite loop due to thread caching
        // if a static method present in A class and b extends it and same method init it still won't override it'll just hides
        // depending on Object Type it'll get called.

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Prashanth");
        treeSet.add("Prash");
        treeSet.add(null); //  it'll throw error because treeset won't allow null values.

        List<String> stringList = List.of("A","B", "C");
        stringList.add("D"); // it'll throw error because List.of creates a immutable list.. so modification is forbidden

        Optional<String> opt = Optional.of(null); //throws error
        Optional<String> opt2 = Optional.ofNullable(null); //it'll accept null value.



    }

}
