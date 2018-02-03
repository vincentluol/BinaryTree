import java.util.Random;

public class Tree<T extends Comparable <T>> {
	public class Node {
		private T key;
		private Object data;
		private Node left;
		private Node right;
		private Node(T key, Object data){
			this.key = key;
			this.data = data;
		}
	}
	private Node root;

//	public void insertRandom(){
//		Random rand = new Random();
//		for (int i = 0; i < 100000; i++){
//			int n = rand.nextInt();
////			if (getData(n) == null)
//				insert((Math.abs(n)), Integer.toString(n));
//		}
//	}

	public void insert(T key, Object data) {
		Node parent = null;
		Node trav = root;
		while (trav != null) { 
			parent = trav;
			if(trav.key.compareTo(key) > 0)
				trav = trav.left;
			else
				trav = trav.right;
		}
		Node newNode = new Node(key, data);
		if (root == null) // the tree was empty
			root = newNode;
		else if (key.compareTo(parent.key)<0)
			parent.left = newNode;
		else
			parent.right = newNode;
	}
	
	
	public void inorderPrint() {
		if (root != null)
			inorderPrintTree(root);
	}

	private void inorderPrintTree(Node root) {
		if (root != null) {
			inorderPrintTree(root.left);
			System.out.println(root.key + " ");
			inorderPrintTree(root.right);
		}
	}
	
	public int numNodes(){
		if (root != null)
			return numNodes(root);
		else
			return 0;
	}

	private int numNodes(Node root){
		int count = 1;
		if (root.left != null)
			count += numNodes(root.left);
		if (root.right != null)
			count += numNodes(root.right); 
		return count;
	}

	public T highestNumber(){
		if (root != null)
			return highestNumber(root);
		else
			return null;
	}

	private T highestNumber(Node root){
		if (root.right != null)
			return highestNumber(root.right);
		else
			return root.key;
	}

	public int printHeight(){
		if (root != null)
			return height(root);
		else
			return 0;
	}

	private int height(Node root){
		if (root == null || (root.left == null && root.right == null))
			return 0; 
		int heightLeft = height(root.left);
		int heightRight = height(root.right);

		if(heightLeft > heightRight)
			return heightLeft + 1;
		else
			return heightRight + 1;	
	}

	public Object getData(T key){
		return (getData(root, key));
	}

	private Object getData(Node root, T key){
		if (root == null)
			return null;
		else if (key.compareTo(root.key) > 0)
			return getData(root.right, key);
		else if (key.compareTo(root.key) < 0)
			return getData(root.left, key);
		else 
			return root.data;
	}

}
