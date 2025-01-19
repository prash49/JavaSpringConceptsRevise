package Genirics;

public class GenericVsLegacy {
    public static void main(String[] args) {
        LegacyBox integerBox = new LegacyBox();
        integerBox.setObject(1);

        // while fetching value i always need to cast the objecy
        int value = (int) integerBox.getObject();
        System.out.println("value in LegacyBox" + value);

        // so if we make use of Generics (T)
        // we will define the type of Object we going to store hence it wont error while Get
        GenericBox<String> genericBox = new GenericBox();
        genericBox.setItem("Prashanth");
        String name = genericBox.getItem();
        System.out.println("name:" + name);

        GenericBox<Integer> integerGenericBox = new GenericBox<>();
        integerGenericBox.setItem(100);
        int rolNum = integerGenericBox.getItem();



    }
}
