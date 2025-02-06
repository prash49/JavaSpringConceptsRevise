/*
package java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMap {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("1", "Prashanth");
        map.put("2", "Navin");
        map.put("2", "Praveen");

        // sorting based on based on value and collecting
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new))

Map idNameMap = new HashMap();
        idNameMap.put(111, "Lisa");
        idNameMap.put(222, "Narayan");
        idNameMap.put(333, "Xiangh");
        idNameMap.put(444, "Arunkumar");
        idNameMap.put(555, "Jyous");
        idNameMap.put(666, "Klusener");

        //Java 8 sorting using Entry.comparingByValue()

        Map<Integer, String> sortedIdNameMap
                = idNameMap.entrySet()
                .stream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }
}
*/
