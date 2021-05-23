package model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Record  {

    private BigDecimal amount;
    private LocalDate recordDate;
    private String recordDescription;


    public Record() {

    }

    public Record(BigDecimal amount, LocalDate recordDate, String recordDescription) {
        this.amount = amount;
        this.recordDate = recordDate;
        this.recordDescription = recordDescription;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordDescription() {
        return recordDescription;
    }

    public void setRecordDescription(String recordDescription) {
        this.recordDescription = recordDescription;
    }



    @Override
    public String toString() {
        return "Record{" +
                ", amount=" + amount +
                ", recordDate=" + recordDate +
                ", recordDescription='" + recordDescription + '\'' +
                '}';
    }
}


