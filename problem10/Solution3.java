package problem10;

import java.util.Stack;

public class Solution3 {
	
	public static void main(String[] args) {
		String[][] tests = {
//				{"aa", "a"}, // false
//				{"aa", "a*"}, // true
//				{"ab", ".*"}, // true
				{"aaa","ab*a*c*a"}, // true
//				{"ab",".*c"}, // false
//				{"aab","c*a*b"}, //true
//				{"bbbba",".*a*a"},
//				{"ab",".*.."},
//				{"a",".*..a*"}, // false
//				{"mississippi","mis*is*ip*."},
//				{"bbb",".*"},
//				{"sdfas","sdf.*s"},
//				{"aasdfasdfasdfasdfas","aasdf.*asdf.*asdf.*asdf.*s"}
		};
		for(String[] test : tests) {
			System.out.println(isMatch(test[0], test[1]) + ", " + print(test));
			System.out.println();
		}
	}
	
	public static String print(String[] ele) {
		String result = "";
		result += "[";
		for(String s : ele) 
			result += (s + ", ");
		result += "]";
		return result;
	}
	
	public static boolean isMatch(String s, String p) {
		Stack<String> letters = new Stack<String>();
		Stack<String> controls = new Stack<String>();
		
		addItemsToStack(letters, s.split(""));
		addItemsToStack(controls, p.split(""));
		
		while(!controls.isEmpty()) {
			if(letters.isEmpty() && !controls.peek().equals("*"))
				return false;
			
			String letter = "";
			
			if(!letters.isEmpty()) 
				letter = letters.peek();
			
			
			
			String control = controls.pop();
			if(equals(control, letter)) {
				letters.pop();
				continue;
			} else if(control.equals("*")) {
				
				@SuppressWarnings("unchecked")
				Stack<String> controlTemp = (Stack<String>)controls.clone(); 
				
				control = controls.pop();
				
				String cPreview = "";
				
				if(!controls.isEmpty())
					cPreview = controls.peek();
				
				while(!equals(cPreview, letter) && equals(control, letter)) {
					letters.pop();
					if(!letters.isEmpty())
						letter = letters.peek();
					else
						letter = "";
				}
			} else {
				return false;
			}	
		}
		
		return letters.isEmpty();
	}
	
	
	private static boolean equals(String control, String letter) {
		return control.equals(".") || control.equals(letter);
	}
	
	private static void addItemsToStack(Stack<String> stack, String[] items) {
		for(String item : items) {
			stack.push(item);
		}
	}
	
}