package staticmembersInInheritance;

public class Parent {
    static String message = "Parent static variable";
    static { System.out.println("Parent's static block"); }

    static void getMessage() {
        System.out.println("its parent message");
    }

}
