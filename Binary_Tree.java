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
		    	
		    }

	}


