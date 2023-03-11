package estudo.stack6;

import java.util.Scanner;
import java.util.Stack;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> numeros = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        System.out.println("Digite uma expressão matemática:");

        String expressao = scanner.nextLine();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            if (Character.isDigit(c)) {
                int num = Character.getNumericValue(c);
                numeros.push(num);
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operadores.isEmpty() && precedencia(c) <= precedencia(operadores.peek())) {
                    int num2 = numeros.pop();
                    int num1 = numeros.pop();
                    char operador = operadores.pop();
                    int resultado = realizarOperacao(num1, num2, operador);
                    numeros.push(resultado);
                }
                operadores.push(c);
            } else {
                System.out.println("Entrada inválida.");
                return;
            }
        }

        while (!operadores.isEmpty()) {
            int num2 = numeros.pop();
            int num1 = numeros.pop();
            char operador = operadores.pop();
            int resultado = realizarOperacao(num1, num2, operador);
            numeros.push(resultado);
        }

        if (numeros.size() != 1) {
            System.out.println("Entrada inválida.");
            return;
        }

        int resultadoFinal = numeros.pop();
        System.out.println("Resultado final: " + resultadoFinal);
    }

    private static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    private static int realizarOperacao(int num1, int num2, char operador) {
        switch (operador) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }

}


