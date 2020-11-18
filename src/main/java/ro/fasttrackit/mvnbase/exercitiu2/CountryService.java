package ro.fasttrackit.mvnbase.exercitiu2;

import ro.fasttrackit.mvnbase.exercitu.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class CountryService {
    private final List<Country> countries;

    public CountryService(List<Country> countries) {
        this.countries = new ArrayList<>();
    }

    //toate numele de tari
    public List<String> allCountry() {
        return countries.stream()
                .map(Country::getName)
                .collect(Collectors.toList());
    }

    public List<String> capitalCountry(String name) {
        return countries.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .map(Country::getCapital)
                .collect(Collectors.toList());
    }

    public List<Long> populationCountry(String name) {
        return countries.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .map(Country::getPopulation)
                .collect(Collectors.toList());
    }

    public List<String> countriesContinent(String name) {
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(name))
                .map(Country::getName)
                .collect(Collectors.toList());
    }

    public List<List<String>> countryNeighbours(String name) {
        return countries.stream()
                .filter(country -> country.getName().equalsIgnoreCase(name))
                .map(Country::getNeighbours)
                .collect(Collectors.toList());
    }

    public List<String> countriesPopulation() {
        return countries.stream()
                .filter(country -> country.getPopulation() > 100.000)
                .map(Country::getName)
                .collect(Collectors.toList());
    }

    public Map<String, Long> nameToPopulation() {
        return countries.stream()
                .collect(toMap(Country::getName, Country::getPopulation));
    }

    public Map<String, List<String>> continentName() {
        return countries.stream()
                .collect(toMap(Country::getContinent, c -> List.of(c.getName())));
    }
}
