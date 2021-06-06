package model;
import java.math.BigDecimal;
import java.time.LocalDate;
public class ExpensesRecord extends Record  {

    private String expenseCategory;

    public ExpensesRecord() {

    }
       public ExpensesRecord(BigDecimal amount, LocalDate recordDate, String recordDescription, String expenseCategory) {
        super(amount, recordDate, recordDescription);
        this.expenseCategory = expenseCategory;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    @Override
    public String toString() {
        return "ExpensesRecord{" +
                "expenseCategory='" + expenseCategory + '\'' +
                "} " + super.toString();
    }

}
