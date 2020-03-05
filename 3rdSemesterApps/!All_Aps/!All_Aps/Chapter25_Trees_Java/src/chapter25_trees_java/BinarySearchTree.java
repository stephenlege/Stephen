/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter25_trees_java;

/**
 *
 * @author Greg
 */
public class BinarySearchTree<E extends Comparable<E>> {

    Node<E> root;

    protected java.util.Comparator<E> c;

    class Node<E extends Comparable<E>> {

        Node<E> lChild;
        Node<E> rChild;
        E e;
    }

    public boolean remove(E e) {

        Node<E> parent = root;
        Node<E> current = find(e);

        if (current == null) {
            return false; // Element is not in the tree
        }
        // Case 1: current has no left child
        if (current.lChild == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.rChild;
            } else {
                if (e.compareTo(parent.e) < 0) {
                    parent.lChild = current.rChild;
                } else {
                    parent.rChild = current.rChild;
                }
            }
        } else {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            Node<E> parentOfNodeToBeDeleted = current;
            Node<E> nodeToBeDeleted = current.lChild;

            while (nodeToBeDeleted.rChild != (null)) {
                parentOfNodeToBeDeleted = nodeToBeDeleted;
                nodeToBeDeleted = nodeToBeDeleted.rChild; // Keep going to the right
            }
            //case 3
            // Replace the element in current by the element in rightMost
            current.e = nodeToBeDeleted.e;

            // Eliminate rightmost node
//            if ((nodeToBeDeleted.lChild != null && nodeToBeDeleted.rChild == null)
//                    || (nodeToBeDeleted.lChild == null && nodeToBeDeleted.rChild != null)) {
//                if (current.e.compareTo(e) < 0) {
//                    if (nodeToBeDeleted.lChild != null) {
//                        current.rChild = nodeToBeDeleted.lChild;
//                    } else {
//                        current.rChild = nodeToBeDeleted.rChild;
//                    }
//                } else 
//            if (nodeToBeDeleted.rChild != null) {
//                current.lChild = nodeToBeDeleted.rChild;
//            } else {
//                current.lChild = nodeToBeDeleted.lChild;
//            }
//            return true;
//        }
        if (parentOfNodeToBeDeleted.rChild == nodeToBeDeleted) {
            parentOfNodeToBeDeleted.rChild = nodeToBeDeleted.lChild;
        } else // Special case: parentOfRightMost == current
        {
            parentOfNodeToBeDeleted.lChild = nodeToBeDeleted.lChild;
        }
    }


return true;

    }

    public boolean search(E e) {
        Node<E> p = root; // Start from the root

        while (p != null) {
            if (e.compareTo(p.e) < 0) {
                p = p.lChild;
            } else if (e.compareTo(p.e) > 0) {
                p = p.rChild;
            } else // element matches current.element
            {
                return true; // Element is found
            }
        }

        return false;
    }

    private Node<E> find(E e) {
        Node<E> current = root;
        while (current != null) {
            if (e.compareTo(current.e) < 0) {
                current = current.lChild;
            } else if (e.compareTo(current.e) > 0) {
                current = current.rChild;
            } else {
                break; // Element is in the tree pointed at by current
            }
        }
        return current;
    }

    private int getSize(Node<E> root) {
        if (root == null) {
            return 0;
        }
        return getSize(root.lChild) + getSize(root.rChild) + 1;
    }

    public int getSize() {
        return getSize(root);
    }

    public boolean insert(E e) {
        Node<E> newNode = new Node<>();
        newNode.e = e;

        if (root == null) {
            root = newNode;

        } else {
            Node<E> parent = root;
            Node<E> current = parent;

            while (parent != null) {
                current = parent;
                if (e.compareTo(parent.e) == 0) {
                    return false;
                } else if (e.compareTo(parent.e) > 0)//goright
                {
                    parent = parent.rChild;
                } else {
                    parent = parent.lChild;
                }
            }
            // Create the new node and attach it to the parent node
            if (e.compareTo(current.e) < 0) {
                current.lChild = newNode;

            } else {
                current.rChild = newNode;
            }
        }

        return true; // Element inserted successfully
    }

    /**
     * Inorder traversal from a subtree
     */
    protected void inorder(Node<E> root) {
        if (root == null) {
            return;
        }
        inorder(root.lChild);
        System.out.print(root.e + " ");
        inorder(root.rChild);
    }

    /**
     * Inorder traversal from the root
     */
    public void inorder() {
        inorder(root);
        System.out.println("");
    }

    /**
     * Inorder traversal from a subtree
     */
    protected void postOrder(Node<E> root) {
        if (root == null) {
            return;
        }
        postOrder(root.lChild);
        postOrder(root.rChild);
        System.out.print(root.e + " ");
    }

    protected void preOrder(Node<E> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.e + " ");
        preOrder(root.lChild);
        preOrder(root.rChild);
    }

    public void preOrder() {
        preOrder(root);
        System.out.println("");
    }

    /**
     * Inorder traversal from the root
     */
    public void postOrder() {
        postOrder(root);
        System.out.println("");
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(100);
        tree.insert(70);
        tree.insert(150);

        tree.insert(80);
        tree.insert(60);

        tree.insert(62);
        tree.insert(65);
        tree.inorder();

        //System.out.println( tree.find(40));
//        System.out.println("");
//
//        tree.postOrder();
//        System.out.println("--------------------------------");
//        tree.preOrder();
        //System.out.println(tree.find(40));
        tree.remove(70);
        tree.inorder();

        tree.remove(60);
        tree.remove(150);
        tree.inorder();

        System.out.println("--------------------------------------------------");

        tree.inorder();
    }
}
