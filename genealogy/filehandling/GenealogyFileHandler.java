package genealogy.filehandling;

import genealogy.model.Person;
import java.util.List;

public interface GenealogyFileHandler {
    List<Person> readFromFile(String fileName);

    void writeToFile(String fileName, List<Person> people);
}
