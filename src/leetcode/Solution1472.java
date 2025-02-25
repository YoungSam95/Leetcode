package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1472. 设计浏览器历史记录
 */
public class Solution1472 {
    class BrowserHistory {
        private List<String> urls;
        private int currIndex;

        public BrowserHistory(String homepage) {
            this.urls = new ArrayList<>();
            this.urls.add(homepage);
            this.currIndex = 0;
        }

        public void visit(String url) {
            while (urls.size() > currIndex + 1) {
                urls.remove(urls.size() - 1);
            }
            urls.add(url);
            this.currIndex++;
        }

        public String back(int steps) {
            currIndex = Math.max(currIndex - steps, 0);
            return urls.get(currIndex);
        }

        public String forward(int steps) {
            currIndex = Math.min(currIndex + steps, urls.size() - 1);
            return urls.get(currIndex);
        }
    }
}
