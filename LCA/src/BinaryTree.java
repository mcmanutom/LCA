import java.util.ArrayList;
import java.util.List;

public class BinaryTree 
	{ 
	    //Root of the Binary Tree 
	    Node root; 
	    Node findLCA(int n1, int n2) 
	    { 
	        return findLCA(root, n1, n2); 
	    } 
	  
	    //Find the LCA
	    Node findLCA(Node node, int n1, int n2) 
	    { 
	        // if null no node
	        if (node == null) 
	        {
	            return null; 
	        }
	        
	        if (node.value == n1 || node.value == n2) 
	        {
	            return node; 
	        }
	        
	        Node left_lca = findLCA(node.left, n1, n2); //Checks left subtree for node 
	        Node right_lca = findLCA(node.right, n1, n2); //Checks right subtree for node
	  
	        if (left_lca!=null && right_lca!=null)
	        {
	            return node; 
	        }
	        
	        return (left_lca != null) ? left_lca : right_lca; 
	    }
	    
	    public static void main(String args[]) 
	    { 
	        BinaryTree tree = new BinaryTree(); 
	        tree.root = new Node(1); 					//         1
	        tree.root.left = new Node(5); 				//		/    \
	        tree.root.right = new Node(8); 				// 	   5	  8
	        tree.root.left.left = new Node(2); 			//	  / \    / \
	        tree.root.left.right = new Node(10); 		//    2  10  6  12
	        tree.root.right.left = new Node(6); 
	        tree.root.right.right = new Node(12); 
	        System.out.println("LCA(2, 10) = " +  tree.findLCA(2, 10).value); 
	        System.out.println("LCA(6, 12) = " +  tree.findLCA(6, 12).value); 
	        System.out.println("LCA(5, 8) = " +  tree.findLCA(5, 8).value); 
	        System.out.println("LCA(10, 6) = " +  tree.findLCA(10, 6).value); 
	    } 
}
