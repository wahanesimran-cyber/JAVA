import java.io.*;
import java.util.*;

class RecommendationEngine {

    // ✅ Declare data globally
    Map<String, Map<String, Integer>> data = new HashMap<>();

    // ✅ Correct method with return type
    public void loadData(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        br.readLine(); // skip header

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");

            String user = parts[0];
            String item = parts[1];
            int rating = Integer.parseInt(parts[2]);

            data.putIfAbsent(user, new HashMap<>());
            data.get(user).put(item, rating);
        }
        br.close();
    }

    // ✅ Recommendation method
    public List<String> recommend(String user) {
        Map<String, Integer> userRatings = data.get(user);

        Map<String, Integer> scores = new HashMap<>();

        for (String otherUser : data.keySet()) {
            if (otherUser.equals(user)) continue;

            for (String item : data.get(otherUser).keySet()) {

                if (userRatings == null || !userRatings.containsKey(item)) {
                    scores.put(item, scores.getOrDefault(item, 0) + data.get(otherUser).get(item));
                }
            }
        }

        List<String> recommendations = new ArrayList<>(scores.keySet());

        recommendations.sort((a, b) -> scores.get(b) - scores.get(a));

        return recommendations;
    }
}