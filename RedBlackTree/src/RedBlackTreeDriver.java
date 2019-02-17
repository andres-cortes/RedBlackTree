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
		// tests here**************************************
		String expected;
		// Test 1
		RedBlackTree rbt = new RedBlackTree();
		rbt.insert("a");
		rbt.insert("b");
		rbt.insert("c");
		rbt.insert("d");
		rbt.insert("e");
		rbt.insert("f");
		expected = "abcdef";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));

		// Test 2
		rbt = new RedBlackTree();
		rbt.insert("a");
		rbt.insert("b");
		rbt.insert("c");
		rbt.insert("d");
		rbt.insert("e");
		rbt.insert("f");
		rbt.insert("g");
		rbt.insert("h");
		rbt.insert("i");
		rbt.insert("j");
		rbt.insert("k");
		rbt.insert("l");
		rbt.insert("m");
		expected = "abcdefghijklm";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));

		// Test 3
		rbt = new RedBlackTree();
		rbt.insert("c");
		rbt.insert("e");
		rbt.insert("f");
		rbt.insert("a");
		rbt.insert("b");
		rbt.insert("d");
		expected = "abcdef";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));

		// Test 4
		rbt = new RedBlackTree();
		rbt.insert("f");
		rbt.insert("e");
		rbt.insert("d");
		rbt.insert("c");
		rbt.insert("b");
		rbt.insert("a");
		expected = "abcdef";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));

		// Test 5
		rbt = new RedBlackTree();
		rbt.insert("1");
		rbt.insert("a");
		rbt.insert("b");
		rbt.insert("c");
		rbt.insert("d");
		expected = "1abcd";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));

		// Test 6
		rbt = new RedBlackTree();
		rbt.insert("1");
		rbt.insert("2");
		rbt.insert("3");
		rbt.insert("4");
		rbt.insert("5");
		expected = "12345";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));

	}
}
