/**
 * Models a Red Black Tree of String Nodes
 * 
 * @author Andres Cortes
 *
 */
public class RedBlackTree
{
	private Node<String> root;

	public RedBlackTree()
	{
		root = null;
	}

	/**
	 * Checks if a provided node is a leaf
	 * 
	 * @param n
	 *            the node to check
	 * @return
	 */
	private boolean isLeaf(Node<String> n)
	{
		if (n.equals(root) && n.getLeftChild() == null && n.getRightChild() == null)
			return true;
		if (n.equals(root))
			return false;
		if (n.getLeftChild() == null && n.getRightChild() == null)
		{
			return true;
		}
		return false;
	}

	public interface Visitor
	{
		/**
		 * This method is called at each node.
		 * 
		 * @param n
		 *            the visited node
		 */
		void visit(Node<String> n);
	}

	/**
	 * Prints the contents of the tree in a preorder traversal
	 */

	public void printTree()
	{
		// preorder: visit, go left, go right Node<String>
		printTree(root);
	}

	public void printTree(Node<String> node)
	{
		System.out.print(node.getData());
		if (isLeaf(node))
		{
			return;
		}
		printTree(node.getLeftChild());
		printTree(node.getRightChild());
	}

	/**
	 * Adds a node to the RBT containing the provided data
	 * 
	 * @param data
	 *            the contents of the new node to be added
	 */
	public void insert(String data)
	{
		// note that duplicates are not allowed in this implementation
		boolean added = false;
		Node<String> newNode = new Node<>(data);
		// if rbt is empty, new node is the root
		if (root == null)
		{
			root = newNode;
			root.setBlack();
			Node<String> l = new Node<String>("");
			Node<String> r = new Node<String>("");
			l.setBlack();
			r.setBlack();
			root.setLeftChild(l);
			root.setRightChild(r);
			added = true;
		}
		// if rbt not empty, use algorithm in addNode to find a place for it
		else
		{
			added = addNode(newNode, root);
		}
		// at this point, node has been added.
		// check if RBT violated
		if (added)
			fixTree(newNode);
	}

	// place a new node in the RB tree with data the parameter and color it red.
	/**
	 * 
	 * @param insert
	 *            The node to add to the rbt
	 * @param current
	 *            The node to compare with insert (this is initially set as the root
	 *            in insert()
	 * @return if the node can be added (false if it is a duplicate)
	 */
	private boolean addNode(Node<String> insert, Node<String> current)
	{ // this < that <0. this > that >0
		// *********does not add duplicate items*********
		if (insert.getData().compareTo(current.getData()) > 0) // new node larger
		{
			if (isEmpty(current.getRightChild())) // found spot to add new node
			{
				current.setRightChild(insert);
				Node<String> l = new Node<String>("");
				Node<String> r = new Node<String>("");
				l.setBlack();
				r.setBlack();
				insert.setLeftChild(l);
				insert.setRightChild(r);
				return true;
			}
			else // else, recursive on right
			{
				return addNode(insert, current.getRightChild());
			}
		}
		else if (insert.getData().compareTo(current.getData()) < 0) // else, smaller
		{
			if (isEmpty(current.getLeftChild())) // found spot to add new node
			{
				current.setLeftChild(insert);
				Node<String> l = new Node<String>("");
				Node<String> r = new Node<String>("");
				l.setBlack();
				r.setBlack();
				insert.setLeftChild(l);
				insert.setRightChild(r);
				return true;
			}
			else // else, recursive on left
			{
				return addNode(insert, current.getLeftChild());
			}
		}
		// if not less than or greater than the current node, then the nodes are equal.
		// This implementation does not allow for duplicates
		return false;

	}

	/**
	 * Returns the node containing the provided string. If no node is found, null is
	 * returned
	 * 
	 * @param k
	 *            the string to be searched for
	 * @return the node containing the string, or null if no node was found
	 */
	public Node<String> lookup(String k)
	{
		// fill
		Node<String> current = root;

		while (current != null)
		{
			if (current.getData().equals(k))
			{
				return current;
			}
			if (k.compareTo(current.getData()) > 0)
			{
				current = current.getRightChild();
			}
			else
			{
				current = current.getLeftChild();
			}
		}
		return null;
	}

	/**
	 * Returns the "aunt"/"uncle" of the node (the parent's sibling)
	 * 
	 * @param n
	 *            the node to get the aunt of
	 * @return the aunt
	 */
	private Node<String> getAunt(Node<String> n)
	{
		if (n == root || n.getParent() == root)
		{
			return null;
		}
		if (n.getParent() == getGrandparent(n).getLeftChild())
		{
			return getGrandparent(n).getRightChild();
		}
		return getGrandparent(n).getLeftChild();
	}

