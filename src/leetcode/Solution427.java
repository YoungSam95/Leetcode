package leetcode;

/**
 * 427.建立四叉树
 */

public class Solution427 {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
    public Node construct(int[][] grid) {
        return build(grid,0,0,grid.length,grid.length);
    }

    public Node build(int[][] grid, int r0, int c0, int r1, int c1) {
        /**判断当前矩阵是否各个位置值相同**/
        boolean same = true;
        for (int i = r0; i < r1; ++i) {
            for (int j = c0; j < c1; ++j) {
                if (grid[i][j] != grid[r0][c0]) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                break;
            }
        }
        /**如果相同，构造并返回叶子节点**/
        if(same){
            return new Node(grid[r0][c0] == 1,true);
        }
        /**如果不相同，构造父节点并递归构造子节点**/
        Node father = new Node(
                true,
                false,
                build(grid,r0,c0,(r0+r1)/2,(c0+c1)/2),
                build(grid,r0,(c0+c1)/2,(r0+r1)/2,c1),
                build(grid,(r0+r1)/2,c0,r1,(c0+c1)/2),
                build(grid,(r0+r1)/2,(c0+c1)/2,r1,c1)
        );
        return father;
    }
}
