package dsa;
import java.util.*;
public class TreeDSA {
	public static void main(String args[]) {
		Node root = createTree();
		leftView(root);
		//System.out.println(height(root));
		//System.out.println(height(root));
		//System.out.println(max(root));
		//System.out.println(min(root));
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	static Scanner sc = new Scanner(System.in);
	public static Node createTree() {
		System.out.print("Enter Element - ");
		int e = sc.nextInt();
		if(e==-1) {
			return null;
		}
		Node newNode = new Node(e);
		System.out.println("\nEnter left of"+e);
		newNode.left=createTree();
		System.out.println("\nEnter right of"+e);
		newNode.right=createTree();
		return newNode;
		
	}
	
	public static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			Node currNode=q.poll();
			if(currNode==null) {
				if(q.isEmpty()) break;
				System.out.println();
				q.add(null);
				continue;
			}
			System.out.print(currNode.data);
			if(currNode.left!=null) {
				q.add(currNode.left);
			}
			if(currNode.right!=null) {
				q.add(currNode.right);
			}
		}
	}
	private static void leftView(Node root, int level, ArrayList<Integer> lw) {
		if(root==null) {
			return;
		}
		if(lw.get(level)==0) {
			lw.set(level, root.data);
		}
		leftView(root.left, level+1, lw);
		leftView(root.right, level+1, lw);
	}
	public static void leftView(Node root) {
		ArrayList<Integer> lw = new ArrayList<>();
		for(int i=0; i<height(root); i++) {
			lw.add(0);
		}
		leftView(root, 0, lw);
		for(int i=0; i<lw.size(); i++) {
			System.out.println(lw.get(i));
		}
	}
	public static void rightView() {
		
	}
	public static void topView() {
		
	}
	public static void bottomView() {
		
	}
	public static void preOrder(Node root) {
		if(root==null) return;
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void inOrder(Node root) {
		if(root==null) return;
		preOrder(root.left);
		System.out.println(root.data);
		preOrder(root.right);
	}
	
	public static void postOrder(Node root) {
		if(root==null) return;
		preOrder(root.left);
		preOrder(root.right);
		System.out.println(root.data);
	}
	
	public static int height(Node root) {
		if(root==null) return 0;
		return 1+Math.max(height(root.left), height(root.right));
	}
	
	public static int max(Node root) {
		if(root==null) return Integer.MIN_VALUE;
		return Math.max(root.data, Math.max(max(root.left), max(root.right)));
	}
	
	public static int min(Node root) {
		if(root==null) return Integer.MAX_VALUE;
		return Math.min(root.data, Math.min(min(root.left), min(root.right)));
		
	}
}
