package javastudymiddle;

import java.util.Objects;

public class Person {
    String name;
    int age;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }
    public void eat(){
        System.out.println("吃饭");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

}
