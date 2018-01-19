package com.newcoder.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	Stack<Integer> stack1=new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	public void push(int node){
		stack1.push(node);
	}
	public int pop(){
		if(stack1.empty())
			System.err.println("No element");
		while(!stack1.empty()){
			stack2.push(stack1.pop());
		}
		int ret = stack2.pop();
		while(!stack2.empty()){
			stack1.push(stack2.pop());
		}
		return ret;
	}
	
    private static int n = 0;
    public static int JumpFloor(int target) {
		if(target == 1 || target == 0)
            n++;
        else if(target >= 2){
            JumpFloor(target-2);
            JumpFloor(target-1);
        }
        return n;
    }
	
	public static String replaceSapce(StringBuffer str){
		int start = 0;
		String ret = "";
		for(int i = 0;i < str.length();i++){
			if(str.charAt(i) == ' '){
				ret += str.substring(start, i).toString() + "%20";
				start = i+1;
			}
		}
		ret += str.substring(start);
		return ret;
	}

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(listNode == null){
			return list;
		}
		ListNode temp = listNode;
    	while(temp != null){
    		list.add(temp.val);
    		temp = temp.next;
    	}
    	Collections.reverse(list);
    	return list;
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	if(pre.length<=0 || in.length<=0)
    		return null;
        TreeNode node = new TreeNode(pre[0]);
        int i=0;
        for(;i<in.length;i++){
        	if(in[i] == pre[0])
        		break;
        }
        int[] inLeft = new int[i];
        int[] preLeft = new int[i];
        int[] inRight = new int[in.length-1-i];
        int[] preRight = new int[in.length-1-i];
        for(int j=0;j<i;j++){
        	inLeft[j]=in[j];
        	preLeft[j]=pre[j+1];
        }
        for(int j=i+1;j<in.length;j++){
        	inRight[j-i-1]=in[j];
        	preRight[j-i-1]=pre[j];
        }
        node.left = reConstructBinaryTree(preLeft, inLeft);
        node.right = reConstructBinaryTree(preRight, inRight);
        return node;
    }
    
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null && list2 == null)
        	return null;
        else if(list1 == null)
        	return list2;
        else if(list2 == null)
        	return list1;
        ListNode temp1 = list1,temp2 = list2,retNode;
        if(temp1.val > temp2.val){
        	retNode = new ListNode(temp2.val);
        	temp2 = temp2.next;
        }
        else{
        	retNode = new ListNode(temp1.val);
        	temp1 = temp1.next;
        }
        while(temp1 != null && temp2 != null){
        	if(temp1.val > temp2.val){
            	ListNode node = new ListNode(temp2.val);
            	retNode.next = node;
            	temp2 = temp2.next;
            }
            else{
            	ListNode node = new ListNode(temp1.val);
            	retNode.next = node;
            	temp1 = temp1.next;
            }
        }
        while(temp1 != null){
        	ListNode node = new ListNode(temp1.val);
        	retNode.next = node;
        	temp1 = temp1.next;
        }
        while(temp2 != null){
        	ListNode node = new ListNode(temp2.val);
        	retNode.next = node;
        	temp2 = temp2.next;
        }
        return retNode;
    }
    
    public static ListNode CreateList(int[] array){
    	ListNode retNode = new ListNode(array[0]);
    	for(int i = 1;i<array.length;i++){
    		ListNode node = new ListNode(array[i]);
    		retNode.next = node;
    	}
    	return retNode;
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,2,3,4,5,6};
//		List list = Arrays.asList(arr);
//		ArrayList<Integer> list0 = new ArrayList<Integer>(list);
//		int i = (int) Collections.min(list);
		
		
		
		ListNode node1 = CreateList(new int[]{1,3,5});
		ListNode node2 = CreateList(new int[]{2,4,6});
		Merge(node1, node2);
		System.out.println(JumpFloor(2));
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 2;i <= 100;i++){
			if(isPrime(i, list)){
				list.add(i);
			}
		}
		System.out.println(list.size());
		StringBuffer str = new StringBuffer("We Are Happy");
		System.out.println(replaceSapce(str));
	}
	
	/**
	 * 迭代法计算素数
	 * @param n
	 * @param list
	 * @return
	 */
	public static boolean isPrime(int n,ArrayList<Integer> list){
		boolean prime = true;
		for(int i = 0;i < list.size() && list.get(i) * list.get(i) <= n;i++){
			if(n % list.get(i) == 0){
				prime = false;
				break;
			}
		}
		return prime;
	}

}
