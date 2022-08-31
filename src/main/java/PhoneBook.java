import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class PhoneBook {
    private static final Scanner SC = new Scanner(System.in);
    private List<Contact> contacts;
    private final ContactFactory contactFactory = new ContactFactory();

    public PhoneBook() {
        if (SerializationUtils.isExist()) {
            try {
                contacts = (List<Contact>) SerializationUtils.deserialize();
            } catch (IOException | ClassNotFoundException e) {
                this.contacts = new ArrayList<>();
            }
            return;
        }
        this.contacts = new ArrayList<>();
    }

    public void addContact() {
        System.out.print("Enter the type (person, organization): ");
        String type = SC.nextLine();
        contacts.add(contactFactory.createContact(type));
        save();
    }

    public Contact getContact(int i) {
        return contacts.get(i);
    }

    public void remove(Contact contact) {
        contacts.remove(contact);
        save();
    }

    public void edit(Contact contact) {
        String field = getFieldsName(contact);
        System.out.printf("Enter %s: ", field);
        String value = SC.nextLine();

        contact.editField(field, value);
        contact.info();
        save();
    }

    public int count() {
        return contacts.size();
    }

    public void printList() {
        IntStream.range(0, contacts.size())
                .forEach(i -> System.out.println(i + 1 + ". " + contacts.get(i).toString()));
    }

    public void printList(List<Contact> list) {
        IntStream.range(0, list.size())
                .forEach(i -> System.out.println(i + 1 + ". " + list.get(i).toString()));
    }

    public List<Contact> search() {
        System.out.print("Enter search query: ");
        String query = SC.nextLine();
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        List<Contact> found = new ArrayList<>();
        Matcher matcher;
        for (Contact contact: contacts) {
            matcher = pattern.matcher(contact.searchLine());
            if (matcher.find()) found.add(contact);
        }

        System.out.printf("Found %d result:%n", found.size());
        printList(found);

        return found;
    }

    private String getFieldsName(Contact contact) {
        while (true) {
            System.out.printf("Select a field (%s): ", contact.getChangeFields());

            String field = SC.nextLine().toLowerCase();
            if (contact.getChangeFields().contains(field)) return field;
            System.out.println("Incorrect field. Try again.");
        }
    }

    private void save() {
        if (SerializationUtils.isExist()){
            try {
                SerializationUtils.serialize(contacts);
            } catch (Exception e) {
                System.out.println("Err while saving");
                e.printStackTrace();
            }
        }
        System.out.println("Saved");
    }
}
