package estudo.stack1;

import java.util.Stack;

public class LinkedListWithStack {
	
    private Stack<Nodee> stack;

    public LinkedListWithStack() {
        stack = new Stack<Nodee>();
    }

    public void add(int data) {
    	
        Nodee newNode = new Nodee(data);

        if(stack.empty()) {
            stack.push(newNode);
        } else {
            Nodee topNode = stack.peek();
            topNode.setNext(newNode);
            stack.push(newNode);
        }
    }

    public void printList() {
    	
        Nodee currentNode = stack.isEmpty() ? null : stack.firstElement();

        while(currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
    }

    public static void main(String[] args) {
    	
        LinkedListWithStack linkedList = new LinkedListWithStack();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.printList();
        
    }
}

