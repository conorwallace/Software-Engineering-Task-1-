import BST.Node;

public class Binary_Tree<Key extends Comparable<Key>, Value> {
		    private Node root;             // root of BST

		    /**
		     * Private node class.
		     */
		    private class Node {
		        private Key key;           // sorted by key
		        private Value val;         // associated data
		        private Node left, right;  // left and right subtrees
		        private int N;             // number of nodes in subtree

		        public Node(Key key, Value val, int N) {
		            this.key = key;
		            this.val = val;
		            this.N = N;
		        }
		     
		    }
		    
		    public int size(){
				return size(root);
			}
			
			public int size(Node x){
				if(x==null){
					return 0;
				}else{
					return x.N;
				}
			}
		    
		    // method to enter data into the BST
		    
		    public void put(Key key, Value val) {
		       
		        root = put(root, key, val);
		    }

		    private Node put(Node x, Key key, Value val) {
		    	
		        if (x == null) return new Node(key, val, 1);
		        int cmp = key.compareTo(x.key);
		        if      (cmp < 0) x.left  = put(x.left,  key, val);
		        else if (cmp > 0) x.right = put(x.right, key, val);
		        else              x.val   = val;
		        x.N = 1 + size(x.left) + size(x.right);
		        return x;
		    }
		    
		    
		    
		    // method to find the Lowest Common Ancestor
		    public class lowestCommonAncestor
		    {
		    	Node root;
		    	
		    	boolean F1 = false;
		    	boolean F2 = false;
		    	
		    	Node findLowestCommonAncestor(int n1 ,int n2)
		    	{
		    		Node lac = findLCA(root,n1,n2);
		    		
		    		if (F1 && F2)
		    		{
		    			return lac;
		    		}
		    		
		    		return lac;
		    	}
		    	
		    	private Node findLCA(Node node, int n1, int n2)
		    	{
		    		if(node == null)
		    		{
		    			return null;
		    			
		    		}
		    		
		    		if(this.node.val == n1)
		    		{
		    			
		    		}
		    	}
		    	
		    	
		    }

	}


