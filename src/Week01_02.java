import java.util.HashMap;

public class Week01_02 {

    HashMap<String, Integer> attempts = new HashMap<>();

    public void trackAttempt(String username) {

        if (attempts.containsKey(username)) {
            attempts.put(username, attempts.get(username) + 1);
        } else {
            attempts.put(username, 1);
        }

        System.out.println(username + " attempts: " + attempts.get(username));
    }

    public static void main(String[] args) {

        Week01_02 app = new Week01_02();

        app.trackAttempt("john");
        app.trackAttempt("john");
    }
}