import java.util.Scanner;

// Ağaçtaki düğümü ifade eden sınıf
class Node {
	public int data;
	public Node left, right;
	
	public Node(int newData) {
		data = newData;
		left = null;
		right = null;
	}
}

public class BinarySearchTree {
	static Node root;

	public BinarySearchTree() {
		root = null;
	}

	// Belli bir değere sahip düğümü arama fonksiyonu
	private boolean search(Node root, int data) {
		if(root == null)
			return false;
		else if(root.data == data)
			return true;
		
		if(data < root.data)
			return search(root.left, data);
		else
			return search(root.right, data);
	}

	// Değeriyle beraber yeni bir düğüm ekleme
	private Node insert(Node node, int data) {
		if(node == null)
			node = new Node(data);
		
		else {
			if(data < node.data)
				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
		}
		return node;
	}

	// Bir alt-ağaçtaki en küçük değeri bulma
	public Node minValueNode(Node node) {
		while(node.left != null)
			node = node.left;
		return node;
	}

	// Değeriyle birlikte bir düğümü silme
	private Node delete(Node root, int data) {
		if(root == null)
			return root;

		if(data < root.data)
			root.left = delete(root.left, data); 
		else if (data > root.data)
			root.right = delete(root.right, data);
		else {
			// Bir çocuğa sahip veya çocuğa sahip olmayan düğüm
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// İki çocuğa sahip düğüm
			Node temp = minValueNode(root.right);
			root.data = temp.data;
			root.right = delete(root.right, temp.data);
		}
		return root;
	}

	// Ağacı sıralı dolaşma yöntemiyle yazdıran fonksiyon
	void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree tree = new BinarySearchTree();
		
		root = tree.insert(root, 17);
		root = tree.insert(root, 3);
		root = tree.insert(root, 45);
		root = tree.insert(root, 54);
		root = tree.insert(root, 78);
		root = tree.insert(root, 91);
		root = tree.insert(root, 23);
		
		System.out.print("Your tree: ");
		tree.inOrderTraversal(root);
		System.out.println();
		
		System.out.print("\nSearh for an element: ");
		int element = sc.nextInt();
		System.out.println("Your element is " + ((tree.search(root, element) == true) ? "found" : "not found"));
		
		tree.delete(root, 23);
		System.out.print("\nYour tree after deleting 23: ");
		tree.inOrderTraversal(root);
		System.out.println();
	}
}
