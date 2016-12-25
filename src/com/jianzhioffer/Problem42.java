package com.jianzhioffer;

/**
 * 题目一:<br>
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。 为简单起见，标点符号和普通字母一样处理。<br>
 * 例如输入字符串“I am a student.”， 则输出“student. a am I”.<br>
 * 题目二:<br>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。 请定义一个函数实现字符串左旋转操作的功能。<br>
 * 比如输入字符串“abcdefg”和 数字 2.该函数左旋转 2 位得到的结果“cdefgab".
 * 
 * @author zhouxueyun
 *
 */
public class Problem42 {

	public static void main(String[] args) {
		Problem42 test = new Problem42();
		String string = "I am a student.";
		test.reverseSentence(string);
		test.leftRotateString("abcdefg", 2);
	}

	/** 题目1 */
	public void reverseSentence(String sentence) {
		if (sentence == null)
			return;
		String[] str = sentence.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = str.length - 1; i >= 0; i--) {
			sb.append(str[i] + " ");
		}
		System.out.println(sb);
	}

	/** 题目2 */
	public void leftRotateString(String sentence, int index) {
		if (sentence == null || index > sentence.length() || index < 0) {
			return;
		}
		String[] splitString = { sentence.substring(index, sentence.length()), sentence.substring(0, index) };
		StringBuffer resultbBuffer = new StringBuffer();
		for (String s : splitString) {
			resultbBuffer.append(s);
		}
		System.out.println(resultbBuffer.toString());
	}

}
