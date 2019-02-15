public class RedBlackTreeDriver
{
	public static String makeOrderedString(RedBlackTree t)
	{
		class MyVisitor implements RedBlackTree.Visitor
		{
			String result = "";

			public void visit(Node<String> n)
			{
				result = result + n.getData();
			}
		}
		;
		MyVisitor v = new MyVisitor();
		t.inOrderVisit(v);
		return v.result;
	}

	public static String makeStringDetails(RedBlackTree t)
	{
		{
			class MyVisitor implements RedBlackTree.Visitor
			{
				String result = "";

				public void visit(Node<String> n)
				{
					if (n.getData() != "")
					{
						result = result + n.getData() + n.getColor() + " ";
					}
				}
			}
			;
			MyVisitor v = new MyVisitor();
			t.preOrderVisit(v);
			return v.result;
		}
	}

	public static void main(String[] args)
	{
		// tests here
		RedBlackTree rbt = new RedBlackTree();
		// added letters: abcdefghi
		rbt.insert("a");
		rbt.insert("b");
		rbt.insert("a");
		rbt.insert("c");
		rbt.insert("d");
		rbt.insert("h");
		rbt.insert("g");
		rbt.insert("e");
		rbt.insert("f");
		rbt.insert("i");
		String expected = "abcdefghi";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));

		System.out.println("Found a: " + (rbt.lookup("a").getData() != null));
	}
}
