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
        Node r = dequeue();
        enqueue(r);
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

}
