package Array;

import List.Node;

public class Queue {

    private Element array[];

    private int first;

    private int last;

    private int N;

    public Queue(int N){
        this.N = N;
        array = new Element[N];
        first = 0;
        last = 0;
    }

    boolean isFull(){
        return (last + 1) % N == first;
    }

    public boolean isEmpty(){
        return first == last;
    }

    public void enqueue(Element element){
        if (!isFull()){
            array[last] = element;
            last = (last + 1) % N;
        }
    }

    public Element dequeue(){
        if (!isEmpty()){
            Element tmp = array[first];
            first = (first + 1) % N;
            return tmp;
        }
        return null;
    }
    public void doubleQueue(){

       Element[] newQueue = new Element[2*N];
        int i = first;
        int j = 0;
        while (i != last) {
            newQueue[j] = array[i];
            i = (i + 1) % N;
            j++;
        }

        newQueue[j] = array[last]; // Copy the last element

        first = 0;
        last = j;
        N   = 2*N;
        array = newQueue;
    }

    int largest (){
        int temp = first;
        int largest = Integer.MIN_VALUE;

        while (temp != last){
            if ((array[temp].getData() > largest)) {largest = array[temp].getData();}
            temp++;
        }
        return largest;
    }

    //resize queue
    public void resizeQueue(int capacity){
        Element[] newQueue = new Element[capacity];
        int i = first;
        int j = 0;
        while (i != last) {
            newQueue[j] = array[i];
            i = (i + 1) % N;
            j++;
        }

        newQueue[j] = array[last]; // Copy the last element

        first = 0;
        last = j;
        N   = capacity;
        array = newQueue;
    }

}
