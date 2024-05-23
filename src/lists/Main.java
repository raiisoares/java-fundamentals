package lists;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person01 = new Person("Person 01", 20, 1.70, 85.5);
        Person person02 = new Person("Person 02", 30, 1.85, 90d);
        Person person03 = new Person("Person 03", 40, 1.90, 98.7);

        personList.add(person01);
        personList.add(person02);
        personList.add(person03);

        System.out.println(personList.size());
        System.out.println(personList.get(0));

        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }
}