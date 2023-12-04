import List.DoublyLinkedList;
import List.LinkedList;
import List.Node;
import List.Stack;
import Tree.TreeNode;
import Tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        //test cases for tree function largestSmallerThanK
        Tree tree = new Tree();
        //for loop to insert 20 nodes from 0 to 20 into tree in random order
        //add them to a list and randomize the list
        //then insert the nodes into the tree in the randomized order
        ArrayList list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        java.util.Collections.shuffle(list);
        for (int i = 0; i < 20; i++) {
            TreeNode node = new TreeNode((int) list.get(i));
            tree.iterativeInsert(node);
        }
        //print tree
        System.out.println("Tree:");
        tree.print();
        //print largestSmallerThanK
        System.out.println("Largest smaller than 5: " + tree.findLargestSmallerThanK(tree.getRoot(), 5));
        //inorder print tree
        System.out.println("Inorder print:");
        tree.inorder(tree.getRoot());



















    }
}
