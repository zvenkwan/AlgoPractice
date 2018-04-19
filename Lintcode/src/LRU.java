import java.util.HashMap;

public class LRU {
	
	public static void main(String[] args) {

		LRU l = new LRU(3);
		l.test();
//		System.out.println("l.set(2	, 2);");
//		l.set(2	, 2);
//		System.out.println("set(1, 1)");
//		l.set(1, 1);
//		System.out.println("l.get(2)");
//		System.out.println(l.get(2));
//		System.out.println("set(4, 4)");
//		l.set(4, 4);
//		System.out.println("l.get(1)");
//
//		System.out.println(l.get(1));
//		System.out.println("l.get(2)");
//		System.out.println(l.get(2));
		
		
		
	}
	
	
    private HashMap<Integer, Node> map = null;
    private Node head = null;
    private Node tail = null;
    private int capacity;
    // @param capacity, an integer
    public LRU(int capacity) {
        // write your code here
        this.capacity = capacity;
        map = new HashMap<Integer, Node>(capacity);
        print();
    }

    public void test() {
    	set(1,1);set(2,2);set(3,3);set(4,4);
    	System.out.println("----------------");
    	get(4);
    	System.out.println("----------------");
    	get(3);
    	System.out.println("----------------");
    	get(2);
    	System.out.println("----------------");
    	get(1);
    	System.out.println("----------------");
    	set(5,5);

    	System.out.println("***************");
    	get(1);get(2);get(3);get(4);get(5);
    }
    
    private void remove(Node node) {
    	if(map.containsKey(node.key)) {
    		map.remove(node.key);
    		
    		Node previous = node.prev;
    		Node next = node.next;
    		if(node == tail) tail = previous;
    		if(previous != null) previous.next = next;
    		if(next != null) next.prev = previous;
    		if(isHead(node)) head = next;
    		node.prev = null;
    		node.next = null;
    	}
    }
    
    private void insert(Node node) {
    	if(tail == null) {
    		head = node;
    	} else {
    		tail.next = node;
    		node.prev = tail;
    	}
    	tail = node;
    	map.put(node.key, node);
    }
    
    private boolean isHead(Node node) {
    	return head == node;
    }
    
    private void setHead(Node node) {
    	if(node != null) {
    		head = node;
    	}
    }
    // @return an integer
    public int get(int key) {
        // write your code here
        if(map.containsKey(key)) {
        	Node node = map.get(key);
        	if(tail == node) return node.value;
        	remove(node);
//        	if(isHead(node)) setHead(node.next);
        	insert(node);
            print();
        	return node.value;
        }
        print();
        return -1;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
    	if(map.containsKey(key)) {
			System.out.println("found!!!");
    		Node node = map.get(key);
    		remove(node);
    		if(isHead(node)) setHead(node.next);
    		node.value = value;
    		insert(node);
    	} else {
    		Node node = new Node(key, value);
        	print();
    		insert(node);
    		if(map.size() > capacity) {
    			System.out.println("exceeded!!!");
	    		remove(head);
    		}
    	}
    	print();
    }
    
    private void print() {
    	if(head == null) {
    		System.out.println("list is null");
    		return;
    	}
    	
    	System.out.println("         " + "          head is "+ head.value + "   tail is " +tail.value);
    	Node p = head;
//    	StringBuilder sb = new StringBuilder();
    	System.out.print("               ");
    	while(p != null) {
    		System.out.print(p.value+"->");
//    		sb.append(p.value);
//    		sb.append("->");
    		p = p.next;
    	}
//    	System.out.println("               " + sb.toString());
    	System.out.println("               ");
    	System.out.println(map);
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
    public String toString() {
    	return this.value+"";
    }
}