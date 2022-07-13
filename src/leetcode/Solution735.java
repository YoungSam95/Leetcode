package leetcode;

import java.util.Arrays;

/**
 * 735. 行星碰撞
 */
public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        int p=1;
        for(int i=1;i<asteroids.length;i++){
            int a=asteroids[i];
            if(a>0){
                //当前陨石是右，那么可以直接放：
                asteroids[p]=a;
                p++;
            }
            else{
                //当前陨石是左，那么先向左消除所有向右比自己小的陨石
                while(p>0&&asteroids[p-1]>0&&asteroids[p-1]<-a){p--;}
                //假如到头了或者左边的也是向左的，可以放下
                if(p==0||asteroids[p-1]<0){
                    asteroids[p]=a;
                    p++;
                }
                //假如陨石质量相同且方向相反；则都爆炸
                else if(a+asteroids[p-1]==0){p--;}
            }
        }
        return Arrays.copyOfRange(asteroids,0,p);
    }
}
