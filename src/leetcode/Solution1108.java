package leetcode;

/**
 * 1108. IP 地址无效化
 */
public class Solution1108 {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
