package estudo.stack2;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		
		// Adicionando elementos na stack
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println("Stack: " + stack);
		
		// Acessando o elemento no topo da stack sem removê-lo
        int topElement = stack.peek();
        System.out.println("Elemento no topo: " + topElement);

        // Removendo o elemento no topo da stack
        int removedElement = stack.pop();
        System.out.println("Elemento removido: " + removedElement);

        // Imprimindo a stack novamente
        System.out.println("Stack atualizada: " + stack);
	}

}
