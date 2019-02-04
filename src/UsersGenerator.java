import java.io.*;

public class UsersGenerator {

    public static void main(String[] args) {
        BufferedWriter writer = null;
        BufferedWriter writer1 = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String formatUsername = "jojo%d";
        String formatPassword = "bean%d";
        System.out.println("Please enter the path to the users folder");

        try {
            String usersPath = reader.readLine();
            writer1 = new BufferedWriter(new FileWriter(usersPath + "\\parametersFile.dat"));
            writer1.write("username password\r\n");
            writer1.flush();
            for (int i = 0; i < 100; i++) {
                String username = String.format(formatUsername, i);
                String password = String.format(formatPassword, i);
                writer = new BufferedWriter(new FileWriter(usersPath + "\\" + username));
                writer.write(password + "\r\n" + username + ";");
                writer.flush();
                writer1.write(username + " " + password + "\r\n");
                writer1.flush();
            }
        }
        catch (IOException e) { e.printStackTrace(); }
        finally {
            if (writer != null) {
                try {
                    writer.close();
                    writer1.close();
                    reader.close();
                }
                catch (IOException ignore) {}
            }
        }
    }
}
