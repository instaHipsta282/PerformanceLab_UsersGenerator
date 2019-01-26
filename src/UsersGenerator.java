import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UsersGenerator {
    public static final String userPath = "C:\\Users\\Анна\\Desktop\\Web Tours 1.0\\WebTours\\cgi-bin\\users\\%s";

    public static void main(String[] args) {
        BufferedWriter writer = null;
        String formatUsername = "jojo%d";
        String formatPassword = "bean%d";
        try {
            for (int i = 0; i < 100; i++) {
                String username = String.format(formatUsername, i);
                String password = String.format(formatPassword, i);
                writer = new BufferedWriter(new FileWriter(String.format(userPath, username)));
                writer.write(password + "\r\n" + username);
                writer.flush();
            }
        }
        catch (IOException e) { e.printStackTrace(); }
        finally {
            if (writer != null) {
                try {
                    writer.close();
                }
                catch (IOException ignore) {}
            }
        }
    }
}
