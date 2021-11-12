package Lab11and12.Task1;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Shcheglov");
        System.out.println(person.getFIO());
        Person person2 = new Person("Shcheglov", "Mikhail", "Vital'evich");
        System.out.println(person2.getFIO());
    }
}
