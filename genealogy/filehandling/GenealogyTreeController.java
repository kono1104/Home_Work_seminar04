package genealogy.filehandling;

import java.io.*;
import java.util.List;

public class FileGenealogyHandler implements GenealogyFileHandler<Person> {

    @Override
    public List<genealogy.model.Person> readFromFile(String fileName) {
        List<Person> people = null;
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

    @Override
    public void writeToFile(String fileName, List<genealogy.model.Person> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeToFile'");
    }
}

package genealogy.filehandling;

import java.io.Serializable;
import java.util.ArrayList;
import genealogy.filehandling.FileGenealogyHandler;
import genealogy.filehandling.GenealogyFileHandler;
import java.util.Iterator;
import genealogy.filehandling.FileGenealogyHandler;
import genealogy.filehandling.GenealogyFileHandler;
import java.util.Scanner;

public class GenealogyTreeController {
    private GenealogyTree<Person> genealogyTree;

    public GenealogyTreeController(GenealogyTree<Person> genealogyTree) {
        this.genealogyTree = genealogyTree;
    }

    public void startInteractiveSession() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Введите команду (add, search, print, exit):");
            String command = scanner.nextLine();
            switch (command.toLowerCase()) {
                case "add":
                    // Логика добавления новой сущности
                    break;
                case "search":
                    // Логика поиска сущности
                    break;
                case "print":
                    // Логика вывода информации о сущностях
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        GenealogyFileHandler<Person> fileHandler = new FileGenealogyHandler<>();
        GenealogyTree<Person> genealogyTree = new GenealogyTree<>();
        GenealogyTreeController controller = new GenealogyTreeController(genealogyTree);
        controller.startInteractiveSession();
    }
}