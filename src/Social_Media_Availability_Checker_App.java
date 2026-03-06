import java.util.*;

public class Social_Media_Availability_Checker_App {

    HashMap<String, Integer> users = new HashMap<>();
    HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public void registerUser(String username, int userId) {
        users.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            suggestions.add(username + i);
        }

        suggestions.add(username.replace("_", "."));
        return suggestions;
    }

    public String getMostAttempted() {
        int max = 0;
        String result = "";

        for (String name : attempts.keySet()) {
            if (attempts.get(name) > max) {
                max = attempts.get(name);
                result = name;
            }
        }
        return result;
    }
    public static void main(String[] args) {

        Social_Media_Availability_Checker_App app =
                new Social_Media_Availability_Checker_App();

        app.registerUser("john_doe", 1);

        System.out.println(app.checkAvailability("john_doe"));     // false
        System.out.println(app.checkAvailability("jane_smith"));   // true

        System.out.println(app.suggestAlternatives("john_doe"));

        System.out.println(app.getMostAttempted());
    }
}