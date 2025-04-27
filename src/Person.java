import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate deathDate;

    private SortedSet<Person> children = new TreeSet<>();

    public Person(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public Person(String firstName, String lastName, LocalDate birthDate){ // konstruktor dla jeszcze zyjacych
        this(firstName,lastName,birthDate,null);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public static Person fromCsvLine(String line){
        String tokens[] = line.split(",");

        String nameTokens[] = tokens[0].split(" "); // uwaga trzeba dwa arraye bo imie jest rozdzielone inaczej
        String firstName = nameTokens[0];
        String lastName = nameTokens[1];


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // zmiana patternu daty
        LocalDate birthDate = LocalDate.parse(tokens[1],formatter);
        LocalDate deathDate = LocalDate.parse(tokens[2],formatter);
        return new Person(firstName,lastName,birthDate,deathDate);
    }

    @Override
    public int compareTo(Person o) {
        return this.birthDate.compareTo(o.birthDate);
    }

    public boolean adopt(Person child){
        return children.add(child);
    }


    public Person getYoungestChild(){
        return children.last();
    }

    public List<Person> getChildren(){
        List<Person> list = new ArrayList<>(children);
        Collections.sort(list);
        return list;
    }

    public String name(){
        return this.getFirstName() + " " + this.getLastName();
    }
}