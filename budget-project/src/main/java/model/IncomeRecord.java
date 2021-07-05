package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class IncomeRecord extends Record implements Serializable {

    private String incomeCategory;

    public IncomeRecord() {

    }

       public IncomeRecord(BigDecimal amount, LocalDate recordDate, String recordDescription, String incomeCategory) {
        super(amount, recordDate, recordDescription);
        this.incomeCategory = incomeCategory;
    }

    public String getIncomeCategory() {
        return incomeCategory;
    }

    public void setIncomeCategory(String incomeCategory) {
        this.incomeCategory = incomeCategory;
    }

    @Override
    public String toString() {
        return "IncomeRecord{" +
                "incomeCategory='" + incomeCategory + '\'' +
                "} " + super.toString();
    }


}
