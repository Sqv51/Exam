import List.DoublyLinkedList;
import List.LinkedList;
import List.Node;
import List.Stack;
import Tree.TreeNode;
import Tree.Tree;

import java.util.ArrayList;
import java.util.List;
import List.Queue;
import Array.Hash;


public class Test {

    public static void main(String[] args) {
        //Binary search tree add random numbers
        Tree tree = new Tree();
        tree.iterativeInsert(new TreeNode(4));
        tree.iterativeInsert(new TreeNode(2));
        tree.iterativeInsert(new TreeNode(3));
        tree.iterativeInsert(new TreeNode(1));
        tree.iterativeInsert(new TreeNode(6));
        tree.iterativeInsert(new TreeNode(5));
        tree.iterativeInsert(new TreeNode(7));

        tree.prettyPrint();

        System.out.println("***********");
        tree.swapChildren5();
        tree.prettyPrint();
        System.out.println("***********");





















    }
}
