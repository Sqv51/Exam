package List;

public class LinkedList {

    protected Node head;
    protected Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public Node getHead(){
        return head;
    }

    public void insertFirst(Node newNode) {
        if (isEmpty()) {
            tail = newNode;
        }
        newNode.setNext(head);
        head = newNode;
    }

    Node search(int value){
        Node tmp;
        tmp = head;
        while (tmp != null){
            if (tmp.data == value)
                return tmp;
            tmp = tmp.next;
        }
        return null;
    }
    public void insertLast(Node newNode){
        if(isEmpty()){head = newNode;}

        else {tail.setNext(newNode);}
        tail = newNode;
    }

    public void deleteFirst(){
        head = head.getNext();
        if (isEmpty()){
            tail = null;
        }
    }

    public int smallest(){

        Node currentNode = this.head;
        int smallest = currentNode.data;
        while(currentNode.next!= null){
            if(currentNode.data <smallest){
                smallest = currentNode.next.data;

            }
            currentNode = currentNode.next;
        }
        return smallest;
    }
    
    public String toString(){
        StringBuilder result = new StringBuilder();
        Node tmp = head;
        while (tmp != null) {
            result.append(tmp).append(" ");
            tmp = tmp.getNext();
        }
        return result.toString();
    }
    public boolean containsOnlyDuplicates(){
        Node curr = this.head;

        while(curr!=null){
            int count = countNode(this.head);
            if(count !=2){
                return false;
            }
            curr=curr.next;
        }
        return true;
    }

    public  int countNode(Node head)
    {
        int count = 1;

            Node ptr = head.next;
            while (ptr != null)
            {

                // If some duplicate node is found
                if (head.data == ptr.data)
                {
                    count++;

                }
                ptr = ptr.next;
            }



        // Return the count of duplicate nodes
        return count;
    }
    void deleteMiddle(Node s){
        Node tmp, previous;
        tmp = head;
        previous = null;
        while (tmp != s){
            previous = tmp;
            tmp = tmp.next;
        }
        if(previous!=null)
        previous.next = s.next;
    }
    public void soe(int n){
        LinkedList list = new LinkedList();
        for (int i = 2; i < n; i++) {
            Node node = new Node(i);
            list.insertLast(node);
        }
        Node curr = list.getHead();
        while(curr!=null) {
            int p = curr.data;
            System.out.println(p);
            Node curr2 = curr;
            while (curr2 != null) {
                if (curr2.data % p == 0) {
                    list.deleteMiddle(curr2);
                }
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
    }

    public void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    public void delete(int value) {
        Node tmp, previous;
        tmp = head;
        previous = null;
        while (tmp != null && tmp.data != value) {
            previous = tmp;
            tmp = tmp.next;
        }
        if (tmp != null) {
            if (previous != null) {
                previous.next = tmp.next;
            } else {
                head = tmp.next;
            }
        }
    }
}
