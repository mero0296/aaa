package JAVA;

import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTreeTest {
    Node root;

    BinarySearchTreeTest() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeTest tree = new BinarySearchTreeTest();

        int a;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Binary Search Tree'nin kaç değer olacağını girin: ");
        
        a = scanner.nextInt();
        int arr[] = new int[a];

        System.out.print("Binary Search Tree için değerleri girin: ");

        for (int i = 0; i < arr.length; i++) {

            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {

            tree.insert(arr[i]);
        }

        System.out.println("Ağacın sırayla geçişi:");
        tree.inorder();
    }
}
