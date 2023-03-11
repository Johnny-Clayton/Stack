package estudo.stack5;

import java.util.Scanner;
import java.util.Stack;

public class ExpressaoMatematica {

    public static double avaliarExpressaoPosFixa(String expressao) {
    	
        Stack<Double> stack = new Stack<>();
        String[] elementos = expressao.split(" ");

        for (String elemento : elementos) {
        	
            if (elemento.matches("\\d+")) { // se é um número
                stack.push(Double.parseDouble(elemento));
            } else { // se é um operador
                double operando2 = stack.pop();
                double operando1 = stack.pop();
                double resultado = aplicarOperador(operando1, operando2, elemento);
                stack.push(resultado);
            }
        }

        return stack.pop();
    }

    private static double aplicarOperador(double operando1, double operando2, String operador) {
    	
        switch (operador) {
            case "+":
                return operando1 + operando2;
            case "-":
                return operando1 - operando2;
            case "*":
                return operando1 * operando2;
            case "/":
                return operando1 / operando2;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        String expressaoPosFixa;
        double resultado;
        String opcao;

        do {
            System.out.println("Digite a expressão em notação pós-fixa: ");
            expressaoPosFixa = scanner.nextLine();
            resultado = avaliarExpressaoPosFixa(expressaoPosFixa);
            System.out.println("Resultado: " + resultado);

            System.out.println("Deseja avaliar outra expressão? (S/N)");
            opcao = scanner.nextLine().toUpperCase();
        } while (opcao.equals("S"));
    }

}

