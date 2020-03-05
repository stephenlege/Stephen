/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter25_trees_java;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Consumer;

public class BST<E> implements Tree<E> {

    protected TreeNode<E> root;
    protected int size = 0;
    protected java.util.Comparator<E> c;

    /**
     * Create a default BST with a natural order comparator
     */
    public BST() {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * Create a BST with a specified comparator
     */
    public BST(java.util.Comparator<E> c) {
        this.c = c;
    }

    /**
     * Create a binary tree from an array of objects
     */
    public BST(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    /**
     * Inorder traversal from the root
     */
    public void inorder() {
        inorder(root);
    }

    /**
     * Inorder traversal from a subtree without using recursion
     */
    protected void inorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        java.util.Stack<TreeNode<E>> stack = new java.util.Stack<>();
        TreeNode<E> current = root;
        while (!stack.empty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode<E> node = stack.pop();
                System.out.print(node.element + " ");
                current = node.right;
            }
        }
    }

    @Override
    /**
     * Returns true if the element is in the tree
     */
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root

        while (current != null) {
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                current = current.right;
            } else // element matches current.element
            {
                return true; // Element is found
            }
        }

        return false;
    }

    @Override
    /**
     * Insert element e into the binary tree Return true if the element is
     * inserted successfully
     */
    public boolean insert(E e) {
        if (root == null) {
            root = createNewNode(e); // Create a new root
        } else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (c.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (c.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false; // Duplicate node not inserted
                }
            }
            // Create the new node and attach it to the parent node
            if (c.compare(e, parent.element) < 0) {
                parent.left = createNewNode(e);
            } else {
                parent.right = createNewNode(e);
            }
        }

        size++;
        return true; // Element inserted successfully
    }

