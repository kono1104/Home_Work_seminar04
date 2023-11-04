package genealogy;

import genealogy.filehandling.FileGenealogyHandler;
import genealogy.filehandling.GenealogyFileHandler;
import genealogy.model.Person;

public class Main {
    public static void main(String[] args) {
        // Создаем объекты для работы с файлами и генеалогическим древом
        GenealogyFileHandler fileHandler = new FileGenealogyHandler();
        GenealogyTree tree = new GenealogyTree(fileHandler);

        // Создаем персоны
        Person person1 = new Person("Иван", 1950, "М", "Инженер", "Москва");
        Person person2 = new Person("Мария", 1955, "Ж", "Учитель", "Санкт-Петербург");
        Person person3 = new Person("Алексей", 1980, "М", "Врач", "Москва");
        Person person4 = new Person("Елена", 1985, "Ж", "Художник", "Санкт-Петербург");

        // Устанавливаем родственные связи
        person1.addChild(person3); // Алексей - сын Ивана
        person1.addChild(person4); // Елена - дочь Ивана
        person2.addChild(person3); // Алексей - сын Марии
        person2.addChild(person4); // Елена - дочь Марии

        // Добавляем персоны в генеалогическое древо
        tree.addPerson(person1);
        tree.addPerson(person2);
        tree.addPerson(person3);
        tree.addPerson(person4);

        // Выводим информацию о всех персонах в древе
        tree.printAllPeopleInfo();

        // Сохраняем данные в файл
        tree.saveToFile();
    }
}