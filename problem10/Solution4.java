package problem10;

import java.util.ArrayList;
import java.util.Stack;

public class Solution4 {
	public static void main(String[] args) {
		String[][] tests = {
//				{"aa", "a"}, // false
				{"aa", "a*"}, // true
//				{"ab", ".*"}, // true
				{"aaa","ab*a*c*a"}, // true
//				{"ab",".*c"}, // false
//				{"aab","c*a*b"}, //true
//				{"bbbba",".*a*a"},
//				{"ab",".*.."},
				{"a",".*..a*"}, // false
//				{"mississippi","mis*is*ip*."},
//				{"bbb",".*"},
//				{"sdfas","sdf.*s"},
				{"aasdfasdfasdfasdfas","aasdf.*asdf.*asdf.*asdf.*s"}
		};
		for(String[] test : tests) {
			System.out.println(isMatch(test[0], test[1]) + ", " + print(test));
			System.out.println();
		}
	}
	
	public static boolean isMatch(String s, String p) {
		String[] letters = s.split("");
		String[] controls = p.split("");
		return isMatch(letters, controls, 0, 0);
	}
	public static boolean isMatch(String[] s, String[] p, int i, int j) {
		if(i >= s.length && j >= p.length)
			return true;
		if(j >= p.length)
			return false;
		
		boolean equal = i < s.length && (s[i].equals(p[j]) || p[j].equals("."));	
		
		if((j + 1) < p.length && p[j + 1].equals("*")) 
			return isMatch(s, p, i, (j + 2)) || (equal && isMatch(s, p, (i + 1), j));
		
		if(equal)
			return isMatch(s, p, (i + 1), (j + 1));
		
		return false;
	}
	
	public static String print(String[] ele) {
		String result = "";
		result += "[";
		for(String s : ele) 
			result += (s + ", ");
		result += "]";
		return result;
	}
	
	private static boolean equals(String control, String letter) {
		return control.equals(".") || control.equals(letter);
	}
}