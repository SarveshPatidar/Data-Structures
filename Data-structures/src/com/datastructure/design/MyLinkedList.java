package com.datastructure.design;

public class MyLinkedList {

	// This is the definition (structure) for our linked-list which contains value and pointer to the next node.
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	// represents the size of our LinkedList.
	private int size;
	
	// this refer to the head pointer
	private ListNode head;

	// this constructor will initialize our size & head variable.
	public MyLinkedList() {
		this.size = 0;
		head = new ListNode(-1);
	}

	// this method will return the element(value) present at the given index.
	public int get(int index) {
		if (index < 0 || index >= size) {
			return -1;
		}
		int count = 0;
		ListNode temp = head;
		while (count <= index) {
			temp = temp.next;
			count++;
		}
		return temp.val;
	}

	// this method will add new node at the beginning of the Linked List
	public void addAtHead(int val) {
		this.addAtIndex(0, val);
	}

	// this method will add new node at the tail of the Linked List.
	public void addAtTail(int val) {
		this.addAtIndex(size, val);
	}

	// this method will add new node at given index.
	public void addAtIndex(int index, int val) {

		if (index > size) {
			return;
		}
		if (index < 0) {
			index = 0;
		}

		int count = 0;
		ListNode temp = head;
		while (count < index) {
			temp = temp.next;
			count++;
		}
		ListNode newNode = new ListNode(val);
		newNode.next = temp.next;
		temp.next = newNode;
		size++;

	}

	// this method will delete node for the given index.
	public void deleteAtIndex(int index) {
		if (index >= size || index < 0) {
			return;
		}
		int count = 0;
		ListNode temp = head;
		while (count < index) {
			temp = temp.next;
			count++;
		}
		temp.next = temp.next.next;
		size--;
	}

	
	// driver method to test out methods.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addAtHead(1);
		myLinkedList.addAtTail(3);
		myLinkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
		myLinkedList.get(1); // return 2
		myLinkedList.deleteAtIndex(1); // now the linked list is 1->3
		myLinkedList.get(1); // return 3

	}

}