	/**
	 * Returns the "grandparent" of the node (the parent's parent)
	 * 
	 * @param n
	 *            the node to get the grandparent of
	 * @return the grandparent
	 */
	private Node<String> getGrandparent(Node<String> n)
	{
		return n.getParent().getParent();
	}

	/**
	 * Rotates the subtree left around x
	 * 
	 * @param x
	 */
	private void rotateLeft(Node<String> x)
	{
		Node<String> y = x.getRightChild(); // define y

		x.setRightChild(y.getLeftChild()); // x's Right is now y's left
		// set parent in setRightChild()
		y.setParent(x.getParent()); // link y to x's parent
		if (x.getParent() == null) // root case
		{
			root = y;
		}
		else if (x == x.getParent().getLeftChild()) // left case
		{
			x.getParent().setLeftChild(y);
		}
		else // right case
		{
			x.getParent().setRightChild(y);
		}
		y.setLeftChild(x); // y's left child is x
	}

	/**
	 * Rotates the subtree right around y
	 * 
	 * @param y
	 */
	private void rotateRight(Node<String> y)
	{
		Node<String> x = y.getLeftChild();

		y.setLeftChild(x.getRightChild());

		x.setParent(y.getParent());
		if (y.getParent() == null)
		{
			root = x;
		}
		else if (y == y.getParent().getLeftChild())
		{
			y.getParent().setLeftChild(x);
		}
		else
		{
			y.getParent().setRightChild(x);
		}
		x.setRightChild(y);
	}

	/**
	 * Checks the validity of the provided node's position in the tree. Fixes the
	 * tree if it is not valid
	 * 
	 * @param current
	 *            the node to assert the validity of
	 */
	private void fixTree(Node<String> current)
	{
		if (current != root && current.getParent().isRed())
		{
			// case 1 + symmetrical
			Node<String> aunt = getAunt(current);
			if (aunt.isRed())
			{
				current.getParent().setBlack();
				aunt.setBlack();
				getGrandparent(current).setRed();
				current = getGrandparent(current);
				root.setBlack();
				fixTree(current);
				return;
			}
			// case 2
			else if (current == current.getParent().getRightChild()
					&& current.getParent() == getGrandparent(current).getLeftChild())
			{
				current = current.getParent();
				rotateLeft(current);
			}
			// case 2 symmetrical
			else if (current == current.getParent().getLeftChild()
					&& current.getParent() == getGrandparent(current).getRightChild())
			{
				current = current.getParent();
				rotateRight(current);
			}
			// case 3
			if (current == getGrandparent(current).getLeftChild().getLeftChild())
			{
				current.getParent().setBlack();
				getGrandparent(current).setRed();
				rotateRight(getGrandparent(current));
				root.setBlack();
				fixTree(current);
				return;
			}

			// case 3 symmetrical
			if (current == getGrandparent(current).getRightChild().getRightChild())
			{
				current.getParent().setBlack();
				getGrandparent(current).setRed();
				rotateLeft(getGrandparent(current));
				root.setBlack();
				fixTree(current);
				return;
			}
		}

	}

	/**
	 * Checks if child is parent's left child
	 * 
	 * @param parent
	 * @param child
	 * @return
	 */
	/*
	 * public boolean isLeftChild(Node<String> parent, Node<String> child) { if
	 * (child.compareTo(parent) < 0) {// child is less than parent return true; }
	 * return false; }
	 */

	/**
	 * Returns if the node is contains an empty string (NOT NULL)
	 * 
	 * @param n
	 * @return
	 */
	private boolean isEmpty(Node<String> n)
	{
		if (n.getData() == "")
		{
			return true;
		}
		return false;
	}

	/**
	 * Visits the RBT in a preorder traversal
	 * 
	 * @param v
	 *            the visitor
	 */
	public void preOrderVisit(Visitor v)
	{
		preOrderVisit(root, v);
	}

	private static void preOrderVisit(Node<String> n, Visitor v)
	{
		if (n == null)
		{
			return;
		}
		v.visit(n);
		preOrderVisit(n.getLeftChild(), v);
		preOrderVisit(n.getRightChild(), v);
	}

	/**
	 * Visits the RBT in an inorder traversal
	 * 
	 * @param v
	 *            the visitor
	 */
	public void inOrderVisit(Visitor v)
	{
		inOrderVisit(root, v);
	}

	private static void inOrderVisit(Node<String> n, Visitor v)
	{
		if (n == null)
		{
			return;
		}
		inOrderVisit(n.getLeftChild(), v);
		v.visit(n);
		inOrderVisit(n.getRightChild(), v);
	}
}
