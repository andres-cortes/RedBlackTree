
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
		System.out.println("Test Case 1");
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
		System.out.println("Test Case 2");
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
		System.out.println("Test Case 3");
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
		System.out.println("Test Case 4");
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
		System.out.println("Test Case 5");
		rbt = new RedBlackTree();
		rbt.insert("1");
		rbt.insert("a");
		rbt.insert("b");
		rbt.insert("c");
		rbt.insert("d");
		expected = "1abcd";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));

		// Test 6
		System.out.println("Test Case 6");
		rbt = new RedBlackTree();
		rbt.insert("1");
		rbt.insert("2");
		rbt.insert("3");
		rbt.insert("4");
		rbt.insert("5");
		expected = "12345";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));
		
		// Test 7
		System.out.println("Test Case 7");
		rbt = new RedBlackTree();
		rbt.insert("!");
		rbt.insert("@");
		rbt.insert("#");
		rbt.insert("$");
		rbt.insert("%");
		expected = "!#$%@";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));
		
		// Test 8
		System.out.println("Test Case 8");
		rbt = new RedBlackTree();
		rbt.insert("1");
		rbt.insert("1");
		rbt.insert("2");
		rbt.insert("2");
		rbt.insert("3");
		rbt.insert("3");
		rbt.insert("4");
		rbt.insert("4");
		expected = "1234";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));

		// Test 9
		System.out.println("Test Case 9");
		rbt = new RedBlackTree();
		rbt.insert("-1");
		rbt.insert("-2");
		rbt.insert("-3");
		rbt.insert("-4");
		rbt.insert("-5");
		expected = "-1-2-3-4-5";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));
		
		// Test 10
		System.out.println("Test Case 10");
		rbt = new RedBlackTree();
		rbt.insert("0");
		rbt.insert("0");
		rbt.insert("0");
		rbt.insert("0");
		rbt.insert("0");
		expected = "0";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));
		
		// Test 11
		System.out.println("Test Case 11");
		rbt = new RedBlackTree();
		rbt.insert("abcde");
		rbt.insert("a");
		expected = "aabcde";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));
		
		// Test 12
		System.out.println("Test Case 12");
		rbt = new RedBlackTree();
		rbt.insert("-2,147,483,647");
		rbt.insert("2,147,483,647");
		expected = "-2,147,483,647,2,147,483,647";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));
		
		
		// Test 13
		System.out.println("Test Case 13");
		rbt = new RedBlackTree();
		rbt.insert("apple");
		rbt.insert("banana");
		rbt.insert("orange");
		rbt.insert("a");
		rbt.insert("b");
		rbt.insert("c");
		expected = "a, apple, banana, c, orange";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));
		
		// Test 14
		System.out.println("Test Case 14");
		rbt = new RedBlackTree();

		expected = " ";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));
		
		// Test 15
		System.out.println("Test Case 15");
		rbt = new RedBlackTree();
		rbt.insert("0.1 ");
		rbt.insert("0.2 ");
		rbt.insert("0.3 ");
		rbt.insert("0.4 ");
		rbt.insert("0.5 ");
		expected = "0.1, 0.2, 0.3, 0.4, 0.5";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));
		
		// Test 16
		System.out.println("Test Case 16");
		rbt = new RedBlackTree();
		rbt.insert("a ");
		rbt.insert("b");
		rbt.insert("3 ");
		rbt.insert("4 ");
		expected = "a,b,3,4";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));
		
		// Test 17
		System.out.println("Test Case 17");
		rbt = new RedBlackTree();
		rbt.insert("()");
		rbt.insert("*");
		rbt.insert("3 ");
		rbt.insert("4 ");
		expected = "3,4,(),*";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));
		
		// Test 18
		System.out.println("Test Case 18");
		rbt = new RedBlackTree();
		rbt.insert(" ");
		rbt.insert("a");
		rbt.insert("3 ");

		expected = " 3 a";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));
		
		// Test 19
		System.out.println("Test Case 19");
		rbt = new RedBlackTree();
		rbt.insert("3/5/2019");
		rbt.insert("4/8/2018");

		expected = "3/5/2019,4/8/2018";
		System.out.println("Expected: " + expected + ", Actual: " + makeOrderedString(rbt));
		

		
		

	}
}
