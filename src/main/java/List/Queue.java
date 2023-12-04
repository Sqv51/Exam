package List;

public class Queue {

    protected Node first;
    protected Node last;

    public Queue() {
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(Node newNode) {
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
    }

    public Node dequeue(){
        Node result = first;
        if (!isEmpty()){
            first = first.getNext();
            if (isEmpty()){
                last = null;
            }
        }
        return result;
    }
    void moveToRear(){
        ///move the first element to the rear of the queue
        if (isEmpty() || first == last) {
            // If the queue is empty or has only one element, no need to move.
            return;
        }
        //else
        Node temp = first;
        first = first.next;
        last.next = temp;
        last = temp;
        last.next = null;

    }

    int largest (){
        Node temp = first;
        int largest = Integer.MIN_VALUE;
        while (temp != last){
            if (temp.data > largest){largest = temp.data;}
            temp = temp.next;
        }
        return largest;
    }

    public void moveToFront() {
        if (isEmpty() || first == last) {
            // If the queue is empty or has only one element, no need to move.
            return;
        }

        Node current = first;
        Node secondToLast = null;

        while (current.next != null) {
            secondToLast = current;
            current = current.next;
        }

        // Move the last element to the front
        assert secondToLast != null;
        secondToLast.next = null;
        current.next = first;
        first = current;
    }

    void insertSecond(Node newNode){
        if (isEmpty() || first == last) {
            // If the queue is empty or has only one element, no need to move.
            enqueue(newNode);
        }

        Node temp = first.next;
        first.next = newNode;
         newNode.next = temp;
    }

    //reverse first k elements of a queue
    public void reverseK(int k){
        if (isEmpty() || first == last) {
            // If the queue is empty or has only one element, no need to move.
            return;
        }
        Node current = first;
        //new queue
        Queue queue = new Queue();
        Stack stack = new Stack();
        //for loop k times
        for (int i = 0; i < k; i++) {
            stack.push(this.dequeue());

        }
        //add first k elements to new queue from stack
        while (!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }
        //add the rest of the elements to the new queue
        while (!this.isEmpty()){
            queue.enqueue(this.dequeue());
        }
        //set the new queue to the old queue
        this.first = queue.first;




    }


    public void print() {
        Node tmp = first;
        while (tmp != null) {
            System.out.print(tmp + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }
}
