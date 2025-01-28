package ImmutableClass;

import java.util.*;

public final class Employee {
    private final String name;
    private final Date doj;
    private final List<String> mobile;
// what if i address object is there
    // add that into address

    public Employee(String name, Date doj, List<String> mobile) {
        this.name = name;
        this.doj = doj;
        this.mobile = mobile;
    }
// string is immutable even if we set from get()it wont impact
    public String getName() {
        return name;
    }
// date is mutable object we can set the value by using .getDoj().set
    // to elimate that we have to retrun the clone of the date instead of returning the actual
    public Date getDoj() {
        return (Date) doj.clone();
    }
//list is also mutable hence instead of giving the actual create a new copy of it and give
    public List<String> getMobile() {
        return new ArrayList<>(mobile);
    }
    // address is mutable hence need to provide the copy of the address.
 /*   public Address getAddress(){
        return new Adress(address.getCity,address.getPincode)
    }*/

    public static void main(String[] args) {
        Employee employee = new Employee("Prashanth", new Date(), Arrays.asList("8310133663", "9731840771"));
        System.out.println( employee.getName());
        System.out.println( employee.getMobile().add("0000000"));

        Set<String> set = new HashSet<>();
        set.add("200");
    }
}
