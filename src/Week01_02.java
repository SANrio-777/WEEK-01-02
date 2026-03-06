import java.util.HashMap;

public class Week01_02 {

    HashMap<String, Integer> usernames = new HashMap<>();

    public void registerUser(String username) {
        usernames.put(username, 1);
        System.out.println(username + " registered successfully");
    }

    public static void main(String[] args) {

        Week01_02 app = new Week01_02();

        app.registerUser("john");
    }
}