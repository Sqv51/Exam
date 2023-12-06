package Array;

import List.Queue;
import Tree.TreeNode;
import Tree.Tree;

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

    public void delete(int value) {
        int address = hashFunction(value);

        while (table[address] != null) {
            if (!deleted[address] && table[address].getData() == value) {
                deleted[address] = true; // Mark the element as deleted
                return; // Exit the method after deleting the first occurrence
            }

            address = (address + 1) % N; // Move to the next slot
        }
    }
    public void deleteAllOccurrences(int value) {
        for (int i = 0; i < N; i++) {
            if (table[i] != null && !deleted[i] && table[i].getData() == value) {
                deleted[i] = true; // Mark the element as deleted
            }
        }
    }
    public Hash simplify(){
        Hash simple = new Hash(N);
        for(int i = 0; i<N ;i++){
            if(table[i]!=null){
                int address=hashFunction(table[i].getData());
                while(simple.table[address]!=null){
                    if(simple.table[address].getData()==table[i].getData()){
                        break;
                    }
                    address=(address+1)% N;
                }
               // if (simple.table[address] != null){
               //     simple.deleted[address] = false;
               // }
                simple.table[address] = table[i];
            }
        }
        return simple;

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


    //Write an hash function that maps a binary search tree into an hash
    //value. Assume that the hash value of a tree can be obtained first by
    //summing up the key values of the nodes and then hashing the sum.
    int hashFunction(Tree a){
        int sum = 0;

        return sum;
    }
    public double loadFactor(){
        int count = 0;
        for (int i = 0; i < N; i++){
            if (table[i] != null && !deleted[i]){
                count++;
            }
        }
        return (double) count / N;
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

    public int between(int a, int b){
        int result = 0;
        for (int i = 0; i < N; i++){
            if (table[i] != null && !deleted[i] && table[i].getData() >= a && table[i].getData() <= b){
                result++;
            }
        }
        return result;
    }
    public void undelete(int value){
        int address;
        address = hashFunction(value);
        while (table[address] != null && !deleted[address] && table[address].getData() != value){
            address = (address + 1) % N;
        }
        if (table[address] != null && table[address].getData() == value){
            deleted[address] = false;
        }
    }
    public int numberOfEmptySlots(){
        int result = 0;
        for (int i = 0; i < N; i++){
            if (table[i] == null || deleted[i]){
                result++;
            }
        }
        return result;
    }
    public void deleteAll(int x){
        int address;
        address = hashFunction(x);
        while (table[address] != null && !deleted[address] && table[address].getData() != x){
            address = (address + 1) % N;
            if (table[address] != null && table[address].getData() == x){
                deleted[address] = true;
            }

        }



    }


}
