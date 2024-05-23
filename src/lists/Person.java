package lists;

public class Person {
    private final String name;
    private int age;
    private Double height;
    private Double weight;

    public Person(String name, int age, Double height, Double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
