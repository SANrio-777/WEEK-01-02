import java.util.*;

public class Week01_02 {

    LinkedHashMap<String, String> L1 =
            new LinkedHashMap<>(10000, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > 10000;
                }
            };

    HashMap<String, String> L2 = new HashMap<>();

    public String getVideo(String videoId) {

        if (L1.containsKey(videoId)) {
            System.out.println("L1 HIT");
            return L1.get(videoId);
        }

        if (L2.containsKey(videoId)) {
            System.out.println("L2 HIT → Promoted to L1");
            String data = L2.get(videoId);
            L1.put(videoId, data);
            return data;
        }

        System.out.println("Database HIT → Added to L2");
        String data = "VideoData_" + videoId;
        L2.put(videoId, data);

        return data;
    }

    public static void main(String[] args) {

        Week01_02 cache = new Week01_02();

        cache.getVideo("video123");
        cache.getVideo("video123");
    }
}