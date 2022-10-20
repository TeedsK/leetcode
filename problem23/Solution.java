package problem23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		//[[1,4,5],[1,3,4],[2,6]]
		
	}
	
	public Solution() {
		ListNode n1 = new ListNode(1, new ListNode(4, new ListNode(5)));
		ListNode n2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		ListNode n3 = new ListNode(2, new ListNode(6));
		ListNode[] list = {n1, n2, n3};
		ListNode node = mergeKLists(list);
		
		ListNode temp = node;
		System.out.println(node.val);
        while(temp.next != null) {
        	temp = temp.next;
        	System.out.println(temp.val);
        }
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        
		ArrayList<ListNode> tempList = new ArrayList<ListNode>();
        
        for(ListNode node : lists) {
            ListNode temp = node;
            tempList.add(temp);
            while(temp.next != null) {
            	tempList.add(temp.next);
                temp = temp.next;
            }
        }
        
        
        Collections.sort(tempList, new Comparator<ListNode>() {
        	@Override
        	public int compare(ListNode o1, ListNode o2) {
        		return ((Integer) o1.val).compareTo((Integer) o2.val);
        	}
        }); 
        
        for(int i = 0; i < tempList.size() - 1; i++) {
        	tempList.get(i).next = tempList.get(i + 1);
        }
        
        if(tempList.size() > 0)
            return tempList.get(0);
        
        return new ListNode();
      
    }
	
    
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {
        	 
         }
         ListNode(int val) { 
              this.val = val; 
         }
         ListNode(int val, ListNode next) { 
              this.val = val; 
              this.next = next; 
         }
    }
}