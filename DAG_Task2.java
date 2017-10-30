
import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	ArrayList<Node> parentNodes;
	Node left;
	Node right;

	Node(int value) {
		data = value;
		parentNodes = new ArrayList<Node>();
		left = right;
		left = null;
		right = null;
	}
}
public class DAG_Task2 {
	
	
	}


