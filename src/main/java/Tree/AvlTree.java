package Tree;

public class AvlTree extends Tree{

    public AvlTree(){
        super();
    }

    private int getHeight(AvlTreeNode node){
        if (node == null){
            return 0;
        } else {
            return node.getHeight();
        }
    }

    //rotate left
    /*
    private AvlTreeNode rotateLeft(AvlTreeNode node){
        TreeNode temp = node.getRight();
        node.setRight(temp.getLeft());
        temp.setLeft(node);
        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        temp.setHeight(Math.max(getHeight(temp.getLeft()), getHeight(temp.getRight())) + 1);
        return temp;
    }
    //rotate right
    private AvlTreeNode rotateRight(AvlTreeNode node){
        AvlTreeNode temp = node.getLeft();
        node.setLeft(temp.getRight());
        temp.setRight(node);
        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        temp.setHeight(Math.max(getHeight(temp.getLeft()), getHeight(temp.getRight())) + 1);
        return temp;
    }

    */


}
