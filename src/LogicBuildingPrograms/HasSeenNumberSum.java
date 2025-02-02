package LogicBuildingPrograms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HasSeenNumberSum {
    public static void main(String[] args) {
        //lets say we have array and its sum has to seen twice ex: target is 60 and num[i] whic sums with that
        //
        //
        int[] nums = {12, 521, 75, 44, 96, 44, 10};
        int target = 60;
        System.out.println("isSumSeen" + isSumSeenTwice(nums, target));
    }

    private static Boolean isSumSeenTwice(int[] nums, int target) {
        Map<Integer,Integer> seen = new HashMap<>();
        for (int num : nums) {
            if (seen.containsKey(target - num)) {
                return true;
            }
            seen.put(num, num);
        }
        return false;
    }
}
