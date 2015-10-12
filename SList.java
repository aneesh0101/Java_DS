import java.io.*;

class List {

	public SListNode head;
	public int size =0;

	public List() {

		head = null;
		size = 0;
	}

	public void insertFront(int item) {

		head = new SListNode(item, head);
		size++;
	}


}

class SListNode {

	public int item;
	public SListNode next;

	public SListNode(int i, SListNode s) {

		item = i;
		next = s;
	}

	public SListNode(int i) {

		this(i,null);
	}
}

public class SList {

	public static void main(String[] args) {

		List l = new List();
		l.insertFront(45);
		System.out.println(l.head.item)	;
	}
}