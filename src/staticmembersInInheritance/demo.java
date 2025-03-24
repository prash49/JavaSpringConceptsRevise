package staticmembersInInheritance;

public class demo {
    public static void main(String[] args) {
        System.out.println("Parent :"+ Parent.message);
        System.out.println("Child :"+ Child.message);

        Parent parent = new Child();
        Child.getMessage();
    }
}
