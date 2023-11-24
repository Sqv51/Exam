import List.DoublyLinkedList;
import List.LinkedList;
import List.Node;
import List.Stack;
import Tree.TreeNode;
import Tree.Tree;

public class Test {

    public static void main(String[] args){
        //binary(11);
        DoublyLinkedList mylist = new DoublyLinkedList();
        for (int i = 0; i < 20; i++) {
            Node myNode = new Node(i%5);
            mylist.insertLast(myNode);
        }

        System.out.println(mylist);
        System.out.println(mylist.getEvenOnes());
        mylist.soe(21);
    }
    static void binary(int N){
        int digit;
        Stack c;
        Node e;
        c = new Stack();
        while (N > 0){
            digit = N % 2;
            e = new Node(digit);
            c.push(e);
            N = N / 2;
        }
        System.out.println(c);
        System.out.println(c.size());
        System.out.println(c.nodeIth(1));
        System.out.println(c.copy());
        System.out.println(c);
    }
}
