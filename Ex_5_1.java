import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего


public class Ex_5_1 {

    public static void main(String[] args) {
        Map<String, ArrayList<String>> phonebook = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить номер");
            System.out.println("2. Вывести весь справочник");
            int fank = scan.nextInt();
            switch (fank) {
                case 1:
                    Write(phonebook);
                    break;
                case 2:
                    Read(phonebook);
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    return;
            }
        }

    }
    //это метод для записи в телефонную книгу
    public static void Write(Map<String, ArrayList<String>> phonebook) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите фамилию:");
        String lastName = scan.nextLine();
        System.out.println("Введите номер телефона:");
        String phoneNumber = scan.nextLine();
        if (phonebook.containsKey(lastName)) {
            ArrayList<String> temp = phonebook.get(lastName);
            temp.add(phoneNumber);
            phonebook.put(lastName, temp);
        } else {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(phoneNumber);
            phonebook.put(lastName, temp);
        }
    }
    //Метод для чтения из книги
    public static void Read(Map<String, ArrayList<String>> phonebook) {
        for (var items : phonebook.entrySet()) {
            System.out.println(items.getKey() + " " + items.getValue());
        }
    }
}