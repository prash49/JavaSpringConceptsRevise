package staticmembersInInheritance;

public class Child extends Parent {
    static { System.out.println("Child static block"); }

    static String message = "its Child static variable";
    static  void  getMessage(){
        System.out.println("its Child static method message ");
    }
}
