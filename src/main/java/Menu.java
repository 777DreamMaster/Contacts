import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Scanner SC = new Scanner(System.in);
    private static PhoneBook phoneBook;

    public static void start(String[] args) {
        if (args.length != 0) {
            SerializationUtils.createFile(args[0]);
        }
        phoneBook = new PhoneBook();
        menuOptions();
    }

    private static void menuOptions() {
        boolean isWorking = true;
        while (isWorking) {
            System.out.print("\n[menu] Enter action (add, list, search, count, exit): ");

            switch (SC.next()) {
                case "add":
                    phoneBook.addContact();
                    break;
                case "list":
                    phoneBook.printList();
                    listMenu();
                    break;
                case "search":
                    searchMenu();
                case "count":
                    printCount();
                    break;
                case "exit":
                    isWorking = false;
                    break;
                default:
                    System.out.println("Incorrect option. Try again!");
            }
        }
    }

    private static void searchMenu() {
        boolean isWorking = true;
        List<Contact> foundList = phoneBook.search();

        while (isWorking) {
            System.out.print("\n[search] Enter action ([number], back, again): ");
            String op = SC.next();
            switch (op) {
                case "again":
                    foundList = phoneBook.search();
                    break;
                case "back":
                    isWorking = false;
                    break;
                default:
                    try {
                        int num = Integer.parseInt(op);
                        if (num <= 0 || num > foundList.size()) throw new RuntimeException();
                        Contact contact = foundList.get(num - 1);
                        System.out.println(contact.info());
                        recordMenu(contact);
                        isWorking = false;
                    } catch (Exception e) {
                        System.out.println("Incorrect op. Try again!");
                    }
                    break;
            }
        }
    }

    private static void listMenu() {
        boolean isWorking = true;
        while (isWorking) {
            System.out.print("\n[list] Enter action ([number], back): ");
            String op = SC.next();
            if ("back".equals(op)) {
                isWorking = false;
            } else {
                try {
                    int num = Integer.parseInt(op);
                    if (num <= 0 || num > phoneBook.count()) throw new RuntimeException();
                    Contact contact = phoneBook.getContact(num - 1);
                    System.out.println(contact.info());
                    recordMenu(contact);
                    isWorking = false;
                } catch (Exception e) {
                    System.out.println("Incorrect op. Try again!");
                }
            }
        }
    }

    private static void recordMenu(Contact contact) {
        boolean isWorking = true;
        while (isWorking) {
            System.out.print("\n[record] Enter action (edit, delete, menu): ");

            switch (SC.next()) {
                case "edit" -> phoneBook.edit(contact);
                case "delete" -> phoneBook.remove(contact);
                case "menu" -> isWorking = false;
                default -> System.out.println("Incorrect option. Try again!");
            }
        }
    }

    private static void printCount() {
        System.out.printf("The Phone Book has %d records.%n%n", phoneBook.count());
    }
}
