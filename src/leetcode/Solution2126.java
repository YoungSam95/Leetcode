package leetcode;

import java.util.Arrays;

/**
 * 2126. 摧毁小行星
 */
public class Solution2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);   // 按照质量升序排序
        long currentMass = mass;  // 防止整数溢出
        for (int asteroid : asteroids) {
            // 按顺序遍历小行星，尝试摧毁并更新质量或者返回结果
            if (currentMass < asteroid) {
                return false;
            }
            currentMass += asteroid;
        }
        return true;   // 成功摧毁所有小行星
    }
}
