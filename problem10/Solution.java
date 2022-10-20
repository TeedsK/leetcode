package problem10;

public class Solution {
	public static void main(String[] args) {
		String[][] tests = {
//				{"aa", "a"}, // false
//				{"aa", "a*"}, // true
//				{"ab", ".*"}, // true
//				{"aaa","ab*a*c*a"}, // true
//				{"ab",".*c"}, // false
//				{"aab","c*a*b"}, //true
//				{"bbbba",".*a*a"},
//				{"ab",".*.."}
				{"a",".*..a*"}
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
		
		int addedCount = 0;
		int controlsCount = 0;
		
		while(addedCount < letters.length && controlsCount < controls.length) {
			
			String letter = letters[addedCount];
			String control = controls[controlsCount];
			
			if(letter.equals(control)) {
				
				result[addedCount] = letter;
				addedCount++;
				controlsCount++;
				
			} else if(control.equals(".")) {
				
				result[addedCount] = letter;
				addedCount++;
				controlsCount++;
				
			} else if(control.equals("*")) {
				
				String previous = controls[controlsCount - 1];
				if((addedCount - 1) > 0)
					result[addedCount - 1] = result[addedCount - 1].toUpperCase();
				
				while(addedCount < letters.length && equals(letters[addedCount], previous)) {
					
					if(previous.equals(".")) 
						result[addedCount] = letters[addedCount].toUpperCase();
					else 
						result[addedCount] = previous.toUpperCase();
					
					addedCount++;
				}
				controlsCount++;
				
			} else if(addedCount > 0 && result[addedCount - 1].equals(letter.toUpperCase())) {
				
				System.out.println("did this");
				result[addedCount - 1] = control;
				controlsCount++;
				
//				int temp = addedCount;
//				
				
			} else {
				controlsCount++;
			}
		}
		
		boolean itr = false;
		boolean removeable = false;
		
		while(controlsCount < controls.length) {
			String control = controls[controlsCount];
			if(equals(result[result.length - 1], control.toUpperCase())) {
				if(control.equals(".") && Character.isLowerCase(result[result.length - 1].charAt(0)))
					return false;
				if(result.length > 1 && equals(result[result.length - 2], control.toUpperCase())) {
					result[addedCount - 2] = getAppropriate(control, result[addedCount - 2]);
				} else {
					result[addedCount - 1] = getAppropriate(control, result[addedCount - 1]);
				}
				removeable = true; 
			} else if(control.equals("*")) {
				if(controlsCount - 1 >= 0 && controlsCount - 1 < result.length)
					result[controlsCount - 1] =result[controlsCount - 1].toUpperCase();
				itr = false;
				if(removeable)
					result[addedCount - 1] = result[addedCount - 1].toUpperCase();
				removeable = false;
			} else if(itr){
				return false;
			} else {
				itr = true;
				removeable = false;
			}
			controlsCount++;
		}
//		
		if(itr)
			return false;
		
		print(letters);
		print(result);
		
		for(int i = 0; i < letters.length; i++) {
            if(result[i] == null || !letters[i].equals(result[i].toLowerCase()))
                return false;
        }
		
		return true;
	}
	
	public static String getAppropriate(String control, String letter) {
		if(control.equals("."))
			return letter.toLowerCase();
		return letter.toLowerCase();
	}
	

	public static boolean equals(String arg1, String arg2) {
		if(arg1.equals(arg2))
			return true;
		else if(arg2.equals("."))
			return true;
		else 
			return false;
	}
	
	public static void print(String[] array) {
		for(String s : array) {
			System.out.print(s + ", ");
		}
		System.out.println();
	}
}