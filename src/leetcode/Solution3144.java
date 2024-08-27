package leetcode;

/**
 * 3144. 分割字符频率相等的最少子字符串
 */
public class Solution3144 {
    static final int INF = 0x3f3f3f3f;

    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            Map<Character, Integer> occCnt = new HashMap<Character, Integer>();
            int maxCnt = 0;
            for (int j = i; j >= 1; j--) {
                occCnt.put(s.charAt(j - 1), occCnt.getOrDefault(s.charAt(j - 1), 0) + 1);
                maxCnt = Math.max(maxCnt, occCnt.get(s.charAt(j - 1)));
                if (maxCnt * occCnt.size() == (i - j + 1) && d[j - 1] != INF) {
                    d[i] = Math.min(d[i], d[j - 1] + 1);
                }
            }
        }
        return d[n];
    }
}
