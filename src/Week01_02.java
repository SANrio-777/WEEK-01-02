import java.util.HashMap;

public class Week01_02 {

    HashMap<String, Integer> usernames = new HashMap<>();

    public void suggestAlternatives(String username) {
        System.out.println("Username not available. Suggestions:");
        System.out.println(username + "123");
        System.out.println(username + "_01");
        System.out.println(username + "_official");
    }

    public static void main(String[] args) {

        Week01_02 app = new Week01_02();

        app.suggestAlternatives("john");
    }
}