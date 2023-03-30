import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeCommand implements Command {
    public void execute(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(formatter.format(now));
    }
}
