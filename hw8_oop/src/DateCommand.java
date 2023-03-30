import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateCommand implements Command {
    public void execute(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println(formatter.format(now));
    }
}
