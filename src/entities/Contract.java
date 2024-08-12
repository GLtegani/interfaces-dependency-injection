package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
   private Integer number;
   private LocalDate date;
   private Double totalValue;
   private List<Installment> installments = new ArrayList<>();

   public Contract(Integer number, LocalDate date, Double value) {
      this.number = number;
      this.date = date;
      this.totalValue = value;
   }

   public final Integer getNumber() {
      return number;
   }

   public final void setNumber(Integer number) {
      this.number = number;
   }

   public final LocalDate getDate() {
      return date;
   }

   public final void setDate(LocalDate date) {
      this.date = date;
   }

   public final Double getTotalValue() {
      return totalValue;
   }

   public final void setTotalValue(Double totalValue) {
      this.totalValue = totalValue;
   }

   public final List<Installment> getInstallments() {
      return installments;
   }


}
