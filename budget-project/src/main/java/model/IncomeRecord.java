package model;

import java.time.LocalDate;

public class IncomeRecord {

    private Double incomeAmount;
    private LocalDate incomeDate;
    private String incomeCategory;
    private boolean bankTransfer;
    private String incomeDescription;

    public IncomeRecord() {
    }

    public Double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public LocalDate getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(LocalDate incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getIncomeCategory() {
        return incomeCategory;
    }

    public void setIncomeCategory(String incomeCategory) {
        this.incomeCategory = incomeCategory;
    }

    public boolean isBankTransfer() {
        return bankTransfer;
    }

    public void setBankTransfer(boolean bankTransfer) {
        this.bankTransfer = bankTransfer;
    }

    public String getIncomeDescription() {
        return incomeDescription;
    }

    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }

    @Override
    public String toString() {
        return "IncomeRecord{" +
                "amount=" + incomeAmount +
                ", date=" + incomeDate +
                ", category='" + incomeCategory + '\'' +
                ", bankTransfer=" + bankTransfer +
                ", additionalInfo='" + incomeDescription + '\'' +
                '}';
    }
}
