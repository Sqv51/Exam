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
           // count += isLeaf(node.left);
            //count += isLeaf(node.right);
            count += leafCount2(node.left, temp);
            count += leafCount2(node.right, temp);
            return count;
        }
        return 0;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
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
    /*int height(TreeNode root){
        if(root == null){return 0;}

        int leftheight = height(root.left);
        int rightheight = height(root.right);

        return 1 + Integer.max(leftheight,rightheight);

    }*/

    //excecise 12 swaps all left and right children
    public void swapChildren() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;

        while (tmp != null || !stack.isEmpty()) {
            if (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.pop();

                // Swap children
                TreeNode curr = tmp.left;
                tmp.left = tmp.right;
                tmp.right = curr;

                // End of swap
                tmp = tmp.left;  // Fixed this line to move to the next node in the in-order traversal
            }
        }
    }
    //reverse the tree



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

    int height(){
        if (root == null){return 0;}
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int height = 0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (isLeaf(node)){
                height = Math.max(height,stack.size());
            }
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }

        }
        return height;
    }
    public int height2(){
        int leftHeight = 0;
        int rightHeight = 0;
        if(root == null){
            return 0;
        }
        if(root.left != null){
            leftHeight++;
            Tree leftTree = new Tree();
            leftTree.setRoot(root.left);
            leftHeight += leftTree.height2();
        }
        if(root.right != null){
            rightHeight++;
            Tree rightTree = new Tree();
            rightTree.setRoot(root.right);
            rightHeight += rightTree.height2();
        }
        return Math.max(leftHeight, rightHeight);
    }

    public int height(TreeNode node){
        if (node == null){
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public int height2(TreeNode node){
        if (node == null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (leftHeight > rightHeight){
            return 1 + leftHeight;
        } else {
            return 1 + rightHeight;
        }
    }

    //iterative search
    public TreeNode search(int data){
        TreeNode tmp = root;
        while (tmp != null && tmp.data != data){
            if (data < tmp.data){
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        return tmp;
    }
    public int myfunc(){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        int count = 0;
        while (tmp != null || !stack.isEmpty()){
            if (tmp != null){
                if(tmp.data%3 == 0){
                    count++;
                } else if (tmp.data%7 == 0) {
                    count--;
                }
                else {
                    count = count *2;
                }
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.pop();
                count++;
            }
        }
        return count;
    }

    public void increaseByOne(){
        //traverse the tree and add 1 to each node value
        //use a stack to store the nodes
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()){
            if (tmp != null){
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.pop();
                tmp.data++;
                tmp = tmp.right;
            }
        }

    }
    //traverse the tree and add divide each node value by 2 use queue
    public void divideByTwo(){
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        TreeNode tmp = root;
        while (tmp != null || !queue.isEmpty()){
            if (tmp != null){
                queue.add(tmp);
                tmp = tmp.left;
            } else {
                tmp = queue.remove();
                tmp.data = tmp.data/2;
                tmp = tmp.right;
            }
        }
    }
    //use inorder traversal to print the tree using stack
    public void inorderTraversal(){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()){
            if (tmp != null){
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.pop();
                System.out.println(tmp.data);
                tmp = tmp.right;
            }
        }
    }
    //use preorder traversal to print the tree using stack
    public void preorderTraversal(){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()){
            if (tmp != null){
                System.out.println(tmp.data);
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.pop();
                tmp = tmp.right;
            }
        }
    }
    public void postorderTraversalPrint() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()) {
            if (tmp != null) {
                stack.push(tmp);
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.pop();
                if (!stack.isEmpty() && stack.peek() == tmp) {
                    tmp = tmp.right;
                } else {
                    System.out.println(tmp.data);
                    tmp = null;
                }
            }
        }
    }
    public void postorderTraversal(){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisited = null;
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                TreeNode peekNode = stack.peek();
                if(peekNode.right != null && lastVisited != peekNode.right){
                    node = peekNode.right;
                } else {
                    System.out.println(peekNode.data);
                    lastVisited = stack.pop();
                }
            }
        }
    }
    public void swapChildren2(){
        swapChildren(root);
    }

    private void swapChildren(TreeNode node){
        if(node != null){
            swapChildren(node.left);
            swapChildren(node.right);

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
    /*Write a function that swaps left and right children
    of all nodes in a binary search tree. */
    public void swapChildren3(){
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        stack.push(node);
        while(!stack.isEmpty()){
            node = stack.pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(tmp != null) {
                if (tmp.right != null) {
                    stack.push(tmp.right);
                }
                if (tmp.left != null) {
                    stack.push(tmp.left);
                }
            }
        }
    }
    public void changeChild(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null&&root.right==null){
            root.right=root.left;
            root.left=null;
            changeChild(root.right);

        }
        else if(root.left==null&&root.right!=null){
            root.left=root.right;
            root.right=null;
            changeChild(root.left);
        }
        else if(root.left!=null&&root.right!=null){
            changeChild(root.left);
            changeChild(root.right);
        }

    }
    //recursive postorder traversal
    public void postorderTraversal2(TreeNode node){
        if (node != null){
            postorderTraversal2(node.left);
            postorderTraversal2(node.right);
            System.out.println(node.data);
        }
    }
    public void swapChildren4() {
        root = swapChildrenRecursive(root);
    }

    private TreeNode swapChildrenRecursive(TreeNode node) {
        if (node == null) {
            return null;
        }

        // Swap left and right children for the current node
        TreeNode l = node.getLeft();
        TreeNode r = node.getRight();
        node.setLeft(r);
        node.setRight(l);

        // Recursively swap children in the left and right subtrees
        swapChildrenRecursive(r);
        swapChildrenRecursive(l);

        return node;
    }
    public void swapChildren5(){
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        stack.push(node);
        while(!stack.isEmpty()){
            node = stack.pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);;
            }
        }
    }


}
