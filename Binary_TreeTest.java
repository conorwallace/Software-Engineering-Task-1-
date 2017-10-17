import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class Binary_TreeTest {

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
        assertEquals("LCA(2,10)", 10,treeAncestorNode.findLCA(2, 10));
        assertEquals("LCA(10,10)", 10,treeAncestorNode.findLCA(10, 10));
	}
	
}
