package leetcode.easy;


import java.util.HashSet;
import java.util.Set;

/**
 * @author CheNbXxx
 * @description    电子邮件地址判断
 * @email chenbxxx@gmail.con
 * @date 2019/3/1 10:09
 */
public class LeetCode929 {
	class Solution {
		private Set<String> res = new HashSet<>();
		public int numUniqueEmails(String[] emails) {
			for (String string : emails){
				handle(string);
			}
			return res.size();
		}

		private void handle(String string){
			final String[] des = string.split("@");
			final String split = des[0].split("\\+")[0].replace(".","");
			res.add(split+"@"+des[1]);
		}
	}

	public static void main(String[] args) {
		new LeetCode929().new Solution().numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});

	}
}
