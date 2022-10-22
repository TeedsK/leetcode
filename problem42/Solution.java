package problem42;

import javax.naming.spi.DirStateFactory.Result;

/**
 * 
 * @author Theo K.
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] test = {0,1,0,2,1,0,1,3,2,1,2,1};
		int[] test = {4,2,3};
		solution.trap(test);
	}
	
	public int trap(int[] height) {
		int count = 0;
		for(int i = 0; i < height.length - 1;) {
			
			
			
			if(height[i] > height[i + 1]) {
				
				int[] result = countTrapped(height, height[i], i);
				if(result != null) {
//					System.out.println(i +", " + height[i] + " : count = " + result[0] +", position = " + result[1]);
					count += result[0];
					i = result[1];
				} else {
//					System.out.println("doesn't fit");
					i++;
				}
				
				
			} else {
				i++;
			}
		}
		System.out.println(count);
		return 0;
	}
	
	private int[] countTrapped(int[] list, int height, int pointer) {
		
		while(height > 0) {
			int count = 0;
			int i = 0;
			for(i = pointer + 1; (i < list.length); i++) {
				if(list[i] < height) {
					count += height - list[i];
//					System.out.println(list[i] + " | " + list[pointer]);
				} else {
//					System.out.println(list[i] + " | " + list[pointer]);
					return new int[] {count, i};
				}
			}
			height--;
		}
		
		return null;
		
		
		
	}
}