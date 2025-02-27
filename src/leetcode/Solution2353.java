package leetcode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 2353. 设计食物评分系统
 */
public class Solution2353 {
    class FoodRatings {
        private Map<String, Pair<Integer, String>> foodMap;
        private Map<String, TreeSet<Pair<Integer, String>>> ratingMap;
        private int n;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            n = foods.length;
            foodMap = new HashMap<>();
            ratingMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];
                foodMap.put(food, new Pair<>(rating, cuisine));
                ratingMap.computeIfAbsent(cuisine, k -> new TreeSet<>((a, b) -> {
                    if (!a.getKey().equals(b.getKey())) {
                        return a.getKey() - b.getKey();
                    }
                    return a.getValue().compareTo(b.getValue());
                })).add(new Pair<>(n - rating, food));
            }
        }

        public void changeRating(String food, int newRating) {
            Pair<Integer, String> pair = foodMap.get(food);
            int oldRating = pair.getKey();
            String cuisine = pair.getValue();
            ratingMap.get(cuisine).remove(new Pair<>(n - oldRating, food));
            ratingMap.get(cuisine).add(new Pair<>(n - newRating, food));
            foodMap.put(food, new Pair<>(newRating, cuisine));
        }

        public String highestRated(String cuisine) {
            return ratingMap.get(cuisine).first().getValue();
        }
    }
}
