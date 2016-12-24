package com.jianzhioffer;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 
 * @author zhouxueyun
 */
public class Problem28 {

	public static void main(String[] args) {
		Problem28 test = new Problem28();
		test.permutation("ab");
		test.permutation("abc");
		test.permutation("abcd");
	}

	public void permutation(String str){
		if (str==null || str.length()==0) return;
		permutation(str.toCharArray(), 0);
	}
	
	private void permutation(char[] chs, int begin){
		if (begin==chs.length) {
			System.out.println(chs);
		} else {
			for (int i = begin; i < chs.length; i++) {
				// 交换
				char temp = chs[i];
				chs[i] = chs[begin];
				chs[begin] = temp;
				permutation(chs, begin+1);
				// 恢复
				temp = chs[i];
				chs[i] = chs[begin];
				chs[begin] = temp;
			}
		}
	}
	
}
