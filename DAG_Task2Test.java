import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DAG_Task2Test {
	
	//Following tests check Directed Graph class works correctly
	@Test
	public void testForDirectedGraph(){
		DAG_Task2 test = new DAG_Task2(12);
		test.addEdge(1, 2);
		test.addEdge(1, 4);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);
		
		assertEquals("", 2, test.indegree(4));
		assertEquals("", 2, test.outdegree(4));
		assertEquals("Number of edges should be 5", 5, test.E());
		assertEquals("Number of vertices should be 12", 12, test.V());
		String ans = "[5, 6]";
		assertEquals("",ans, test.adj(4).toString());
	}
	
	
	
	@Test
	public void testinDegree(){
		DAG_Task2 test3 = new DAG_Task2(5);
		test3.addEdge(0, 1);
		test3.addEdge(0, 2);
		test3.addEdge(1, 2);
		
		assertEquals("", -1, test3.indegree(-3));
		assertEquals("", 1, test3.indegree(1));
		assertEquals("", 2, test3.indegree(2));
	}
	
	@Test
	public void testOutDegree(){
		DAG_Task2 test4 = new DAG_Task2(5);
		test4.addEdge(0, 1);
		test4.addEdge(0, 2);
		test4.addEdge(1, 2);
		
		assertEquals("", -1, test4.outdegree(8));	
		assertEquals("", 2, test4.outdegree(0));	
		assertEquals("", 0, test4.outdegree(2));	
	}
	
	@Test
	public void testAddEdge(){
		DAG_Task2 test2 = new DAG_Task2(8);
		//This edge should add
		test2.addEdge(0, 1);
		test2.addEdge(1, 2);
		assertEquals("", 1, test2.indegree(1));
		
		//This should print message to console and have no effect
		test2.addEdge(-2, -5);
		
		//This should not either as 9>8 
		test2.addEdge(10, 11);
		assertEquals("Number of edges should be 2", 2, test2.E());
	}
	
	@Test(expected=Exception.class)
	public void exceptionTest(){
		//Can't make a directed graph with less than 0 vertices
		DAG_Task2 test3 = new DAG_Task2(-5);
	}
	
	
	
	
	
	//Following tests check Directed ACYCLIC Graph class works correctly
	@Test
	public void testsForCycle(){
		DAG_Task2 cyclic = new DAG_Task2(20);
			cyclic.addEdge(0, 1);
			cyclic.addEdge(1, 2);
			cyclic.addEdge(2, 0);
			cyclic.addEdge(2, 3);
			cyclic.addEdge(3, 4);
			
			//Parameter is first vertex
			cyclic.findCycle(0);
			
			//Cycle from 2-0
			assertTrue(cyclic.hasCycle());
	}
	
	@Test
	public void testForAcyclicGraph(){
		DAG_Task2 acyclic = new DAG_Task2(20);
			acyclic.addEdge(0, 1);
			acyclic.addEdge(1, 2);
			acyclic.addEdge(2, 3);
			//Parameter is first vertex
			acyclic.findCycle(0);
			assertFalse(acyclic.hasCycle());
	}

	
	
	//Following tests check the LCA function for a DAG graph
	@Test
	public void testLCA(){
		DAG_Task2 lca = new DAG_Task2(10);
		
		//--------2---5----7--
		//---0--1-------6----8
		//--------3---4-------
		lca.addEdge(0, 1);
		lca.addEdge(1, 2);
		lca.addEdge(1, 3);
		lca.addEdge(2, 5);
		lca.addEdge(3, 4);
		lca.addEdge(4, 6);
		lca.addEdge(5, 6);
		lca.addEdge(6, 8);
		lca.addEdge(5, 7);
		lca.addEdge(7, 8);
		
		assertEquals("", 1, lca.findLCA(5, 4));
		assertEquals("", 7, lca.findLCA(8, 7));
		assertEquals("", 6, lca.findLCA(6, 8));
	}
	
	@Test
	public void testLCAForNoCommonAncestors(){
		DAG_Task2 lca2 = new DAG_Task2(11);
		lca2.addEdge(0, 1);
		lca2.addEdge(0, 2);
		lca2.addEdge(1, 2);
		lca2.addEdge(2, 3);
		lca2.addEdge(3, 4);
		lca2.addEdge(1, 5);
		lca2.addEdge(3, 5);
		
		//Check it works ok
		assertEquals("", 0, lca2.findLCA(3, 1));
		assertEquals("", 2, lca2.findLCA(3, 2));
		assertEquals("", 3, lca2.findLCA(4, 5));
		
		//Check for no common ancestors
		assertEquals("", -1, lca2.findLCA(7, 3));
	}
	
	@Test
	public void testLCAForSameVertex(){
		DAG_Task2 lca3 = new DAG_Task2(11);
		lca3.addEdge(0, 1);
		lca3.addEdge(0, 2);
		lca3.addEdge(1, 2);
		
		assertEquals("", 2, lca3.findLCA(2, 2));
	}
	
	@Test
	public void testLCAForNonDAG(){
		DAG_Task2 lca3 = new DAG_Task2(11);
		lca3.addEdge(0, 1);
		lca3.addEdge(0, 2);
		lca3.addEdge(2, 3);
		lca3.addEdge(3, 0);
		lca3.addEdge(3, 4);
		
		//Should return -1 if graph is not a DAG
		assertEquals("", -1, lca3.findLCA(2, 3));
		assertEquals("", -1, lca3.findLCA(3, 4));
		assertEquals("", -1, lca3.findLCA(1, 2));
		assertEquals("", -1, lca3.findLCA(0, 3));
		assertEquals("", -1, lca3.findLCA(1, 3));

	}
	
	@Test
	public void testLCAForEmptyDAG(){
		DAG_Task2 lca4 = new DAG_Task2(5);
		assertEquals("", -1, lca4.findLCA(0, 2));
		assertEquals("", -1, lca4.findLCA(0, 0));
		assertEquals("", -1, lca4.findLCA(0, 3));
		
	}
}