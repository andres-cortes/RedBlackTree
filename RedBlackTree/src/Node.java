/**
 * Models a node from a Red-Black Tree. Each node has a parent node and a left
 * child and right child Node
 * 
 * @author
 *
 * @param <Key>
 *            The type of data to be contained within the node
 */
public class Node<Key extends Comparable<Key>>
{

	private Key key;
	private Node<Key> parent;
	private Node<Key> leftChild;
	private Node<Key> rightChild;
	private boolean isRed;

	public Node(Key data)
	{
		parent = null;
		this.key = data;
		leftChild = null;
		rightChild = null;
		isRed = true;
	}

	public Node<Key> getParent()
	{
		return parent;
	}

	public Node<Key> getLeftChild()
	{
		return leftChild;
	}

	public Node<Key> getRightChild()
	{
		return rightChild;
	}

	public int compareTo(Node<Key> n)
	{ // this < that <0
		return key.compareTo(n.key); // this > that >0
	}

	public Key getData()
	{
		return key;
	}

	public boolean isRed()
	{
		return isRed;
	}

	public int getColor()
	{
		if (isRed)
			return 0;
		return 1;
	}

	public void setRed()
	{
		isRed = true;
	}

	public void setBlack()
	{
		isRed = false;
	}

	public void setLeftChild(Node<Key> n)
	{
		leftChild = n;
		n.parent = this;

	}

	public void setRightChild(Node<Key> n)
	{
		rightChild = n;
		n.parent = this;

	}

	public void setParent(Node<Key> n)
	{
		parent = n;
	}

	/*
	 * public boolean isLeaf() { if (this.equals(root) && this.leftChild == null &&
	 * this.rightChild == null) return true; if (this.equals(root)) return false; if
	 * (this.leftChild == null && this.rightChild == null) { return true; } return
	 * false; }
	 */
}
