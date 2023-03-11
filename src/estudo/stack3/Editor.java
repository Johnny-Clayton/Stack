package estudo.stack3;
import java.util.Scanner;
import java.util.Stack;

public class Editor {
    private String currentText;
    private String previousText;
    private Stack<String> actionsStack;
    private Stack<Character> addedCharsStack;

    public Editor() {
        currentText = "";
        actionsStack = new Stack<String>();
        addedCharsStack = new Stack<Character>();
    }

    public String getCurrentText() {
        return currentText;
    }

    public void performAction(String action, String character) {
        previousText = currentText;
        if (action.equals("backspace")) {
            if (currentText.length() > 0) {
                currentText = currentText.substring(0, currentText.length() - 1);
                actionsStack.push("backspace");
            }
        } else if (action.equals("addChar")) {
            char charToAdd = character.charAt(0);
            currentText += charToAdd;
            addedCharsStack.push(charToAdd);
            actionsStack.push("addChar");
        }
    }

    public void undoLastAction() {
        if (!actionsStack.isEmpty()) {
            String lastAction = actionsStack.pop();
            if (lastAction.equals("backspace")) {
                currentText = previousText;
                if (!addedCharsStack.isEmpty()) {
                    addedCharsStack.pop();
                }
            } else if (lastAction.equals("addChar")) {
                currentText = currentText.substring(0, currentText.length() - 1);
                if (!addedCharsStack.isEmpty()) {
                    addedCharsStack.pop();
                }
            }
        }
    }

    public String getActionsStack() {
        StringBuilder sb = new StringBuilder();
        for (Character c : addedCharsStack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Editor editor = new Editor();
        String input = "";
        while (!input.equals("quit")) {
            System.out.println("Digite 'add' para adicionar um caractere, 'back' para apagar um caractere ou 'undo' para desfazer a última ação:");
            input = scanner.nextLine();
            String previousText = editor.getCurrentText();
            if (input.equals("add")) {
                System.out.println("Digite o caractere que deseja adicionar:");
                String characterToAdd = scanner.nextLine();
                editor.performAction("addChar", characterToAdd);
            } else if (input.equals("back")) {
                editor.performAction("backspace", "");
            } else if (input.equals("undo")) {
                editor.undoLastAction();
            } else if (!input.equals("quit")) {
                System.out.println("Entrada inválida!");
            }
            System.out.println("Texto atual: " + editor.getCurrentText());
            System.out.println("Texto anterior: " + previousText);
            System.out.println("Pilha de ações: " + editor.getActionsStack());
        }
        scanner.close();
    }
}
