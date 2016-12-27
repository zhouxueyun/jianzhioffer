package com.jianzhioffer;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字的最小的一个。<br>
 * 例如输入{3,32,321}，则打印最小的数字是 321323.
 * 
 * @author zhouxueyun
 */
public class Problem33 {

	public static void main(String[] args) {
		Problem33 test = new Problem33();
		int[] array = { 3, 32, 321 };
		int[] array2 = { 5, 3, 4, 2, 1 };
		test.printMin(array);
		test.printMin(array2);
	}

	public void printMin(int[] array) {
		int[] clone = array.clone();
		printMinNumber(clone, 0, clone.length - 1);
		for (int i : clone)
			System.out.print(i);
		System.out.println();
	}

	/**
	 * 快排思想，每次将适合放在base前面替换到base前面，将适合放在base后面的放在base后面，base作为一个分割点
	 * @param array
	 * @param start
	 * @param end
	 */
	private void printMinNumber(int[] array, int start, int end) {
		if (start < end) {
			int baseNumber = array[end];
			// 记录当前已处理的适合放在数前面的item在数组中的下标
			int currSmallIndex = start;
			for (int i = start; i < end; i++) {
				if (isSmall(String.valueOf(array[i]), String.valueOf(baseNumber))) {
					// 将适合放在数前面的item移到数组中的前面
					int temp = array[i];
					array[i] = array[currSmallIndex];
					array[currSmallIndex] = temp;
					currSmallIndex++;
				}
			}
			// 交换，currSmallIndex作为pivot
			array[end] = array[currSmallIndex];
			array[currSmallIndex] = baseNumber;
			printMinNumber(array, start, currSmallIndex - 1); // 适合放在数前面的items
			printMinNumber(array, currSmallIndex + 1, end); // 适合放在数后面的items
		}
	}

	private boolean isSmall(String m, String n) {
		String left = m + n;
		String right = n + m;
		boolean result = false;
		for (int i = 0; i < left.length(); i++) {
			if (left.charAt(i) < right.charAt(i))
				return true;
			else if (left.charAt(i) > right.charAt(i))
				return false;
		}
		return result; // mn==nm
	}

}
