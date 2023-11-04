package genealogy.util;

import genealogy.model.Person;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenealogySorter {

    public static List<Person> sortByName(List<Person> people) {
        Collections.sort(people, Comparator.comparing(Person::getName));
        return people;
    }

    public static List<Person> sortByBirthDate(List<Person> people) {
        Collections.sort(people, Comparator.comparingInt(Person::getBirthYear));
        return people;
    }
}
