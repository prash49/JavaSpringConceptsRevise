package LogicBuildingPrograms;

public class ReverseAString {
    public static void main(String[] args) {
        System.out.println("reversedString "+ reverseAString());
        System.out.println("revString "+ revString("Prash"));
    }
    static String reverseAString(){
        String name = "Prashanth";
        char[] arr = name.toCharArray();
        int left = 0,right = arr.length - 1;
        while (left < right){

         swap(arr, left,right);
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void swap(char[] arr, int left, int right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        System.out.println("left in swap :"+ arr[left]);
        System.out.println("right in swap :"+ arr[right]);
    }

    public static String revString(String name){
        char[] charArray = name.toCharArray();
        for (int i = 0, j = charArray.length - 1; i < j; i ++ , j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return new String(charArray);
    }


}
