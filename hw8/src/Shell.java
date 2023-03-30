import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.stream.Collectors;

public class Shell {
    public static void main(String[] args) {
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

            command = getCommand(input);
            if (command == null) {
                System.out.println("Unknown command: " + input);
            } else {
                command.execute();
            }
        }
        scanner.close();
    }

    private static Command getCommand(String input) {
        String[] tokens = input.split(" ");
        switch (tokens[0]) {
            case "time":
                return new TimeCommand();
            case "date":
                return new DateCommand();
            case "ls":
                if (tokens.length > 1) {
                    return new LsCommand(tokens[1]);
                } else {
                    return new LsCommand();
                }
            case "pwd":
                return new PwdCommand();
            case "cd":
                if (tokens.length < 2) {
                    System.out.println("Invalid arguments for cd command.");
                    return null;
                }
                return new CdCommand(tokens[1]);
            default:
                return null;
        }
    }
}

interface Command {
    void execute();
}

class TimeCommand implements Command {
    public void execute() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(formatter.format(now));
    }
}

class DateCommand implements Command {
    public void execute() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println(formatter.format(now));
    }
}

class LsCommand implements Command {
    private boolean columnFormat = false;

    public LsCommand() {
    }

    public LsCommand(String arg) {
        if (arg.equals("-C")) {
            columnFormat = true;
        }
    }

    public void execute() {
        File currentDir = new File(".");
        File[] files = currentDir.listFiles();

        if (columnFormat) {
            // Выводим содержимое в столбик
            Arrays.sort(files);
            String result = Arrays.stream(files)
                    .map(File::getName)
                    .collect(Collectors.joining("\n"));
            System.out.println(result);
        } else {
            // Выводим содержимое в строку
            Arrays.sort(files);
            String result = Arrays.stream(files)
                    .map(File::getName)
                    .collect(Collectors.joining(" "));
            System.out.println(result);
        }
    }
}

class PwdCommand implements Command {
    public void execute() {
        System.out.println(System.getProperty("user.dir"));
    }
}

class CdCommand implements Command {
    private String path;

    public CdCommand(String path) {
        this.path = path;
    }

    public void execute() {
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            System.setProperty("user.dir", dir.getAbsolutePath());
        } else {
            System.out.println("Invalid path: " + path);
        }
    }
}
