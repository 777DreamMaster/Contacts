import java.time.LocalDate;
import java.util.Scanner;

public class ContactFactory {

    private static final Scanner SC = new Scanner(System.in);

    public Contact createContact(String type) {
        Contact contact = null;

        switch (type) {
            case "person" -> contact = createPerson();
            case "organization" -> contact = createOrganization();
            default -> System.out.println("Incorrect type. Try again");
        }
        return contact;
    }

    public Person createPerson() {
        System.out.print("Enter the name: ");
        String name = SC.next();
        System.out.print("Enter the surname: ");
        String surname = SC.next();

        System.out.print("Enter the birth date: ");
        SC.nextLine();
        String bd = SC.nextLine();
        LocalDate birthDate = Person.isCorrectBirthDate(bd);

        System.out.print("Enter the gender (M, F): ");
        String gender = SC.nextLine();
        if (!Person.isCorrectGender(gender)) {
            gender = null;
        }

        System.out.print("Enter the number: ");
        String number = SC.nextLine();
        if (!Contact.isCorrectNumber(number)) {
            number = null;
        }
        return new Person(number, name, surname, birthDate, gender);
    }

    public Organization createOrganization() {
        System.out.print("Enter the organization name: ");
        String name = SC.nextLine();
        System.out.print("Enter the address: ");
        String address = SC.nextLine();
        System.out.print("Enter the number: ");
        String number = SC.nextLine();
        if (!Contact.isCorrectNumber(number)) {
            number = null;
        }
        return new Organization(number, name, address);
    }
}
