package leetcode;

/**
 * 1358. 包含所有三种字符的子字符串数目
 */
public class Solution1358 {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int ans = 0;
        int[] cnt = new int[3];

        for (int l = 0, r = -1; l < len; ) {
            while (r < len && !(cnt[0] >= 1 && cnt[1] >= 1 && cnt[2] >= 1)) {
                r++;
                if (r == len) {
                    break;
                }
                cnt[s.charAt(r) - 'a']++;
            }
            if (r < len) {
                ans += len - r;
            }
            cnt[s.charAt(l) - 'a']--;
            l++;
        }

        return ans;
    }
}
