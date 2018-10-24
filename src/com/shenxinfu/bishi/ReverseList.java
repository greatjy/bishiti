package com.shenxinfu.bishi;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
        }
}
public class ReverseList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode res = reverse(head);
		while(res != null)
		{
			System.out.println(res.val);
			res = res.next;
			//head = head.next;
		}
	}
	public static ListNode reverse(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		ListNode p1 = head;
		ListNode p2 = head.next;
		head.next = null;
		while(p2 != null)
		{
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;	//此时已经得不到p2.next 了 指针后裔		
		}
		return p1;//结束循环的时候p2 = null p1 是开头节点
		
	}

}
