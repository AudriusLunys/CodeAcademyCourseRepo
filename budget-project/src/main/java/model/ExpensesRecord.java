package model;

import java.time.LocalDateTime;

public class ExpensesRecord {

    private Double expenseAmount;
    private LocalDateTime expenseDateAndTime;
    private String expenseCategory;
    private String methodOfPayment;
    private String expenseDescription;

    public ExpensesRecord() {
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public LocalDateTime getExpenseDateAndTime() {
        return expenseDateAndTime;
    }

    public void setExpenseDateAndTime(LocalDateTime expenseDateAndTime) {
        this.expenseDateAndTime = expenseDateAndTime;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public String getMethodOfPayment() {
        return methodOfPayment;
    }

    public void setMethodOfPayment(String methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    @Override
    public String toString() {
        return "ExpensesRecord{" +
                "expenseAmount=" + expenseAmount +
                ", expenseDateAndTime=" + expenseDateAndTime +
                ", expenseCategory='" + expenseCategory + '\'' +
                ", methodOfPayment='" + methodOfPayment + '\'' +
                ", expenseDescription='" + expenseDescription + '\'' +
                '}';
    }
}
