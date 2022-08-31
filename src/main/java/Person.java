import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Person extends Contact {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gender;

    public Person(String number, String name, String surname, LocalDate birthDate, String gender) {
        super(number);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public static boolean isCorrectGender(String gender) {
        boolean f = "M".equals(gender) || "F".equals(gender);
        if (!f) System.out.println("Bad gender!");
        return f;
    }

    public static LocalDate isCorrectBirthDate(String bd) {
        try {
            return LocalDate.parse(bd);
        } catch (Exception e) {
            System.out.println("Bad birth date!");
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String info() {
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birth date: " + (birthDate == null ? "[no data]": birthDate) + "\n" +
                "Gender: " + (gender == null ? "[no data]": gender) + "\n" +
                super.info();
    }

    @Override
    public List<String> getChangeFields() {
        return List.of("name", "surname", "birth", "gender", "number");
    }

    @Override
    public void editField(String field, String value) {
        switch (field) {
            case "name" -> setName(value);
            case "surname" -> setSurname(value);
            case "birth" -> setBirthDate(isCorrectBirthDate(value));
            case "gender" -> setGender(isCorrectGender(value) ? value : null);
            case "number" -> setNumber(isCorrectNumber(value) ? value : null);
        }
        setLastEdit(LocalDateTime.now());
    }

    @Override
    public String searchLine() {
        return name + surname + gender + birthDate + number;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
