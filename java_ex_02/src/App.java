import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual será a ordem da matriz ? ");
        int ordem = sc.nextInt();
        int matriz[][] = new int[ordem][ordem];
        sc.nextLine();

        for (int i = 0; i < ordem; i++){
            for (int j = 0;  j < ordem; j++){
                System.out.println("Digite o valor do elemento [" + i + "][" + j + "]");
                matriz[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < ordem; i++){
            for (int j = 0;  j < ordem; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.print("Diagonal principal: ");
        for (int i = 0; i < ordem; i++){
            for (int j = 0;  j < ordem; j++){
                if (i == j){
                    System.out.print(matriz[i][j] + " ");
                }
            }
        }

        System.out.print("\nQuantidade de numeros negativos: ");
        int qtde = 0;
        for (int i = 0; i < ordem; i++){
            for (int j = 0;  j < ordem; j++){
                if (matriz[i][j] < 0){
                    qtde++;
                }
            }
        }
        System.out.println(qtde);

        sc.close();

    }
}
