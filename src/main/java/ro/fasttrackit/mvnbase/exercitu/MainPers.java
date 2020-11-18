package ro.fasttrackit.mvnbase.exercitu;

import java.util.List;

public class MainPers {
    public static void main(String[] args) {
        List<Person> person = List.of(new Person("Popescu", "Ana ", 20, "Oradea"),
                new Person("Dumitrescu", "Maria", 37, "Brasov"),
                new Person("Grigorescu", "Matei", 29, "Constanta"),
                new Person("Cimpineanu", "Andre", 54, "Bucuresti"),
                new Person("Badea", "Mihai", 16, "Cluj"),
                new Person("Bogdan", "Alexandru", 7, "Timisoara")
        );
       PersonService personService = new PersonService(List.of(new Person("Popescu", "Ana ", 20, "Oradea"),
               new Person("Dumitrescu", "Maria", 37, "Brasov"),
               new Person("Grigorescu", "Matei", 29, "Constanta"),
               new Person("Cimpineanu", "Andre", 54, "Bucuresti"),
               new Person("Badea", "Mihai", 16, "Cluj"),
               new Person("Bogdan", "Alexandru", 7, "Timisoara")));

    }
}
