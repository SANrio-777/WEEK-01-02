import java.util.*;

public class Week01_02 {

    HashMap<String, Integer> searchFrequency = new HashMap<>();

    public void addQuery(String query) {
        searchFrequency.put(query, searchFrequency.getOrDefault(query, 0) + 1);
    }

    public List<String> getSuggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();

        for (String query : searchFrequency.keySet()) {
            if (query.startsWith(prefix)) {
                suggestions.add(query);
            }
        }

        suggestions.sort((a, b) ->
                searchFrequency.get(b) - searchFrequency.get(a));

        return suggestions.subList(0, Math.min(10, suggestions.size()));
    }

    public static void main(String[] args) {

        Week01_02 auto = new Week01_02();

        auto.addQuery("java tutorial");
        auto.addQuery("javascript guide");
        auto.addQuery("java download");

        System.out.println(auto.getSuggestions("jav"));
    }
}