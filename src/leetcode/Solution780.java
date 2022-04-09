package leetcode;

/**
 * 780. 到达终点
 */

public class Solution780 {
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx==tx&&sy==ty){return true;}
        if(sx>tx||sy>ty){return false;}
        if(sx==tx){return (ty-sy)%tx==0;}
        if(sy==ty){return (tx-sx)%ty==0;}
        return tx>=ty?reachingPoints(sx,sy,tx%ty,ty):reachingPoints(sx,sy,tx,ty%tx);
    }

    public static void main(String[] args){
        System.out.println(reachingPoints(35,13,455955547,420098884));
    }
}
