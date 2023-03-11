package estudo.stack4;

import java.util.Scanner;
import java.util.Stack;

public class NamesStack {
    private Stack<String> namesStack;

    public NamesStack() {
        namesStack = new Stack<String>();
    }

    public void addName(String name) {
        namesStack.push(name);
    }

    public void modifyName(int index, String name) {
        if (index >= 0 && index < namesStack.size()) {
            namesStack.set(index, name);
        }
    }

    public void deleteName(int index) {
        if (index >= 0 && index < namesStack.size()) {
            namesStack.remove(index);
        }
    }

    public void printNames() {
        if (namesStack.isEmpty()) {
        	System.out.println("--------------------------");
            System.out.println("A pilha de nomes está vazia!");
        } else {
        	System.out.println("--------------------------");
            System.out.println("Pilha de nomes:");
            for (String name : namesStack) {
                System.out.println(name);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NamesStack namesStack = new NamesStack();
        String input = "";
        while (!input.equals("4")) {
        	
            input = menu(scanner);

            switch (input) {
			case "1" :
				System.out.println("Digite o nome que deseja adicionar:");
                String nameToAdd = scanner.nextLine();
                namesStack.addName(nameToAdd);
				break;
			case "2" :
				System.out.println("Digite o índice do nome que deseja modificar:");
                int indexToModify = scanner.nextInt();
                scanner.nextLine(); 
                System.out.println("Digite o novo nome:");
                String newName = scanner.nextLine();
                namesStack.modifyName(indexToModify, newName);
				break;
			case "3" :
				System.out.println("Digite o índice do nome que deseja deletar:");
                int indexToDelete = scanner.nextInt();
                scanner.nextLine(); 
                namesStack.deleteName(indexToDelete);
				break;
			default: System.out.println("Entrada inválida!");
				break;
			}
            namesStack.printNames();
        }
        scanner.close();
    }

	private static String menu(Scanner scanner) {
		
		System.out.println("--------------------------");
		System.out.println("1 - Adicionar um nome");
		System.out.println("2 - Modificar um nome");
		System.out.println("3 - Deletar um nome");
		System.out.println("4 - Sair do programa");
		System.out.print("Selecione uma opção: ");
		
		String input = scanner.nextLine();
		
		return input;
	}
}

