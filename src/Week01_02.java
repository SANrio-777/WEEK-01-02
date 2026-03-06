import java.util.HashMap;

public class Week01_02 {

    HashMap<String, Integer> attempts = new HashMap<>();

    public String getMostAttempted() {

        String maxUser = "";
        int max = 0;

        for (String user : attempts.keySet()) {
            if (attempts.get(user) > max) {
                max = attempts.get(user);
                maxUser = user;
            }
        }

        return maxUser;
    }

    public static void main(String[] args) {

        Week01_02 app = new Week01_02();

        app.attempts.put("john", 3);
        app.attempts.put("alex", 5);
        app.attempts.put("sam", 2);

        System.out.println("Most attempted username: " + app.getMostAttempted());
    }
}