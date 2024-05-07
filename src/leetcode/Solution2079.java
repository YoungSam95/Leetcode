package leetcode;

/**
 * 2079. 给植物浇水
 */
public class Solution2079 {
    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int ans = 0;
        int rest = capacity;
        for (int i = 0; i < n; ++i) {
            if (rest >= plants[i]) {
                ++ans;
                rest -= plants[i];
            } else {
                ans += i * 2 + 1;
                rest = capacity - plants[i];
            }
        }
        return ans;
    }
}
