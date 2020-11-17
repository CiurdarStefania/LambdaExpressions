package ro.fasttrackit.mvnbase.lambda;

import java.util.List;
import java.util.function.Function;

public class MyRef {
    public static void main(String[] args) {
        arrayOperation(s -> s.toUpperCase());
        arrayOperation(String::trim);
        arrayOperation(String::toUpperCase);
        arrayOperation(MyRef::myMethod);
//        arrayOperation(MainRef::other); //compilation error
    }

    public static String other(String a, String b) {
        return a + b;
    }

    public static String myMethod(String input) {
        return "my - " + input;
    }

    public static void arrayOperation(Function<String, String> transformer) {
        var names = List.of("Ana", "Andrei", "Mircea", "Dan", "Ioan");
        for (String name : names) {
            System.out.println(transformer.apply(name));
        }
    }
}
