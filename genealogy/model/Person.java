package genealogy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private int birthYear;
    private String gender;
    private String occupation;
    private String placeOfBirth;
    private List<Person> children;
    private Person mother;
    private Person father;

    public Person(String name, int birthYear, String gender, String occupation, String placeOfBirth) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.occupation = occupation;
        this.placeOfBirth = placeOfBirth;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void addChild(Person child) {
        children.add(child);
        child.setMother(this);
        child.setFather(this);
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getMother() {
        return mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getFather() {
        return father;
    }
}
