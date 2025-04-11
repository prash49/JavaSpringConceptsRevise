package HashMap;

import java.util.Objects;

class Person {
    int id;
    String name;
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return  true;
        if ( !(obj instanceof Person)) return false;
        Person p = (Person) obj;
        return id == p.id && Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name);
    }
}