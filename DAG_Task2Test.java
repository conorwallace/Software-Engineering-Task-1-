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
	
	
}