package ro.fasttrackit.mvnbase.exercitu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonService {
    private final List<Person> person;

    public PersonService(List<Person> person) {
        this.person = new ArrayList<>();
    }
    public List<Person> sortedFirstNameAndAge(){
        return person.stream()
                .sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge))
                .collect(Collectors.toList());
    }
    public List<Person> sortedLastName(){
        return person.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());
    }

    public List<Person> sortedFirstName(){
        return person.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
    }
//
//    public Set<Person> namesUniqueli(){
//        return person.stream()
//                .map(n->n.getFirstName())
//                .collect(Collectors.toList());
//
//    }
    public List<Person> nameStartingA(){
        return person.stream()
                .filter(n->n.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
    }
    public List<Person> age(){
        return  person.stream()
                .filter(n-> n.getAge() >18 && n.getAge()< 60)
                .collect(Collectors.toList());
    }

    public List<String> letterFirst() {
        return person.stream()
                .map(this::firstLetterSAndLastName)
                .collect(Collectors.toList());
    }

    public List<String> firstNameCapitalized() {
        return person.stream()
                .map(p -> p.getFirstName().toUpperCase())
                .collect(Collectors.toList());
    }

    public List<Person> fromOrdORCj() {
        return person.stream()
                .filter(p -> fromIs((Person) person, "Oradea") || fromIs((Person) person, "Cluj"))
                .collect(Collectors.toList());
    }

    public List<Person> fromIsOradea() {
        return person.stream()
                .filter(n -> n.getCity().equals("Oradea"))
                .collect(Collectors.toList());
    }

    public List<Person> personsMajor() {
        return person.stream()
                .filter(n -> n.getAge() > 18)
                .collect(Collectors.toList());
    }

    public List<String> firstNameAndLastName() {
        return person.stream()
                .map(this::firstAndLast)
                .collect(Collectors.toList());
    }

    private String firstAndLast(Person person) {
        return person.getFirstName() + " " + person.getLastName();
    }

    private boolean fromIs(Person person, String city) {
        return person.getCity().equalsIgnoreCase(city);
    }

    private String firstLetterSAndLastName(Person person) {
        return person.getFirstName() + " " + person.getLastName().charAt(0) + ".";
    }




}
