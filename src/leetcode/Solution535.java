package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 535. TinyURL 的加密与解密
 */
public class Solution535 {
    private Map<Integer, String> dataBase = new HashMap<Integer, String>();
    private int id;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        id++;
        dataBase.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return dataBase.get(key);
    }
}
