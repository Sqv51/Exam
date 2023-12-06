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
        //queue with 10 elements
        Queue queue = new Queue();
        for(int i = 0; i < 10; i++){
            queue.enqueue( new Node(i));
        }

        Queue queue2 = queue.divide();
        System.out.println("Queue 1");
        queue.print();
        System.out.println("Queue 2");
        queue2.print();





















    }
}
