package leetcode;

import java.util.Random;

/**
 * 478. 在圆内随机生成点
 */
public class Solution478 {
    class Solution {
        private double radius;
        private double x_center;
        private double y_center;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
        }

        public double[] randPoint() {
            Random random = new Random();
            while(true) {
                double x = random.nextDouble() * (2 * radius) - radius;
                double y = random.nextDouble() * (2 * radius) - radius;
                if (x * x + y * y <= radius * radius) {
                    return new double[]{x_center + x, y_center + y};
                }
            }
        }
    }
}
