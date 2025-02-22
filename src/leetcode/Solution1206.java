package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * 1206. 设计跳表
 * 第二次
 * Redis底层数据结构:跳表->以O(logN)的时间复杂度内完成增删改查指定元素
 * 核心原理:建立多层随机索引,将时间复杂度降至logN,具体可参考简书的博客
 * randomLevel()函数:
 *      以0.25为概率因子生成最大值为32的随机数数字每增加1,出现的概率为前一个数的0.25倍
 *      如:1出现的概率为0.75;1以上出现的概率为0.25;
 *        2出现的概率就是0.25*0.75;3出现的概率就是0.25*0.75*0.75
 *      这样可以间接保证每一层的元素成类似于二叉树的结构,最大高度不过logN
 */
public class Solution1206 {

    class Skiplist {
        /**最大层数**/
        static final int MAX_LEVEL = 32;
        /**概率因子**/
        static final double P_FACTOR = 0.25;
        /**SkipListNode数据结构**/
        class SkiplistNode {
            int val;
            SkiplistNode[] forward;
            public SkiplistNode(int val, int level){
                this.val = val;
                this.forward = new SkiplistNode[level];
            }
        }

        private SkiplistNode head;
        private int level;
        private Random random;

        public Skiplist() {
            this.head = new SkiplistNode(-1,MAX_LEVEL);
            this.level = 0;
            random = new Random();
        }

        public boolean search(int target) {
            SkiplistNode curr = this.head;
            /**找到第 i 层小于且最接近 target 的元素**/
            for(int i = level - 1; i >= 0; i--){
                while(curr.forward[i] != null && curr.forward[i].val < target){
                    curr = curr.forward[i];
                }
            }
            if(curr.forward[0] != null && curr.forward[0].val == target){
                return true;
            }
            return false;
        }

        public void add(int num) {
            SkiplistNode curr = this.head;
            SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
            Arrays.fill(update,head);
            /**找到第 i 层小于且最接近 target 的元素**/
            for(int i = level - 1; i >= 0; i--){
                while(curr.forward[i] != null && curr.forward[i].val < num){
                    curr = curr.forward[i];
                }
                update[i] = curr;
            }
            int lv = randomLevel();
            level = Math.max(lv,level);
            SkiplistNode newNode = new SkiplistNode(num,lv);
            for(int i = 0; i < lv; i++){
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }

        public boolean erase(int num) {
            SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
            SkiplistNode curr = this.head;
            for (int i = level - 1; i >= 0; i--) {
                /* 找到第 i 层小于且最接近 num 的元素*/
                while (curr.forward[i] != null && curr.forward[i].val < num) {
                    curr = curr.forward[i];
                }
                update[i] = curr;
            }
            curr = curr.forward[0];
            /* 如果值不存在则返回 false */
            if (curr == null || curr.val != num) {
                return false;
            }
            for (int i = 0; i < level; i++) {
                if (update[i].forward[i] != curr) {
                    break;
                }
                /* 对第 i 层的状态进行更新，将 forward 指向被删除节点的下一跳 */
                update[i].forward[i] = curr.forward[i];
            }
            /* 更新当前的 level */
            while (level > 1 && head.forward[level - 1] == null) {
                level--;
            }
            return true;
        }

        public int randomLevel() {
            int lv = 1;
            /** 随机生成 lv **/
            while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
                lv++;
            }
            return lv;
        }
    }
    public static void main(String[] args){
        Solution1206 s = new Solution1206();
        Skiplist skiplist = s.new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        skiplist.search(0);   // 返回 false
        skiplist.add(4);
        skiplist.search(1);   // 返回 true
        skiplist.erase(0);    // 返回 false，0 不在跳表中
        skiplist.erase(1);    // 返回 true
        skiplist.search(1);   // 返回 false，1 已被擦除
    }
}
