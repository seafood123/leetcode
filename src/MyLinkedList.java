class MyLinkedList {
	class Node {
		int value;
		Node front;
		Node back;

		public Node(int value, Node front, Node back) {
			super();
			this.value = value;
			this.front = front;
			this.back = back;
		}

		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}
	}

	int size;
	Node head;
	Node tail;
	/** Initialize your data structure here. */
	public MyLinkedList() {
		this.size = 0;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		if (this.size < index)
			return -1;
		
		Node node = (index > (size/2))? this.tail:this.head;
		int direction = (index > (size/2))? -1 : 1;
		
		if(direction == -1) {
			index = this.size - index;
		}else {
			index = index-1;
		}
		
		int now = 0;
		
		while(node!=null && now < index) {
			if(direction==-1) {
				node = node.front;
			}else {
				node = node.back;
			}
			now++;
		}
		
		return node.value;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		Node node = new Node(val, null, null);

		if(this.size == 0) {
			this.head = node;
			this.tail = node;
			this.size++;
			return;
		}
		
		node.back = this.head;
		this.head = node;
		this.size++;
		if(this.size==2) {
			this.head.back = this.tail;
			this.tail.front = this.head;
		}

	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		Node node = new Node(val, null, null);
		
		if(this.size == 0) {
			this.head = node;
			this.tail = node;
			this.size++;
			return;
		}
		
		node.front = this.tail;
		this.tail = node;
		this.size++;
		if(this.size==2) {
			this.head.back = this.tail;
			this.tail.front = this.head;
		}
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (this.size < index)
			return ;
		
		Node node = (index > (size/2))? this.tail:this.head;
		int direction = (index > (size/2))? -1 : 1;
		
		if(direction == -1) {
			index = this.size - index;
		}
		
		int now = 0;
		
		while(node!=null && now < index) {
			if(direction==-1) {
				node = node.front;
			}else {
				node = node.back;
			}
			now++;
		}
		
		Node f = node.front;
		Node b = node.back;
		Node nw = new Node(val,f,b);
		f.back = nw;
		b.front = nw;
		this.size++;
		
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (this.size < index)
			return ;
		
		Node node = (index > (size/2))? this.tail:this.head;
		int direction = (index > (size/2))? -1 : 1;
		
		if(direction == -1) {
			index = this.size - index;
		}else {
			index = index-1;
		}
		
		int now = 0;
		
		while(node!=null && now < index) {
			if(direction==-1) {
				node = node.front;
			}else {
				node = node.back;
			}
			now++;
		}
		
		Node f = node.front;
		Node b = node.back;
		
		f.back = b;
		b.front = f;
		this.size--;
		
	}

	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.addAtHead(1);
		print(obj.head);
		obj.addAtTail(3);
		print(obj.head);
		obj.addAtTail(4);
		print(obj.head);
		obj.addAtTail(3);
		print(obj.head);
		obj.addAtIndex(1, 2);    // linked list becomes 1->2->3
		obj.get(1);              // return 2
		obj.deleteAtIndex(1);    // now the linked list is 1->3
		obj.get(1);              // return 3
		
		
	}
	
	public static void print(Node node) {
		Node n = node;
		
		while(n!=null) {
			System.out.print(n.value + " -> ");
			n = n.back;
		}
		System.out.println();
		
	}

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */