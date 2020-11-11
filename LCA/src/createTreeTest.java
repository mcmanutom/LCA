import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
 
public class createTreeTest {
 
	@Test
	public void testTreeNotNull() {
		BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 					//         1
        tree.root.left = new Node(5); 				//		/    \
        tree.root.right = new Node(8); 				// 	   5	  8
        tree.root.left.left = new Node(2); 			//	  / \    / \
        tree.root.left.right = new Node(10); 		//    2  10  6  12
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(12);
        assertNotNull(tree.root);	
	}
	
	@Test
	public void testLCA() {
		BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 					//         1
        tree.root.left = new Node(5); 				//		/    \
        tree.root.right = new Node(8); 				// 	   5	  8
        tree.root.left.left = new Node(2); 			//	  / \    / \
        tree.root.left.right = new Node(10); 		//    2  10  6  12
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(12);
        int test = 5;
        assertEquals(tree.findLCA(2,10).value, test);	
	}
	
	@Test
	public void testLCARoot() {
		BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 					//         1
        tree.root.left = new Node(5); 				//		/    \
        tree.root.right = new Node(8); 				// 	   5	  8
        tree.root.left.left = new Node(2); 			//	  / \    / \
        tree.root.left.right = new Node(10); 		//    2  10  6  12
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(12);
        int test = 1;
        assertEquals(tree.findLCA(2,12).value, test);	
	}
	@Test
	public void testLCAIsNode() {
		BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 					//         1
        tree.root.left = new Node(5); 				//		/    \
        tree.root.right = new Node(8); 				// 	   5	  8
        tree.root.left.left = new Node(2); 			//	  / \    / \
        tree.root.left.right = new Node(10); 		//    2  10  6  12
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(12);
        int test = 5;
        assertEquals(tree.findLCA(5,10).value, test);	
	}
	
	@Test
	public void testDagLowestCommonAncestor()
	{
		LCADAG dag = new LCADAG(5);
		
		dag.addEdge(0, 1);
		dag.addEdge(0, 2);
		dag.addEdge(2, 3);
		dag.addEdge(3, 4);
		
		ArrayList<Integer> expectedResult = new ArrayList<Integer>();
		expectedResult.add(0);
				
		assertTrue(dag.lowestCommonAncestor(4,1).size() == expectedResult.size());
		for(int i : expectedResult)
		{
			assertTrue(dag.lowestCommonAncestor(4,1).contains(i));
		}
	}	
		//testing a dag that returns multiple lca
		@Test
		public void testMultipleLCA()
		{
			LCADAG dag = new LCADAG(7);
			dag.addEdge(0, 3);			
			dag.addEdge(1, 3);
			dag.addEdge(1, 4);
			dag.addEdge(2, 5);
			dag.addEdge(2, 6);
			dag.addEdge(3, 5);
			dag.addEdge(3, 6);
			dag.addEdge(4, 6);
			
			ArrayList<Integer> expectedResult = new ArrayList<Integer>();
			expectedResult.clear();
			expectedResult.add(2);
			expectedResult.add(3);
					
			assertTrue(dag.lowestCommonAncestor(5,6).size() == expectedResult.size());
			for(int i : expectedResult)
			{
				assertTrue(dag.lowestCommonAncestor(5,6).contains(i));
			}
					
		}
	}
