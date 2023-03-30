public class PwdCommand implements Command {
    public void execute(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
}
