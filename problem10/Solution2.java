package problem10;

/**
 * 
 * @author teeds
 *
 */
public class Solution2 {
	public static void main(String[] args) {
		String[][] tests = {
//				{"aa", "a"}, // false
//				{"aa", "a*"}, // true
//				{"ab", ".*"}, // true
//				{"aaa","ab*a*c*a"}, // true
//				{"ab",".*c"}, // false
//				{"aab","c*a*b"}, //true
//				{"bbbba",".*a*a"},
//				{"ab",".*.."},
//				{"a",".*..a*"},
//				{"mississippi","mis*is*ip*."}
//				{"bbb",".*"}
				{"aasdfasdfasdfasdfas","aasdf.*asdf.*asdf.*asdf.*s"}
		};
		for(String[] test : tests) {
			System.out.println(isMatch(test[0], test[1]));
			System.out.println("---------NEW TEST--------");
		}
	}
	
	public static boolean isMatch(String s, String p) {
		
		String[] letters = s.split("");
		String[] controls = p.split("");
		
		String[] result = new String[letters.length];
		
		int x = result.length - 1;
		int i = controls.length - 1;
		int follower = 0;
	
		while(i >= 0) {
			
			if(i < 0)
				return false;
			
			if(x < 0) {
				x = 0;
			}
			System.out.println("i: " + i +" | x: " + x + "  |  " + result.length);
			String letter = letters[x];
			
			String control = controls[i];
			
			
			if(control.equals(".")) {
				result[x] = letter;
				x--;
			} else if(control.equals(letter)) {
				result[x] = letter;
				x--;
			} else if(control.equals("*")) {
				
				control = controls[i - 1];
				i--;
				follower++;
				int temp = i;
				while(x >= 0 && !controls[temp].equals(letters[x]) && (control.equals(letters[x]) || control.equals("."))) {
					result[x] = letters[x].toUpperCase();
					x--;
					
				}
				
			} else {
				int temp = result.length - (controls.length - follower);
				
				if(control.toUpperCase().equals(result[temp]) || result[temp].equals(".")) {
				
				} else {
					System.out.println();
					System.out.println("temp : " + temp +" / " + control + " / "+ result[temp]);
					System.out.println("FAILED COMPLETELY");
					System.out.println(control + ", " + letters[x] + ", " + result[temp]);
					System.out.println();
					System.out.println(i + ", " + x + ", " + temp +", " + follower +  ", " + control);
					System.out.println();
					
					print("FAILED result", result);
					print("CONTROLS result", controls);
					return false;
				}
			}
			i--;
			
		}
		
		print("original", letters);
		print("result ", result);
		print("controls", controls);
		for(int j = 0; j <= i; j++) {
			System.out.print(controls[j] + ", ");
		}
		System.out.println();
		
		
//		int offset = controls.length - result.length;
//		System.out.println(i + " | " + controls.length + " | " + result.length);
		int j1 = 0;
		int j2 = 0;
//		
//		while(j1 < controls.length - 1) {
//			if(j2 >= result.length)
//				return false;
//			
//			System.out.println(controls[j1] + " | " + result[j2]);
//			
//			if(controls[j1 + 1].equals("*")) {
//				j1 += 2;
//				if(Character.isUpperCase(result[j2].charAt(0)))
//					j2+=2;
//
//				continue;
//			}
//			
//			if(!controls[j1].equals(".") && !controls[j1].equals(result[j2])) {
//				return false;
//			}
//			
//			j2++;
//			j1++;
//		}
		
//		for(int j = 0; j < result.length - 1; j++) {
//			System.out.println(controls[j] + " | " + result[j]);
//			if(controls[j + 1].equals("*")) {
//				j += 2;
//				continue;
//			}
//			if(!controls[j].toUpperCase().equals(result[j])) {
//				return false;
//			}
//			if(!controls[j].equals(".") && !Character.isUpperCase(result[j].charAt(0)))
//				return false;
//		}
		
		
		
//		j2 += 1;
		
//		if(!controls[j1].equals(".") && )
//		return false;
		
//		if(!controls[j1].equals(".") && !Character.isUpperCase(result[j2].charAt(0)))
//		return false;
//	
//	if(!controls[j1].equals(".") && !controls[j1].toUpperCase().equals(result[j2])) {
//		return false;
//	}
//	
		
		
//		
//		while(i >= 0) {
//			
//			int spot = i - offset;
//			
//			if(controls[i].equals("*")) {
//				i-=2;
//				continue;
//			}
//			
//			System.out.println(spot);
//			System.out.println(spot + " | " + result.length);
//			System.out.println(controls[i].toUpperCase() + " | " + result[spot]);
//			
////			if(i > result.length)
////				return false;
//			
//			if(!controls[i].toUpperCase().equals(result[spot])) {
//				return false;
//			}
//			if(!controls[i].equals(".") && !Character.isUpperCase(result[spot].charAt(0)))
//				return false;
//			
//			i--;
//		}
		
		for(int j = 0; j < letters.length; j++) {
            if(result[j] == null || !letters[j].equals(result[j].toLowerCase()))
                return false;
        }
		
		return true;
	}
	
	public static void print(String title, String[] array) {
		System.out.print(title + ": ");
		for(String s : array) {
			System.out.print(s + ", ");
		}
		System.out.println();
	}
}