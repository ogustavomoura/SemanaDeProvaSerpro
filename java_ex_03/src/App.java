import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número de linhas: ");
        int lines = sc.nextInt();
        System.out.print("Digite o número de colunas: ");
        int columns = sc.nextInt();
        int matriz[][] = new int[lines][columns];

        // Obtendo dados
        for (int i = 0; i < lines; i++){
            for (int j = 0; j < columns; j++){
                System.out.print("Digite o elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        // Imprimindo matriz
        for (int i = 0; i < lines; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.print("Escolha a linha do elemento: ");
        int elementLine = sc.nextInt();
        System.out.print("Escolha a coluna do elemento: ");
        int elementColumn = sc.nextInt();
        System.out.print("\nElemento selecionado: " + matriz[elementLine][elementColumn] + "\n");
        // System.out.println("Elemento de cima: " + matriz[elementLine][elementColumn]);
        // System.out.println("Elemento de baixo: " + matriz[elementLine][elementColumn]);
        // System.out.println("Elemento da esquerda: " + matriz[elementLine][elementColumn]);
        // System.out.println("Elemento de direita: " + matriz[elementLine][elementColumn]);

        if (elementLine - 1 >= 0) System.out.print("\nElemento de cima: " + matriz[elementLine - 1][elementColumn]);
        if (elementColumn + 1 < columns) System.out.print("\nElemento de direita: " + matriz[elementLine][elementColumn + 1]);
        if (elementLine + 1 < lines) System.out.print("\nElemento de baixo: " + matriz[elementLine + 1][elementColumn]);
        if (elementColumn - 1 >= 0) System.out.print("\nElemento da esquerda: " + matriz[elementLine][elementColumn - 1]);

        sc.close();
    }
}
