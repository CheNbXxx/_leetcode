package top.chenbxxx.daily;

/**
 * 1160. 拼写单词
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 * <p>
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 *
 * @author chen
 * @date 2020/3/17 上午11:02
 */
public class $0017 {

    class Solution {
        public int countCharacters(String[] words, String chars) {
            // Hash
            int res = 0;
            int[] hash = new int[26];
            for (char ch : chars.toCharArray()) {
                hash[ch - 'a']++;
            }

            outer:
            for (int i = 0; i < words.length; i++) {
                int[] tHash = new int[26];
                System.arraycopy(hash, 0, tHash, 0, 26);

                for (char c : words[i].toCharArray()) {
                    final int index = c - 'a';
                    if (tHash[index] == 0) {
                        continue outer;
                    }
                    tHash[index]--;
                }

                res += words[i].length();
            }

            return res;
        }
    }
}
