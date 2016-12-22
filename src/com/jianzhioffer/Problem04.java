package com.jianzhioffer;

/**
 * 请实现一个函数，把字符串中的每个空格替换成“%20”。
 * 
 * @author zhouxueyun
 */
public class Problem04 {

	public static void main(String[] args) {
		Problem04 test = new Problem04();
		String s = "We are happy!";
		System.out.println(test.replaceBlank(s));
	}

	public String replaceBlank(String str){
		if (str==null || str.isEmpty()) 
			return str;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (' '==str.charAt(i)){
				sb.append("%20");
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
}
