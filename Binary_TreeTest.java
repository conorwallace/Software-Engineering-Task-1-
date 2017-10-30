import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class Binary_TreeTest {
	

	@Test
	public void testTwoNodes(){
		
		Binary_Tree tree = new Binary_Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(9);
		assertEquals("LCA(1, 9)",1,tree.findLCA(1, 9));
	}

	@Test
	public void testForEmptyTree(){
		Binary_Tree treeEmpty = new Binary_Tree();
		assertEquals("LCA(Empty)",-1,treeEmpty.findLCA(0, 0));
		assertEquals("LCA(Empty)",-1,treeEmpty.findLCA(1, 0));
	}
	
	@Test
	public void testAncestorNode(){
		Binary_Tree treeAncestorNode = new Binary_Tree();
		treeAncestorNode.root = new Node(10);
		treeAncestorNode.root.left = new Node(3);
		treeAncestorNode.root.right = new Node(13);
		treeAncestorNode.root.left.left = new Node(2);
		treeAncestorNode.root.left.right = new Node(8);
		treeAncestorNode.root.right.left = new Node(11);
        treeAncestorNode.root.right.right = new Node(30);
		
        
        //Test when one is the ancestor
        assertEquals("LCA(2,11)",10,treeAncestorNode.findLCA(2, 11));
        assertEquals("LCA(3,13)", 10,treeAncestorNode.findLCA(3, 13));
        assertEquals("LCA(2,8)", 3,treeAncestorNode.findLCA(2, 8));
        assertEquals("LCA(10,10)", 10,treeAncestorNode.findLCA(10, 10));
	}
	
	
	
	@Test
	public void testForTreeSize1(){
		Binary_Tree treeSize1 = new Binary_Tree();
		treeSize1.root = new Node(6);
		assertEquals("LCA(6,0)",-1,treeSize1.findLCA(6, 0));
		
		//Same node in twice then it should be ancestor
		assertEquals("LCA(6,6)",6,treeSize1.findLCA(6, 6));
	}
	
	@Test
	public void testForTreeSize7(){
		Binary_Tree treeSize7 = new Binary_Tree();
		treeSize7.root = new Node(1);
		treeSize7.root.left = new Node(2);
		treeSize7.root.right = new Node(3);
		treeSize7.root.left.left = new Node(4);
		treeSize7.root.left.right = new Node(5);
		treeSize7.root.right.left = new Node(6);
		treeSize7.root.right.right = new Node(7);
        
        assertEquals("LCA(4,5)", 2,treeSize7.findLCA(4, 5));
        assertEquals("LCA(4,6)", 1,treeSize7.findLCA(4, 6));
        assertEquals("LCA(3,4)", 1,treeSize7.findLCA(3, 4));
        assertEquals("LCA(6,7)", 3,treeSize7.findLCA(6, 7));
        assertEquals("LCA(5,6)", 1,treeSize7.findLCA(5, 6));
	}
	
	@Test
	public void testForTreeSize15(){
		Binary_Tree treeSize15 = new Binary_Tree();
		treeSize15.root = new Node(1);
		treeSize15.root.left = new Node(2);
		treeSize15.root.right = new Node(3);
		treeSize15.root.left.left = new Node(4);
		treeSize15.root.left.right = new Node(5);
		treeSize15.root.right.left = new Node(6);
		treeSize15.root.right.right = new Node(7);
		treeSize15.root.left.left.left = new Node(8);
		treeSize15.root.left.left.right = new Node(9);
		treeSize15.root.left.right.left = new Node(10);
		treeSize15.root.left.right.right = new Node(11);
		treeSize15.root.right.left.left = new Node(12);
		treeSize15.root.right.left.right = new Node(13);
		treeSize15.root.right.right.left = new Node(14);
		treeSize15.root.right.right.right = new Node(15);
		
		assertEquals("LCA(12,13)", 6,treeSize15.findLCA(12, 13));
        assertEquals("LCA(8,15)", 1,treeSize15.findLCA(8, 15));
        assertEquals("LCA(9,11)", 2,treeSize15.findLCA(9, 11));
        assertEquals("LCA(2,15)", 1,treeSize15.findLCA(2, 15));
        assertEquals("LCA(10,11)", 5,treeSize15.findLCA(10, 11)); 
	}
	
	
	@Test
	public void NonExistingNodes(){
		Binary_Tree treeNonExistentNode = new Binary_Tree();
		treeNonExistentNode.root = new Node(1);
		treeNonExistentNode.root.left = new Node(2);
		treeNonExistentNode.root.right = new Node(3);
		treeNonExistentNode.root.left.left = new Node(4);
		treeNonExistentNode.root.left.right = new Node(5);
		treeNonExistentNode.root.right.left = new Node(6);
        treeNonExistentNode.root.right.right = new Node(7);
         
        //Check returns -1 for non existing nodes
        assertEquals("LCA(-4,44)",-1,treeNonExistentNode.findLCA(-4, 44));
        assertEquals("LCA(8,8)",-1,treeNonExistentNode.findLCA(8, 8));
        assertEquals("LCA(21,100)",-1,treeNonExistentNode.findLCA(21, 100));
	}
	
	@Test
	public void testOneNode() {
		DAG oneNode = new DAG();
		oneNode.root = new Node(1);
		assertEquals("The lowest common ancestor of a tree with one node", -1,
				oneNode.LowestCommonAncestorBinaryTree(1, 0));
	}

	@Test
	public void testTwoNodes() {
		DAG twoNodes = new DAG();
		twoNodes.root = new Node(1);
		twoNodes.root.left = new Node(2);
		assertEquals("The lowest common ancestor of a tree with two nodes", 1,
				twoNodes.LowestCommonAncestorBinaryTree(1, 2));

	
	
	
	
}
