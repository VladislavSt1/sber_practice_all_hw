import java.io.*;

public class CdCommand implements Command {
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Invalid arguments for cd command.");
            return;
        }

        File dir = new File(args[1]);
        if (dir.exists() && dir.isDirectory()) {
            System.setProperty("user.dir", dir.getAbsolutePath());
        } else {
            System.out.println("Invalid path: " + args[1]);
        }
    }
}