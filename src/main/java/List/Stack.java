package List;

public class Stack {
    private Node top;

    public Node getTop() {
        return top;
    }

    public Stack(){
        top = null;
    }


    public boolean isEmpty(){
        return top == null;
    }

    public Node peek(){
        return top;
    }

    public Node nodeIth(int i){
        Node tmp = top;
        int j = 0;
        while (tmp != null && j < i){
            j++;
            tmp = tmp.next;
        }
        return tmp;
    }

    public void push(Node node){

        node.setNext(top);
        top = node;
    }

    public Node pop(){
        Node topNode = top;
        top = top.next;
        return topNode;
    }
    public Node pop(int i){
        Node result;
        Node prew = null;
        Node curr = this.top;
        for(int j =1; j<i;j++){
            prew = curr;
            curr = curr.next;
        }
        result= curr;
        prew.next = curr.next;
        return result;
    }

    public Stack reverse(){
        Stack result = new Stack();
        Stack temp = this.copy();
        while (temp.top != null){
            result.push(temp.pop());
        }
        return result;
    }

    public Stack copy() {
         Node curr = top;
         Stack result = new Stack();
        for(int i= this.size()-1;i>-1; i--){
            result.push(this.nodeIth(i));
        }
        return  result;
    }

    public int size() {
        int result=0;
        Node curr = top;
        while(curr!=null){
            result++;
            curr=curr.next;
        }
        return result;
    }
    public void swapTop(){
        Node topNode = this.pop();
        Node secNode = this.pop();
        this.push(topNode);
        this.push(secNode);
    }

    @Override
    public String toString() {
        Node tmp = this.top;
        StringBuilder result =new StringBuilder();
        while(tmp !=null){
            int digit = tmp.getData();
            result.append(digit);
            tmp= tmp.next;
        }
        return result.toString();
    }
}
