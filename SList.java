import java.io.*;

class List {
    
    public ListNode head;
    public int size;
    
    public List() {
        
        head = null;
        size=0;
    }
    
    public void insertFront(int i) {
        
        head = new ListNode(i, head);
        size++;
    }
    
}

class ListNode {
    
    int item;
    ListNode next;
    
    public ListNode (int i, ListNode s){
        
        item = i;
        next = s;
    }
    
    public ListNode (int i) {
        
        this(i,null);
    }
}

class SList {
    
    public static void main(String[] args) {
        
        List l1 = new List();
        l1.insertFront(3);
        l1.insertFront(4);
        l1.insertFront(5);
        System.out.println(l1.head.item);
        System.out.println(l1.head.next.item);
        System.out.println(l1.head.next.next.item);
    }
}