package leetcode;

/**
 * 2286. 以组为单位订音乐会的门票
 */
public class Solution2286 {
    private int n;
    private int m;
    private int[] minTree;
    private long[] sumTree;

    public void BookMyShow(int n, int m) {
        this.n = n;
        this.m = m;
        this.minTree = new int[4 * n];
        this.sumTree = new long[4 * n];
    }

    private void modify(int i, int l, int r, int index, int val) {
        if (l == r) {
            minTree[i] = val;
            sumTree[i] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (index <= mid) {
            modify(i * 2, l, mid, index, val);
        } else {
            modify(i * 2 + 1, mid + 1, r, index, val);
        }
        minTree[i] = Math.min(minTree[i * 2], minTree[i * 2 + 1]);
        sumTree[i] = sumTree[i * 2] + sumTree[i * 2 + 1];
    }

    private int queryMinRow(int i, int l, int r, int val) {
        if (l == r) {
            if (minTree[i] > val) {
                return n;
            }
            return l;
        }
        int mid = (l + r) / 2;
        if (minTree[i * 2] <= val) {
            return queryMinRow(i * 2, l, mid, val);
        } else {
            return queryMinRow(i * 2 + 1, mid + 1, r, val);
        }
    }

    private long querySum(int i, int l, int r, int l2, int r2) {
        if (l2 <= l && r <= r2) {
            return sumTree[i];
        }
        int mid = (l + r) / 2;
        long sum = 0;
        if (mid >= l2) {
            sum += querySum(i * 2, l, mid, l2, r2);
        }
        if (mid + 1 <= r2) {
            sum += querySum(i * 2 + 1, mid + 1, r, l2, r2);
        }
        return sum;
    }

    public int[] gather(int k, int maxRow) {
        int i = queryMinRow(1, 0, n - 1, m - k);
        if (i > maxRow) {
            return new int[0];
        }
        long used = querySum(1, 0, n - 1, i, i);
        modify(1, 0, n - 1, i, (int) (used + k));
        return new int[]{i, (int)used};
    }

    public boolean scatter(int k, int maxRow) {
        long usedTotal = querySum(1, 0, n - 1, 0, maxRow);
        if ((maxRow + 1L) * m - usedTotal < k) {
            return false;
        }
        int i = queryMinRow(1, 0, n - 1, m - 1);
        while (true) {
            long used = querySum(1, 0, n - 1, i, i);
            if (m - used >= k) {
                modify(1, 0, n - 1, i, (int) (used + k));
                break;
            }
            k -= m - used;
            modify(1, 0, n - 1, i, m);
            i++;
        }
        return true;
    }
}
