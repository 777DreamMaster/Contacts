import java.time.LocalDateTime;
import java.util.List;

public class Organization extends Contact {
    private String name;
    private String address;

    public Organization(String number, String name, String address) {
        super(number);
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String info() {
        return "Organization name: " + name + "\n" +
                "Address: " + address + "\n" +
                super.info();
    }

    @Override
    public List<String> getChangeFields() {
        return List.of("name", "address", "number");
    }

    @Override
    public void editField(String field, String value) {
        switch (field) {
            case "address" -> setAddress(value);
            case "number" -> setNumber(isCorrectNumber(value) ? value : null);
        }
        setLastEdit(LocalDateTime.now());
    }

    @Override
    public String searchLine() {
        return name + address + number;
    }

    @Override
    public String toString() {
        return name;
    }
}
