package Tree;

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
