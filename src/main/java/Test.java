import List.DoublyLinkedList;
import List.LinkedList;
import List.Node;
import List.Stack;
import Tree.TreeNode;
import Tree.Tree;

import java.util.ArrayList;
import java.util.List;
import List.Queue;

public class Test {

    public static void main(String[] args) {
        //create a que with elements from 1 to 10
        Queue queue = new Queue();
        for (int i = 0; i <= 10; i++) {
            queue.enqueue(new Node(i));
        }

        queue.print();
        queue.reverseK(5);
        queue.print();





















    }
}
