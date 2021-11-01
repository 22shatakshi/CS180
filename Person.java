public class Person implements Identifiable {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        if(name == null) 
            throw new NullPointerException();
        if (age < 0)
            throw new IllegalArgumentException();
        this.name = name;
        this.age = age;
    }

    public Person(Person person) {
        if (person == null) 
            throw new NullPointerException();
        this.name = person.name;
        this.age = person.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Person))
            return false;
        Person person = (Person) object;
        return getAge() == person.getAge() && getName().equals(person.getName());
    }

    public String toString() {
        return "Person<" +
                "name='" + name +
                ", age=" + age +
                ">";
    }
}