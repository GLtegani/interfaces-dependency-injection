package services;
import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {
   private final OnlinePaymentService onlinePaymentService;

   public ContractService(OnlinePaymentService onlinePaymentService) {
      this.onlinePaymentService = onlinePaymentService;
   }

   public void processContract(Contract contract, int installmentQuantity) {
      double basicQuota = contract.getTotalValue() / installmentQuantity;

      for(int i = 1; i <= installmentQuantity; i++) {
         LocalDate dueDate = contract.getDate().plusMonths(i);
         double interest = this.onlinePaymentService.interest(basicQuota, i);
         double fee = this.onlinePaymentService.paymentFee(basicQuota + interest);
         double totalQuota = basicQuota + interest + fee;

         contract.getInstallments().add(new Installment(dueDate, totalQuota));
      }
   }
}
