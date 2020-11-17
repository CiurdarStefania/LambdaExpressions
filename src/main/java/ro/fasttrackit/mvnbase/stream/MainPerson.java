package ro.fasttrackit.mvnbase.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainPerson {
    public static void main(String[] args) {
        List<Person> person = List.of(new Person("Ana", 33),
                new Person("Mircea", 52),
                new Person("Rafael", 43),
                new Person("Dragos", 21),
                new Person("Ecaterina", 65),
                new Person("Serban", 63),
                new Person("Albert", 13),
                new Person("Bogdan", 39)
        );
        System.out.println(person.stream()
                .filter(person1 -> person1.getAge() > 25)
                .filter(person1 -> person1.getName().toLowerCase().contains("r"))
                .map(person1 -> new Person("*" + person1.getName(), person1.getAge()))
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList())
        );
        System.out.println(person);
    }

}
