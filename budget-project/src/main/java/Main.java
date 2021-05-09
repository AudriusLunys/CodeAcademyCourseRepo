import model.ExpensesRecord;
import model.IncomeRecord;
import service.Budget;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Budget budget = new Budget();

        IncomeRecord i1 = budget.addIncomeRecord();
        IncomeRecord[] ir = budget.addRecordToIncomeList(i1);
        System.out.println(budget.getIncomeRecordByIndex(ir));

        ExpensesRecord e1 = budget.addExpenseRecord();
        ExpensesRecord[] expList = budget.addRecordToExpensesList(e1);
        System.out.println(budget.getExpensesRecordByIndex(expList));
    }
}
