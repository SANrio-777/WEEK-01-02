import java.util.*;

public class Week01_02 {

    public List<int[]> findTwoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                result.add(new int[]{map.get(complement), i});
            }

            map.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {

        Week01_02 detector = new Week01_02();

        int[] transactions = {500, 300, 200};

        List<int[]> pairs = detector.findTwoSum(transactions, 500);

        for (int[] p : pairs) {
            System.out.println("Pair: " + p[0] + " " + p[1]);
        }
    }
}