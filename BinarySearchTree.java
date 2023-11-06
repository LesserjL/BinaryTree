import java.util.*;

/**
 * This BinarySearchTree object defines a reference based binary search tree
 * 
 * @author  
 * @version 
 */

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>
{
    protected BinaryNode<T> root;      // reference to the root of this BST
    private int size;
    private ArrayList<T> x;
    // Creates an empty Binary Search Tree object
    public BinarySearchTree()
    {
        root = null;
        size = 0;
        x = new ArrayList<T>();
    }

    // Returns true if this BST is empty; otherwise, returns false.
    public boolean isEmpty()
    {
        return root == null;
    }

    // Returns the number of elements in this BST.
    public int size()
    {
        return recSize(root);
    }
    // Adds element to this BST. The tree retains its BST property.
    public void add (T element)
    {
        root = add2(element, root);
    }
    public BinaryNode<T> add2(T element, BinaryNode<T> tree){
        if(tree == null){
            tree = new BinaryNode<T>(element);
        }
        else if(element.compareTo(tree.getInfo()) <= 0){
                tree.setLeft(add2(element, tree.getLeft()));
            }
           else{
                tree.setRight(add2(element, tree.getRight()));
            }
            return tree;
        }
        
    private int recSize(BinaryNode<T> root){
        if(root == null){
            return 0;
        }
        else{
            return 1 + recSize(root.getRight()) + recSize(root.getLeft());
        }
    }
    // Returns true if this BST contains an element e such that 
    // e.compareTo(element) == 0; otherwise, returns false.
    public boolean recContains(T element, BinaryNode<T> tree){
        if(tree == null){
            tree = new BinaryNode<T>(element);
        }
        else if(element.compareTo(tree.getInfo()) < 0){
                return recContains(element, tree.getLeft());
        }
        else if(element.compareTo(tree.getInfo()) > 0){
                return recContains(element, tree.getRight());
        }
        else{
            return true;
        }
        return false;
        }
    public boolean contains (T element)
    {
        return recContains(element, root);
    }

    // Returns a graphical representation of the tree
    public String toString()
    {
        return toString(root, 0);
    }

    private String toString(BinaryNode<T> tree, int level)
    {
        String str = "";
        if (tree != null)
        {
            str += toString(tree.getRight(), level + 1);
            for (int i = 1; i <= level; ++i)
                str = str + "| ";
            str += tree.getInfo().toString() + "\n";
            str += toString(tree.getLeft(), level + 1);
        }
        return str;
    }

    // Returns a list of elements from a preorder traversal
    public List<T> preorderTraverse()
    {
        x = new ArrayList<T>();
        recPreOrder(root);
        return x;
    }
    public void recPreOrder(BinaryNode<T> tree){
    if(tree != null){
        x.add(tree.getInfo());
        recPreOrder(tree.getLeft());
        recPreOrder(tree.getRight());
    }
    }
    public void recInOrder(BinaryNode<T> tree){
    if(tree != null){
        recInOrder(tree.getLeft());
        x.add(tree.getInfo());
        recInOrder(tree.getRight());
    }
    }
    // Returns a list of elements from an inorder traversal
    public List<T> inorderTraverse()
    {
        x = new ArrayList<T>();
        recInOrder(root);
        return x;
    }
    public void recPostOrder(BinaryNode<T> tree){
    if(tree != null){
        recPostOrder(tree.getLeft());
        recPostOrder(tree.getRight());
        x.add(tree.getInfo());
    }
    }
    // Returns a list of elements from a postorder traversal
    public List<T> postorderTraverse()
    {
        x= new ArrayList<T>();
        recPostOrder(root);
        return x;
    }

    // Removes an element e from this BST such that e.compareTo(element) == 0
    public void remove (T element)
    {
    }

    // Restructures this BST to be optimally balanced
    public void balance()
    {
    }
}
