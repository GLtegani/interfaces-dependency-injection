package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
   public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      System.out.println("Entre os dados do contrato");
      System.out.print("Número: ");
      int number = sc.nextInt();
      sc.nextLine();
      System.out.print("Data (dd/MM/yyyy): ");
      LocalDate date = LocalDate.parse(sc.nextLine(), formatter);
      System.out.print("Valor do contrato: ");
      double totalValue = sc.nextDouble();

      Contract contract = new Contract(number, date, totalValue);
      System.out.print("Entre com o número de parcelas: ");
      int installmentQuantity = sc.nextInt();
      sc.nextLine();

      ContractService contractService = new ContractService(new PaypalService());
      contractService.processContract(contract, installmentQuantity);

      System.out.println("PARCELAS: ");

      for(Installment installment : contract.getInstallments()) {
         System.out.println(installment);
      }


      sc.close();
   }
}
