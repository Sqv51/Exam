package Tree;

import java.util.List;
import java.util.Random;

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

}
