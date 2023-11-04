package genealogy.filehandling;

import genealogy.model.Person;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileGenealogyHandler implements GenealogyFileHandler {

    @Override
    public List<Person> readFromFile(String fileName) {
        List<Person> people = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            people = (List<Person>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return people;
    }

    @Override
    public void writeToFile(String fileName, List<Person> people) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
