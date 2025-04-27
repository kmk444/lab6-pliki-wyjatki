
public class Main {
    public static void main(String[] args) {
        Person person1 = Person.fromCsvLine("Marek Kowalski,15.05.1899,25.06.1957,,");
        System.out.println(person1.name());
    }
}