package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
   private LocalDate dueDate;
   private Double amount;
   private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


   public Installment(LocalDate dueDate, Double amount) {
      this.dueDate = dueDate;
      this.amount = amount;
   }

   public final LocalDate getDueDate() {
      return dueDate;
   }

   public final void setDueDate(LocalDate dueDate) {
      this.dueDate = dueDate;
   }

   public final Double getAmount() {
      return amount;
   }

   public final void setAmount(Double amount) {
      this.amount = amount;
   }

   @Override
   public final String toString() {
      return this.getDueDate().format(this.formatter) + " - " + String.format("%.2f", this.getAmount());
   }
}