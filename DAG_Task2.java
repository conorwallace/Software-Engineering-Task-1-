
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DAG_Task2 {

	private ArrayList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
	private int[] indegree;        // indegree[v] = indegree of vertex v
	private boolean marked[];		//Boolean List to track visited vertices
	private boolean hasCycle;		//True if cycle in graph
    private boolean stack[];		//Order that vertices were visited
    private int V;           // number of vertices in this digraph
	private int E;                 // number of edges in this digraph

	// method to create a DAG with v number of nodes
    
	
	public DAG_Task2(int V)
	{
		if (V < 0) throw new IllegalArgumentException("Diagram can't have negative number of Vertices");
	    this.V = V;
	    this.E = 0;
	    indegree = new int[V];
	    marked = new boolean[V];
	    stack = new boolean[V];
	    adj = (ArrayList<Integer>[]) new ArrayList[V];
	    for (int v = 0; v < V; v++) 
	    {
	        adj[v] = new ArrayList<Integer>();
	    }              
	}

	//Returns current number of vertex
	public int V() 
	{
		return V;	
	}
	// returns current edges in the DAG
	public int E() 
	{
        return E;
    }

	
	
	//Adds a directed edge from v->w
	public void addEdge(int v, int w)
	{
	    if((validateVertex(v)==true)&&(validateVertex(w)==true))
	    {
	    	adj[v].add(w);
	    	indegree[w]++;
	    	E++;
	    }
	    else
	    {
	    	System.out.println("Please enter valid Vertex less than n");
	    }
	    	
	}
	
	private boolean validateVertex(int v) 
	{
        if (v < 0 || v >= V)
        {
        	return false;
        }
        else
        {
        	return true;
        }
        	
     }

	
	//Returns amount of directed edges pointing to vertex v
	public int indegree(int v) {
		if(validateVertex(v)==false){
			return -1;
		}
		else{
			return indegree[v];
		}
	}
	
	//Returns amount of directed edges pointing away from vertex v
	public int outdegree(int v) {
		if(validateVertex(v)==false){
			return -1;
		}
		else{
			return adj[v].size();
		}
    }
		
	
	//Returns the adjacent vertices to v
	public Iterable<Integer> adj(int v)
	{ return adj[v]; }
	
	
	// A DAG diagram is only valid if it doesnt have a cycle, following method computes if it does or doesn't
	public boolean hasCycle() {

        return hasCycle;
    }
	
	 public void findCycle(int v) {

	        marked[v] = true;
	        stack[v] = true;

	        for (int w : adj(v)) {
	            if(!marked[w]) {
	                findCycle(w);
	            } else if (stack[w]) {
	                hasCycle = true;
	                return;
	            }
	        }

	        stack[v] = false;
	    }
	}