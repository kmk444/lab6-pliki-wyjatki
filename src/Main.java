import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Person.fromCsv("family.csv");
        for(Person person : people) System.out.println(person.toString());
    }
}