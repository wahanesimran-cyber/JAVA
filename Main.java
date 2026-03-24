import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            RecommendationEngine engine = new RecommendationEngine();

            engine.loadData("data.csv");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter User ID: ");
            String user = sc.nextLine();

            List<String> recs = engine.recommend(user);

            System.out.println("Recommended Items:");
            for (String item : recs) {
                System.out.println(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}