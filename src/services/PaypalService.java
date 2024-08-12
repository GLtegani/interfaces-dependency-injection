package services;

public class PaypalService implements OnlinePaymentService{
   @Override
   public Double paymentFee(Double amount) {
      return amount * 0.02;
   }

   @Override
   public Double interest(Double basicQuota, Integer actualMonth) {
      return basicQuota * 0.01 * actualMonth;
   }
}
