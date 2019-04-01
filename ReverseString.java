import java.util.Stack;

/** 字符串倒序输出三种方法 **/
public class ReverseSort {
	public static String reverseSort(String str) {
		String str2 = "";
		for (int i = str.length(); i > 0; i--) {
			str2 += String.valueOf(str.charAt(i - 1));
		}
		return str2;
	}
    
	private static StringBuilder stackreverse(String str) {
		Stack<Character> stack = new Stack<>();
		for (int j = 0;j<str.length();j++) {
			stack.push(str.charAt(j));
		}
		StringBuilder builder2 = new StringBuilder();
		for(int j = 0;j<str.length();j++) {
			builder2.append(stack.pop());
		}
		return builder2;
	}
	public static void main(String[] args) {
		String str = "gfedcba";
		// 方法1
		String sortedStr = reverseSort(str);
		System.out.println(sortedStr);
		// 方法2
		StringBuilder builder = new StringBuilder();
		builder.append(str);
		System.out.println(builder.reverse());
		// 方法3
		System.out.println(stackreverse(str));
	}
	
}
