# RedBlackTree
### For CS 146 Data Structures and Algorithms at SJSU

###The project description is as follows:

In this project you will create a Dictionary, aka a Red Black Tree. Using the provided link to a
dictionary, insert all the words in a Red Black Tree. Create a new file with a poem and use the
dictionary as a spell checker for your poem. A spell checker just calls lookups to the dictionary to see if
a word exists. Count the time to create the dictionary and the time for spell checking.

In a Red Black tree the longest path from the root to a leaf cannot be more than twice of the
shortest path from the root to a leaf. This means that the tree is always balanced and the operations are
always O(lgn). Since a Red Black Tree is a binary search tree, the following property must be true: the value in every
node is larger than the value of the left child (or any value in the left subtree) and smaller than the value
of the right child (or any value in the right subtree). Additionally, a Red Black Tree has these properties:
1. Every node is either red or black
2. Every leaf (NULL pointer) is black
3. If a node is red, both children are black
4. Every path from node to descendent leaf contains the same number of black nodes
5. The root is always black 
