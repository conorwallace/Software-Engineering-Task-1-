import static org.junit.Assert.*;

import org.junit.Test;

public class DAG_Task2Test {

	
	
	@Test
	public void testEmptyTree() {
		DAG_Task2 emptyTree = new DAG_Task2();
		assertEquals("The lowest common ancestor of an empty tree", -1, emptyTree.LowestCommonAncestorBinaryTree(0, 0));
	}

	@Test
	public void testOneNode() {
		DAG_Task2 oneNode = new DAG_Task2();
		oneNode.root = new Node(1);
		assertEquals("The lowest common ancestor of a tree with one node", -1,
				oneNode.LowestCommonAncestorBinaryTree(1, 0));
	}

	@Test
	public void testTwoNodes() {
		DAG_Task2 twoNodes = new DAG_Task2();
		twoNodes.root = new Node(1);
		twoNodes.root.left = new Node(2);
		assertEquals("The lowest common ancestor of a tree with two nodes", 1,
				twoNodes.LowestCommonAncestorBinaryTree(1, 2));
	}
	

}
