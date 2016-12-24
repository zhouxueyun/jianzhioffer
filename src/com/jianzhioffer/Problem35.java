package com.jianzhioffer;

import java.util.LinkedHashMap;

/**
 * 在字符串中找出第一个只出现一次的字符。如果输入“abaccdeff”，则 输出‘b’。
 * 
 * @author zhouxueyun
 */
public class Problem35 {

	public static void main(String[] args) {
		Problem35 test = new Problem35();
		System.out.println(test.firstNotRepeatCharByArray("agbaccdeff"));
		System.out.println(test.firstNotRepeatCharByMap("agbaccdeff"));
	}

	private Character firstNotRepeatCharByArray(String str) {
		if (str == null)
			return null;
		char[] strChar = str.toCharArray();
		int[] charArray = new int[256];
		for (char item : strChar) {
			charArray[item]++;
		}
		for (char item : strChar) {
			if (charArray[item] == 1)
				return item;
		}
		return null;
	}

	public Character firstNotRepeatCharByMap(String str) {
		if (str == null)
			return null;
		char[] strChar = str.toCharArray();
		LinkedHashMap<Character, Integer> hash = new LinkedHashMap<Character, Integer>();
		for (char item : strChar) {
			if (hash.containsKey(item))
				hash.put(item, hash.get(item) + 1);
			else
				hash.put(item, 1);
		}
		for (char key : hash.keySet()) {
			if (hash.get(key) == 1)
				return key;
		}
		return null;
	}

}
