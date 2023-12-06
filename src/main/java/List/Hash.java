package List;

public class Hash {

    private LinkedList[] table;

    private int N;

    public Hash(int N){
        table = new LinkedList[N];
        for (int i = 0; i < N; i++){
            table[i] = new LinkedList();
        }
        this.N = N;
    }

    public void insert(int value){
        int address;
        address = hashFunction(value);
        table[address].insertFirst(new Node(value));
    }

    private int hashFunction(int value){
        return value % N;
    }

    public Node search(int value){
        int address;
        address = hashFunction(value);
        return table[address].search(value);
    }

    public void delete(int value){
        int address;
        address = hashFunction(value);
        table[address].delete(value);
    }
    public void print(){
        for (int i = 0; i < N; i++){
            System.out.print(i + ": ");
            table[i].print();
        }
    }

    public Node maximum(){
        Node result = new Node(Integer.MIN_VALUE);
        for(int i = 0; i<N ;i++){
            if(!table[i].isEmpty()){
                LinkedList linkedlist = table[i];
                Node tmp = linkedlist.head;
                Node maxNode=tmp;

                while(tmp.next!=null){
                    if(tmp.next.data>tmp.data){
                        maxNode=tmp.next;

                    }
                    tmp=tmp.next;
                }
                if(maxNode.data>result.data){
                    result= maxNode;
                }
            }
        }

        return result;
    }
    public double loadFactor(){
        int count = 0;
        for (int i = 0; i < N; i++){
            Node temp = table[i].head;
           while (temp != null){
               count++;
               temp = temp.next;
           }
        }
        return (double) count / N;
    }
    public int between(int a, int b){
        int count = 0;
        for (int i = 0; i < N; i++){
            Node temp = table[i].head;
            while (temp != null){
                if (temp.data >= a && temp.data <= b){
                    count++;
                }
                temp = temp.next;
            }
        }
        return count;
    }
    public int numberOfEmptySlots(){
      int count = 0;
        for (int i = 0; i < N; i++){
            if (table[i].isEmpty()){
                count++;
            }
        }
        return count;
    }
}
