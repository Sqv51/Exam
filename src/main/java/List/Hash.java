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
}
