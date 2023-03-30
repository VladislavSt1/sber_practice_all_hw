import java.io.*;
import java.util.stream.Collectors;

public class LsCommand implements Command {
    public void execute(String[] args) {
        boolean columnFormat = false;
        if (args.length > 1 && args[1].equals("-C")) {
            columnFormat = true;
        }

        File currentDir = new File(".");
        File[] files = currentDir.listFiles();

        if (columnFormat) {
            // Выводим содержимое в столбик
            java.util.Arrays.sort(files);
            String result = java.util.Arrays.stream(files)
                    .map(File::getName)
                    .collect(Collectors.joining("\n"));
            System.out.println(result);
        } else {
            // Выводим содержимое в строку
            java.util.Arrays.sort(files);
            String result = java.util.Arrays.stream(files)
                    .map(File::getName)
                    .collect(Collectors.joining(" "));
            System.out.println(result);
        }
    }
}
