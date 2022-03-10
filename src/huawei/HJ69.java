package huawei;

import java.util.Scanner;

public class HJ69 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int[][] matrix1 = new int[x][y];
        int[][] matrix2 = new int[y][z];
        int[][] res = new int[x][z];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                matrix1[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < y; i++){
            for(int j = 0; j < z; j++){
                matrix2[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < x; i++){
            for(int j = 0; j < z; j++){
                for(int k = 0; k < y; k++){
                    res[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        for(int i = 0; i < x; i++){
            for(int j = 0; j < z; j++){
                System.out.print(res[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
