package LogicBuildingPrograms;

public class LongestPrefixInArray {

    // String[] str = [ "Prashanth", "Pravin", "Pranav"] -- the common prefix is Pra need to find that
    // consider prefix = str.getIndex(0)
    // then loop through the array for length - 1 number of time
    // in each loop i need to find the whats the common prefix between the prefix we have and another string
    // ex: 1st iteration prefix = Prashantn , but it'll loop hence next str[i] is Pravin
    // do a while and check str[i].indexof(prefix) != o means it'll check the Pravin Prashanth is letters are matching in index's are not equals to 0
    // i need to loop the while untill i find the Prefix that not present in Pravin
    // then for loop increases

    public static void main(String[] args) {
        String[] str = {"Prashanth", "Praveen", "Pranav"};
        String[] str2 = {"abcd", "def", "ijkl"};
        System.out.println("prefix :" + findLongestPrefix(str));
        System.out.println("prefix2 :" + findLongestPrefix(str2));
    }

    static String findLongestPrefix(String[] array) {
        if (array.length == 0 || array == null) {
            return "";
        }
        String prefix = array[0];
        for (int i = 1; i < array.length; i++) {

            while (array[i].indexOf(prefix) != 0) {
// keep on removing one one char from prefix
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }


    static String findLongestPrefixInArray(String[] str) {
        if (str != null && str.length == 0) {
            return "";
        }
        String prefix = str[0];
        for (int i = 1; i < str.length; i++) {
            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
            return prefix;
        }

        return "";
    }


}
