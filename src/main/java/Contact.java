import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Contact implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    protected String number;
    protected LocalDateTime created;
    protected LocalDateTime lastEdit;

    protected Contact(String number) {
        this.number = number;
        this.created = LocalDateTime.now();
        this.lastEdit = LocalDateTime.now();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean hasNumber() {
        return number != null;
    }

    public String info() {
        return "Number: " + number + "\n" +
                "Time created: " + created + "\n" +
                "Time last edit: " + lastEdit;
    }

    public abstract List<String> getChangeFields();
    public abstract void editField(String field, String value);

    public abstract String searchLine();

    public void setLastEdit(LocalDateTime lastEdit) {
        this.lastEdit = lastEdit;
    }

    public static boolean isCorrectNumber(String number) {
        Pattern pattern = Pattern.compile("\\+?(\\(\\w+\\)|\\w+[ -](\\(\\w{2,}\\))|\\w+)([ -]\\w{2,})*");
        Matcher matcher = pattern.matcher(number);
        boolean f = matcher.matches();
        if (!f) System.out.println("Wrong number format!");
        return f;
    }

    @Override
    public String toString() {
        return hasNumber() ? number : "[no number]";
    }
}