package leetcode;

/**
 * 812. 最大三角形面积
 * 第二次
 */
public class Solution812 {
    public static double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        for(int i = 0; i < points.length - 2; i++){
            for(int j = i + 1; j < points.length - 1; j++){
                for(int k = j + 1; k < points.length; k++){
                    double temp = points[i][0]*(points[j][1]-points[k][1]) +
                                  points[j][0]*(points[k][1]-points[i][1]) +
                                  points[k][0]*(points[i][1]-points[j][1]);
                    double Area = Math.abs(temp / 2);
                    maxArea = Math.max(maxArea,Area);
                }
            }
        }
        return maxArea;
    }
    public static void main(String[] args){
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(largestTriangleArea(points));
    }
}
