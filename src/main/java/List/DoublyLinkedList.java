package List;

public class DoublyLinkedList extends LinkedList{

    public void insertLast(DoublyNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        newNode.setPrevious((DoublyNode) tail);
        tail = newNode;
    }

    public void deleteLast(){
        tail = ((DoublyNode)tail).getPrevious();
        if (tail != null){
            tail.setNext(null);
        } else {
            head = null;
        }
    }

    public DoublyLinkedList getEvenOnes(){
        DoublyLinkedList result = new DoublyLinkedList();
        Node curr = head;
        while(curr!=null){
            curr= curr.next;
            result.insertLast(curr);
            curr= curr.next;
        }
        return result;
    }

    public DoublyLinkedList sortElements() {
        DoublyLinkedList res = new DoublyLinkedList();
        int largest = Integer.MIN_VALUE;
        {
            Node temp = head;
            while (temp != null) {
                largest = (temp.data >= largest) ? temp.data : largest;
                temp = temp.next;
            }
        }
        for (int i = 1; i <= largest; i++) {
            int count = 0;
            Node temp = head;
            while (temp != null) {
                if (temp.getData() == i) {
                    count++;
                }
                temp = temp.next;
            }
            for (int j = 0; j < count; j++) {
                DoublyNode newNode = new DoublyNode(i);
                if (res.head == null) {
                    res.head = newNode;
                } else {
                    res.tail.setNext(newNode);
                }
                newNode.setPrevious((DoublyNode) tail);
                res.tail = newNode;
            }
        }
        return res;
    }

}
