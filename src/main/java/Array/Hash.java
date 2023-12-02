package Array;

public class Hash {

    private Element[] table;

    private boolean[] deleted;

    private int N;

    public Hash(int N){
        table = new Element[N];
        deleted = new boolean[N];
        this.N = N;
    }

    private int hashFunction(int value){
        return value % N;
    }

    public void insert(int value){
        int address;
        address = hashFunction(value);
        while (table[address] != null && !deleted[address]){
            address = (address + 1) % N;
        }
        if (table[address] != null){
            deleted[address] = false;
        }
        table[address] = new Element(value);
    }

    public Element search(int value){
        int address;
        address = hashFunction(value);
        while (table[address] != null && !deleted[address] && table[address].getData() != value){
            address = (address + 1) % N;
        }
        if (table[address] != null && table[address].getData() == value){
            return table[address];
        }
        return null;
    }
    //Element search(int value){
    //2 int address;
    //3 address = hashFunction(value);
    //4 while (table[address] != null){
    //5 if (!deleted[address] && table[address].data == value)
    //6 break;
    //7 address = (address + 1) % N;
    //8 }
    //9 return table[address];
    //10 }

    public void delete(int value){
        int address;
        address = hashFunction(value);
        while (table[address] != null && !deleted[address] && table[address].getData() != value){
            address = (address + 1) % N;
        }
        if (table[address] != null && table[address].getData() == value){
            deleted[address] = true;
        }
    }
    //void delete(int value){
    //2 int address;
    //3 address = hashFunction(value);
    //4 while (table[address] != null){
    //5 if (!deleted[address] && table[address].data == value)
    //6 break;
    //7 address = (address + 1) % N;
    //8 }
    //9 deleted[address] = true;
    //10 }

    public void rehash(){
        Element[] oldTable = table;
        boolean[] oldDeleted = deleted;
        table = new Element[2 * N];
        deleted = new boolean[2 * N];
        N = 2 * N;
        for (int i = 0; i < N / 2; i++){
            if (oldTable[i] != null && !oldDeleted[i]){
                insert(oldTable[i].getData());
            }
        }
    }


    //toString override
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++){
            if (table[i] != null && !deleted[i]){
                result.append(i).append(": ");
                result.append(table[i].getData()).append("\n");
            }
        }
        return result.toString();
    }


    public void print(){
        for (int i = 0; i < N; i++){
            if (table[i] != null && !deleted[i]){
                System.out.print(i + ": ");
                System.out.println(table[i].getData());
            }
        }
    }

}
