package ro.fasttrackit.mvnbase.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class MainStream {
    public static void main(String[] args) {
        streamOnNames();
        streamOnNumber();
    }

    private static void streamOnNames() {
        List<String> names = List.of("Dragos", "Ana", "Maria", "Tudor", "Alin", "Mircea", "Carmen", "Antonia", "Abigail");

        System.out.println(names.stream()
                //filter e un fel de if, daca lungimea e mai mare decat 3, daca incepe cu A
                //la filter trec mai departe doar cele true
                .filter(name -> name.length() > 3)
                .filter(name -> name.startsWith("A"))
                //map transforma, in exemplu de mai jos transforma sirul in sir cu litere mari
                //transforma intr un sir in care apare - inainte de fiecare element
                .map(name -> name.toUpperCase())
                .map(name -> "-" + name)
                //colecteaza tot sirul nou
                .collect(Collectors.toList())
        );
        Set<String> result = names.stream()
                //apelam metode nameIsFemal din obiectl MainStream
                .filter(MainStream::nameIsFemale)
                .map(name -> "*" + name + "*")
                .collect(Collectors.toSet());
        System.out.println(result);

        System.out.println(names.stream()
                //sorteaza in ordine alfabetica
                .sorted()
                .collect(Collectors.toList())
        );

        System.out.println(names.stream()
                //sorteaza invers
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
        );
        System.out.println(names.stream()
                //sorteaza de pe lungime apoi alfabetic
                .sorted(comparingInt(String::length).thenComparing(s -> s))
                .collect(Collectors.toList()));


        System.out.println(names.stream()
                //sortare dupa ultimul element in ordine alfabetica
                .sorted(Comparator.comparing(s -> s.charAt(s.length() - 1)))
                .collect(Collectors.toList()));

    }


    private static void streamOnNumber() {
        List<Integer> nr = List.of(1, 5, 7, 33, 65, 2, 45);

        System.out.println(nr.stream()
                .filter(n -> n.equals(7))
                .sorted()
                .collect(Collectors.toList())

        );
    }

    private static boolean nameIsFemale(final String name) {
        return name.endsWith("a") || name.endsWith("n") || name.endsWith("e");
    }
}