//    protected TreeNode<E> createNewNode(E e) {
//        return new TreeNode<>(e);
//    }
//
//    @Override
//    /**
//     * Inorder traversal from the root
//     */
//    public void inorder() {
//        inorder(root);
//    }
//
//    /**
//     * Inorder traversal from a subtree
//     */
//    protected void inorder(TreeNode<E> root) {
//        if (root == null) {
//            return;
//        }
//        inorder(root.left);
//        System.out.print(root.element + " ");
//        inorder(root.right);
//    }
    /**
     * Displays the nodes in a breadth-first traversal
     */
    public void breadthFirstTraversal() {
        if (root == null) {
            return;
        }
        java.util.Queue<TreeNode<E>> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<E> current = queue.element();
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            System.out.print(queue.remove().element + " ");
        }
    }

    /**
     * Returns the height of this binary tree
     */
    public int height() {
        return height(root);
    }

    /**
     * Height from a subtree
     */
    protected int height(TreeNode<E> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * Returns true if the tree is a full binary tree
     */
    public boolean isFullBST() {
        return size == Math.pow(2, height()) - 1 ? true : false;
    }

    @Override
    /**
     * Postorder traversal from the root
     */
    public void postorder() {
        postorder(root);
    }

    /**
     * Postorder traversal from a subtree
     */
    protected void postorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    @Override
    /**
     * Preorder traversal from the root
     */
    public void preorder() {
        preorder(root);
    }

    /**
     * Preorder traversal from a subtree
     */
    protected void preorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * Returns the number of nonleaf nodes
     */
    public int getNumberOfNonLeaves() {
        return getNumberOfNonLeaves(root);
    }

    /**
     * Returns the number of nonleaf nodes
     */
    protected int getNumberOfNonLeaves(TreeNode<E> root) {
        if (root == null) {
            return 0;
        }

        // If node has children return 0
        // else return 1 plus the sum of the nonleaves
        return (root.left == null && root.right == null) ? 0
                : 1 + getNumberOfNonLeaves(root.left)
                + getNumberOfNonLeaves(root.right);
    }

    /**
     * This inner class is static, because it does not access any instance
     * members defined in its outer class
     */
    public static class TreeNode<E> {

        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    @Override
    /**
     * Obtain an iterator. Use inorder.
     */
    public java.util.Iterator<E> iterator() {
        return new InorderIterator();
    }

    // Inner class InorderIterator
    private class InorderIterator implements java.util.Iterator<E> {
        // Store the elements in a list

        private java.util.ArrayList<E> list
                = new java.util.ArrayList<>();
        private int current = 0; // Point to the current element in list

        public InorderIterator() {
            inorder(); // Traverse binary tree and store elements in list
        }

        /**
         * Inorder traversal from the root
         */
        private void inorder() {
            inorder(root);
        }

        /**
         * Inorder traversal from a subtree
         */
        private void inorder(TreeNode<E> root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override
        /**
         * More elements for traversing?
         */
        public boolean hasNext() {
            if (current < list.size()) {
                return true;
            }

            return false;
        }

        @Override
        /**
         * Get the current element and move to the next
         */
        public E next() {
            return list.get(current++);
        }

        @Override
        /**
         * Remove the current element
         */
        public void remove() {
            delete(list.get(current)); // Delete the current element
            list.clear(); // Clear the list
            inorder(); // Rebuild the list
        }
    }

    @Override
    /**
     * Remove all elements from the tree
     */
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    /**
     * Get the number of nodes in the tree
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    public TreeNode<E> getRoot() {
        return root;
    }

    /**
     * Returns a path from the root leading to the specified element
     */
    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list
                = new java.util.ArrayList<>();
        TreeNode<E> current = root; // Start from the root

        while (current != null) {
            list.add(current); // Add the node to the list
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                current = current.right;
            } else {
                break;
            }
        }

        return list; // Return an array list of nodes
    }

    /**
     * Returns true if two trees are equal. Otherwise returns false (recursive)
     */
    public boolean equals(BST<E> tree) {
        if (tree.size != size) {
            return false;
        }
        return equals(root, tree.root);
    }

    /**
     * Equals helper
     */
    protected boolean equals(TreeNode<E> root1, TreeNode<E> root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.element.equals(root2.element)
                && equals(root1.left, root2.left)
                && equals(root1.right, root2.right);
    }

    @Override
    /**
     * Override the protected clone method defined in the Object class, and deep
     * copy BST
     */
    public BST<E> clone() throws CloneNotSupportedException {
        BST<E> cloneBST = new BST<>();
        clone(cloneBST, root);
        return cloneBST;
    }

    /**
     * Clone helper
     */
    protected void clone(BST<E> clone, TreeNode<E> root) {
        if (root == null) {
            return;
        }
        clone.insert(root.element);
        clone(clone, root.left);
        clone(clone, root.right);
    }

// Inner class PreorderIterator
    private class PreorderIterator implements java.util.Iterator<E> {
        // Store the elements in a list

        private java.util.ArrayList<E> list
                = new java.util.ArrayList<>();
        private int current = 0; // Point to the current element in list

        public PreorderIterator() {
            preorder(); // Traverse binary tree and store elements in list
        }

        private void preorder() {
            preorder(root);
        }

        private void preorder(TreeNode<E> root) {
            if (root == null) {
                return;
            }
            list.add(root.element);
            preorder(root.left);
            preorder(root.right);
        }

        @Override
        /**
         * More elements for traversing?
         */
        public boolean hasNext() {
            if (current < list.size()) {
                return true;
            }

            return false;
        }

        @Override
        /**
         * Get the current element and move to the next
         */
        public E next() {
            return list.get(current++);
        }

        @Override
        /**
         * Remove the current element
         */
        public void remove() {
            delete(list.get(current)); // Delete the current element
            list.clear(); // Clear the list
            inorder(); // Rebuild the list
        }

        private void remove(E get) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    /**
     * Returns the number of leaf nodes
     */
    public int getNumberOfLeaves() {
        return getNumberOfLeaves(root);
    }

    /**
     * Returns the number of leaf nodes
     */
    public int getNumberOfLeaves(TreeNode<E> root) {
        if (root == null) {
            return 0;
        }

        // If node has no children return 1 
        // else return the sum of all the leaves
        return root.left == null && root.right == null ? 1
                : getNumberOfLeaves(root.left) + getNumberOfLeaves(root.right);
    }

    @Override
    /**
     * Delete an element from the binary tree. Return true if the element is
     * deleted successfully Return false if the element is not in the tree
     */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        
        //Find Method
        while (current != null) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break; 
            }
        }

        if (current == null) {
            return false;
        }
        // Case 1: current has no left child
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            } else {
                if (c.compare(e, parent.element) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        } else {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Case 3 Eliminate  node
            if (parentOfRightMost.left == rightMost) {
                parentOfRightMost.left = rightMost.right;
            } else // Special case: parentOfRightMost == current
            {
                parentOfRightMost.right = rightMost.right;
            }
        }

        size--; 
        return true; 
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        BST<Integer> tree = new BST<>();
        tree.insert(100);
        tree.insert(200);
        tree.insert(50);
        tree.insert(60);
        tree.insert(65);
        tree.insert(64);
        tree.insert(40);
        tree.insert(55);
        tree.insert(56);
        
        tree.inorder();
        System.out.println("");
        
        System.out.println("Remove-----------------------------------");
        tree.delete(50);
        tree.delete(55);
        tree.delete(200);
        tree.inorder();
        System.out.println("");
        
        
        
        
        
        
        
        
        
        
//
//        tree.insert(100);
//        tree.insert(70);
//        tree.insert(150);
//
//        tree.insert(80);
//        tree.insert(60);
//
//        tree.insert(62);
//        tree.insert(65);
//        tree.inorder();
//        System.out.println("");
//
//        tree.delete(70);
//        tree.inorder();
//        System.out.println("");
//
//        tree.delete(60);
//        tree.delete(150);
//        tree.inorder();
//        System.out.println("");
//
//        System.out.println("--------------------------------------------------");
//
//        tree.inorder();
//        System.out.println("");
//
//        System.out.println("itterator-----------------------------------------");
//        BST<String> tree1 = new BST<>();
//        tree1.insert("George");
//        tree1.insert("Michael");
//        tree1.insert("Tom");
//        tree1.insert("Adam");
//        tree1.insert("Jones");
//        tree1.insert("Peter");
//        tree1.insert("Daniel");
//
//        for (String s : tree1) 
//        {
//            System.out.print(s.toUpperCase() + " ");
//        }
//        
//        
//        // Create a BST
//		BST<String> tree3 = new BST<>();
//		tree3.insert("George");
//		tree3.insert("Micheal");
//		tree3.insert("Tom");
//		tree3.insert("Adam");
//		tree3.insert("Jones");
//		tree3.insert("Peter");
//		tree3.insert("Daniel");
//
//		// Traverse tree breadth-first
//		System.out.print("\nBreadth-first: ");
//		tree3.breadthFirstTraversal();
//
//		// Height of tree
//		System.out.print("\nHeight of tree: ");	
//		System.out.println(tree3.height());
//
//		// Create Integer BST
//		Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
//		BST<Integer> intTree = new BST<>(numbers);
//		
//		// Traverse tree breadth-first
//		intTree.breadthFirstTraversal();
//
//		// Height of tree
//		System.out.print("\nHeight of tree: ");	
//		System.out.println(intTree.height());
//                
//                // Create threee Integer BST
//		Integer[] numbers1 = {2, 4, 3, 1, 8, 5, 6, 7};
//		Integer[] numbers2 = {4, 2, 1, 3, 8, 5, 9};
//		Integer[] numbers3 = {10, 4, 2, 1, 3, 8, 5, 9, 15, 12, 11, 13, 21, 19, 25};
//		BST<Integer> intTree1 = new BST<>(numbers1);
//		BST<Integer> intTree2 = new BST<>(numbers2);
//		BST<Integer> intTree3 = new BST<>(numbers3);
//
//		// Test and display if each tree is a full binary tree
//		System.out.print("\nIs tree #1 a full binary tree? ");
//		System.out.println(intTree1.isFullBST());
//		System.out.print("\nIs tree #2 a full binary tree? ");
//		System.out.println(intTree2.isFullBST());
//		System.out.print("\nIs tree #3 a full binary tree? ");
//		System.out.println(intTree3.isFullBST());
//                
////                System.out.println("non-recursive tree----------------------------");
////                Scanner input = new Scanner(System.in);
////		Integer[] numbers4 = new Integer[10];
////
////		// Prompt the user to enter 10 integers
////		System.out.print("Enter 10 integers: ");
////		for (int i = 0; i < numbers4.length; i++)
////			numbers4[i] = input.nextInt();
////		
////		// Create Integer BST
////		BST<Integer> intTree4 = new BST<>(numbers4);
////
////		// Traverse tree inorder
////		System.out.print("Tree inorder: ");
////		intTree4.inorder();
////		System.out.println();
////                
//                
//                System.out.println("#leaves----------------------------------");
//                
//                Integer[] numbers5 = {60, 55, 45, 47, 59, 100, 76, 107, 101};
//		
//		// Create Integer BST
//		BST<Integer> intTree5 = new BST<>(numbers5);
//
//		// Traverse tree postorder
//		System.out.println("Number of leaf nodes: " + 
//			intTree5.getNumberOfLeaves());
//                
//                //Integer[] numbers6 = {60, 55, 45, 47, 59, 100, 76, 107, 101};
//		
//		// Create Integer BST
//		BST<Integer> intTree6 = new BST<>(numbers5);
//
//		// Traverse tree postorder
//		System.out.println("Number of nonleaf nodes: " + 
//			intTree6.getNumberOfNonLeaves());
//                
//                
//                System.out.println("clone non class------------------------------");
//                Integer[] numbers7 = {60, 55, 45, 47, 59, 100, 76, 107, 101};
//		Integer[] numbers8 = {60, 55, 45, 48, 59, 100, 76, 107, 101};
//		
//		// Create two Integer BST
//		BST<Integer> intTree7 = new BST<>(numbers7);
//		BST<Integer> intTree8 = new BST<>(numbers8);
//
//		// Display BST in preorder
//		System.out.print("intTree: ");
//		intTree7.preorder();
//		System.out.print("\nintTree2: ");
//		intTree8.preorder();
//
//
//		// Clone intTree
//		BST<Integer> intTreeCopy = intTree7.clone();
//
//		// Test for equality
//		System.out.println("\nIs intTree equal to intTree2? " + 
//			intTree7.equals(intTree8));
//		System.out.println("Is intTree equal to intTreeCopy? " + 
//			intTree7.equals(intTreeCopy));
//
//		// Display BST in preorder
//		System.out.print("intTreeCopy: ");
//		intTreeCopy.preorder();
//		System.out.println();
//                
////                Integer[] numbers9 = {1,3,5,2,9};
////                Integer[] numbers10 = {1,3,5,2,9};
////                
////                BTree btree1 = new BTree(numbers9);
////                BTree btree2 = new BTree(numbers10);
////                // Clone intTree
////		BTree intTreeCopy2 =  (BTree) btree1.clone();
////
////		// Test for equality
////		System.out.println("\nIs intTree equal to intTree2? " + 
////			btree1.equals(btree2));
////		System.out.println("Is intTree equal to intTreeCopy? " + 
////			intTree1.equals(intTreeCopy2));

    }
}

class BTree implements Consumer<BTree> {
    int [] y;
    int x;
    Integer[] z;

    public BTree() {
    }

    public BTree(Integer[] z) {
        this.z = z;
    }
    
    

    public BTree(int x) {
        this.x = x;
    }

    public BTree(int[] y) {
        this.y = y;
    }

   
    

    @Override
    public String toString() {
        return "BTree{" + "x=" + x + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BTree other = (BTree) obj;
        if (!Objects.equals(this.z, other.z)) {
            return false;
        }
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    

    /**
     * Performs this operation on the given argument. squares x
     *
     * @param t the input argument
     */
    @Override
    public void accept(BTree t) {
        t.x = t.x * t.x;
    }

    @Override
    public Consumer<BTree> andThen(Consumer<? super BTree> after) {
        return Consumer.super.andThen(after); //To change body of generated methods, choose Tools | Templates.
    }

}
class BTree2{}
