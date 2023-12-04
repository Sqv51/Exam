package Tree;


import java.util.List;
import java.util.Random;
import java.util.Stack;



public class Tree {

    protected TreeNode root;

    public Tree(){
        root = null;
    }

    public TreeNode getRoot(){
        return root;
    }

    public void setRoot(TreeNode root){
        this.root = root;
    }

    protected void insertChild(TreeNode parent, TreeNode child){
        if (parent == null) {
            root = child;
        } else {
            if (child.data < parent.data) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
    }

    public void iterativeInsert(TreeNode node){
        TreeNode parent = null;
        TreeNode tmp = root;
        while (tmp != null) {
            parent = tmp;
            if (node.getData() < tmp.getData()){
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        insertChild(parent, node);
    }

    //tree excecises 7
    TreeNode randomLeaf(){
        List<TreeNode> leafNodes = null;
        collectLeafNodes(root,leafNodes);
        Random random = new Random();
        int randomIndex = random.nextInt(leafNodes.size());
        return leafNodes.get(randomIndex);
    }
    private void collectLeafNodes(TreeNode node, List<TreeNode> leafNodes) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                // Node is a leaf, add it to the list
                leafNodes.add(node);
            } else {
                // Recursively collect leaf nodes in the left and right subtrees
                collectLeafNodes(node.left, leafNodes);
                collectLeafNodes(node.right, leafNodes);
            }
        }
    }
    //tree exercise 1 (general  recursive delete func)

    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }
    private TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) return root;

        // Recur down the tree
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        TreeNode temp = root;
        while (temp.left != null){
            temp = temp.left;
        }
        return temp.data;
    }

    public void prettyPrint(){
        if (root != null){
            root.prettyPrint(0);
        }
    }

    public int leafCount() {
        return leafCount2(root,0);
    }

    private int leafCount2(TreeNode node, int count) {
        if (node != null) {
            int temp = count;
            count += isLeaf(node.left);
            count += isLeaf(node.right);
            count += leafCount2(node.left, temp);
            count += leafCount2(node.right, temp);
            return count;
        }
        return 0;
    }

    private int isLeaf(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return 0;
    }

    //exercise24 binary tree versiyon
    public int leftistCount() {
        return leftistCount(root);
    }

    private int leftistCount(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int count = 0;

        // Add your conditions for counting nodes here
        if (node.right == null && node.left != null) {
            count++;
        }

        // Recursive calls for left and right subtrees
        count += leftistCount(node.left);
        count += leftistCount(node.right);

        return count;
    }

    //excecise 13
    int height(TreeNode root){
        if(root == null){return 0;}

        int leftheight = height(root.left);
        int rightheight = height(root.right);

        return 1 + Integer.max(leftheight,rightheight);

    }

    //excecise 12
    void swapChildren() {
        //swap left and right children of all nodes
        //swapChildren(root);

    }


    //recursive binary tree search
    public TreeNode searchRec(int key){
        //binary tree search but this time recursive
        if(key == root.data){
            return root;
        } else if (key < root.data){
            return searchRec(root.left.data);
        } else {
            return searchRec(root.right.data);
        }

    }

    //iterative binary tree search
    public TreeNode searchIter(int key){
        //binary tree search but this time iterative
        TreeNode tmp = root;
        while (tmp != null){
            if (tmp.data == key){
                return tmp;
            } else if (tmp.data > key){
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        return null;
    }

    //iterative minimum search
    public TreeNode minIter(){
        TreeNode tmp = root;
        while (tmp.left != null){
            tmp = tmp.left;
        }
        return tmp;
    }
    //iterative maximum search
    public TreeNode maxIter(){
        TreeNode tmp = root;
        while (tmp.right != null){
            tmp = tmp.right;
        }
        return tmp;
    }
    //recursive minimum search
    public TreeNode minRec(TreeNode root){
        if (root.left == null){
            return root;
        } else {
            return minRec(root.left);
        }
    }
    //recursive maximum search
    public TreeNode maxRec(TreeNode root){
        if (root.right == null){
            return root;
        } else {
            return maxRec(root.right);
        }
    }

    //binary search tree preoder traversal
    public void preorder(TreeNode root){
        if (root != null){
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }
    //binary search tree inorder traversal
    public void inorder(TreeNode root){
        if (root != null){
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }
    //binary search tree postorder traversal
    public void postorder(TreeNode root){
        if (root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }
    }

    //non recursive tree traversal with List stack including node count
    public int nonRecursiveTraversal(){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        int count = 0;
        while (tmp != null || !stack.isEmpty()){
            if (tmp != null){
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.pop();
                count++;
                tmp = tmp.right;
            }
        }
        return count;
    }
    //non recursive tree traversal with queue including node count with java queue
    public int nonRecursiveTraversal2(){
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        TreeNode tmp = root;
        int count = 0;
        while (tmp != null || !queue.isEmpty()){
            if (tmp != null){
                queue.add(tmp);
                tmp = tmp.left;
            } else {
                tmp = queue.remove();
                count++;
                tmp = tmp.right;
            }
        }
        return count;
    }

    //Given a Binary Search Tree (BST), write a function findLargestSmallerThanK(root, k) that returns the largest value in the BST that is smaller than a given integer k. Assume the BST does not contain duplicate values.

public int findLargestSmallerThanK(TreeNode root, int k) {
        // your code goes here
        int result = 0;
        while (root != null){
            if (root.data < k){
                result = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return result;
    }




    public void print() {
        //prind pretty print
        prettyPrint();
    }
}
