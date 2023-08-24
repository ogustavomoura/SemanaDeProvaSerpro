import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Pessoa> pessoa = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int qtde = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtde; i++){
            System.out.print("Tax payer #" + (int)(i+1) + " data: ");
            System.out.print("\nIndividual or company (i/c) ?: ");
            char response = sc.nextLine().charAt(0);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            Double anualIncome = sc.nextDouble();
            sc.nextLine();

            if (response == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                sc.nextLine();
                PessoaFisica pessoaFisica = new PessoaFisica(name, anualIncome, healthExpenditures);
                pessoa.add(pessoaFisica);
            }
            else{
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                sc.nextLine();
                PessoaJuridica pessoaJuridica = new PessoaJuridica(name, anualIncome, numberOfEmployees);
                pessoa.add(pessoaJuridica);
            }
        }

        System.out.print("\nTAXES PAID: ");
        double sum = 0;
        for (Pessoa payer : pessoa){
            System.out.print(payer.getNome() + ": $" + payer.tax());
            sum += payer.tax();
            System.out.print("\n");
        }

        System.out.print("\nTOTAL TAXES: $" + sum);

        sc.close();
    }
}
