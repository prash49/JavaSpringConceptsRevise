package HashMap;

import java.util.HashMap;
import java.util.Map;

public class PersonAsKeyInHashMap {
    public static void main(String[] args) {
        Map<Person,String> map = new HashMap<>();
        map.put(new Person(1, "Prashanth"), "softWare development engineer");
        System.out.println(map.size());
        map.put(new Person(1, "Prashanth"), "member of techinical team");
        System.out.println("we have added name and id to be equals so size after new "+ map.size());
    }
}
