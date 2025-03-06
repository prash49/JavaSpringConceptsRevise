package methodHiding;

public class Demo {
    public static void main(String[] args) {
        ParentClass.print();
        ChildClass.print();
        // creating parent class with child reference
        ParentClass reference = new ChildClass();
        reference.print();
        // above code calls parents print() because of method hiding for static blocks
        //this can't be done u can create a refernce of child class with parent class but u can do reverse like above
//        ChildClass ref = new  ParentClass();

//        Method Hiding: When a subclass defines a static method with the
//        same signature as a static method in the parent class, it does not override the method but rather hides it.

//

    }
}
