import java.util.*;

public class Shell {
    private Map<String, Command> commands;

    public Shell() {
        commands = new HashMap<>();
        commands.put("time", new TimeCommand());
        commands.put("date", new DateCommand());
        commands.put("ls", new LsCommand());
        commands.put("pwd", new PwdCommand());
        commands.put("cd", new CdCommand());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input;
        Command command;

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            } else if (input.equals("exit")) {
                break;
            }

            command = commands.get(input.split(" ")[0]);
            if (command == null) {
                System.out.println("Unknown command: " + input);
            } else {
                command.execute(input.split(" "));
            }
        }
        scanner.close();
    }
}
