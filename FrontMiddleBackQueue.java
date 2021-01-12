class FrontMiddleBackQueue {
	class Node{
		int value;
		Node next;
		public Node(int value, Node next) {
			super();
			this.value = value;
			this.next = next;
		}
		public Node() {
			super();
		}
		
	}
	
	Node root;
	int size;
    public FrontMiddleBackQueue() {
        this.root = new Node();
        this.size = 0;
    }
    
    public void pushFront(int val) {
    	Node next = this.root.next;
    	Node n = new Node(val,next);
    	this.root.next = n;
    	this.size++;
    }
    
    public void pushMiddle(int val) {
    	int middle = this.size / 2;
    	Node n = this.root;
    	int index = 0;
    	while(n!=null && index < middle) {
    		n = n.next;
    		index++;
    	}
    	Node node = new Node(val,n.next);
    	n.next = node;
    	this.size++;
    }
    
    public void pushBack(int val) {
    	int middle = this.size;
    	Node n = this.root;
    	int index = 0;
    	while(n!=null && index < middle) {
    		n = n.next;
    		index++;
    	}
    	Node node = new Node(val,n.next);
    	n.next = node;
    	this.size++;
    }
    
    public int popFront() {
    	if(this.size==0) return -1;
    	Node n = this.root.next;
    	this.root.next = n.next;
    	this.size--;
    	return n.value;
    }
    
    public int popMiddle() {
    	if(this.size==0) return -1;
    	int middle = (int)Math.ceil(this.size/2.0);
    	Node f = this.root;
    	Node n = this.root;
    	int index = 0;
    	
    	while(n!=null && index < middle) {
    		f = n;
    		n = n.next;
    		index++;
    	}
    	
    	Node node = n;
    	f.next = node.next;
    	this.size--;
    	return node.value;
    }
    
    public int popBack() {
    	if(this.size==0) return -1;
    	int middle = this.size;
    	Node n = this.root;
    	int index = 0;
    	while(n!=null && index < middle-1) {
    		n = n.next;
    		index++;
    	}
    	Node node = n.next;
    	n.next = null;
    	this.size--;
    	return node.value;
    }
    
    public static void main(String[] args) {
    	FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
    	obj.pushFront(1);
    	obj.pushFront(5);
    	obj.pushBack(4);
    	System.out.println(obj.popMiddle());
    	obj.pushFront(2);
    	obj.pushMiddle(3);
    	
    	Node r = obj.root;
    	while(r!=null) {
    		System.out.println(r.value);
    		r= r.next;
    	}
    	
    }
}



/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */