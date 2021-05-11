package service;

import model.ExpensesRecord;
import model.IncomeRecord;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Budget {
    private PrintService printService = new PrintService();
    private Scanner scanner = new Scanner(System.in);

    private IncomeRecord[] income = new IncomeRecord[100];
    private ExpensesRecord[] expenses = new ExpensesRecord[100];


    public IncomeRecord addIncomeRecord() {

        IncomeRecord incomeRecord = new IncomeRecord();

        printService.print("Income date : format yyyy-MM-dd");
        String date = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        incomeRecord.setIncomeDate(localDate);

        printService.print("income amount");
        incomeRecord.setIncomeAmount(scanner.nextDouble());
        scanner.nextLine();

        printService.print("income category");
        incomeRecord.setIncomeCategory(scanner.nextLine());

        printService.print("is it a bank transfer ? Yes input 1 / No input 0");
        int input = scanner.nextInt();
        if (input == 1) {
            incomeRecord.setBankTransfer(true);
        } else {
            incomeRecord.setBankTransfer(false);
        }
        scanner.nextLine();
        printService.print("please add short description of income");
        incomeRecord.setIncomeDescription(scanner.nextLine());

        return incomeRecord;
    }

    public IncomeRecord[] addRecordToIncomeList(IncomeRecord incomeRecord) {
        for (int i = 0; i <= income.length; i++) {
            if (i == 0) {
                income[i] = incomeRecord;
            }
        }
        return income;
    }

    public IncomeRecord getIncomeRecordByIndex() {
        printService.print("please input record index");
        int recordIndex = scanner.nextInt();
        IncomeRecord record = income[recordIndex];
        return record;
    }

    public ExpensesRecord addExpenseRecord() {
        ExpensesRecord expensesRecord = new ExpensesRecord();

        printService.print("expense date : format yyyy-MM-dd HH:mm");
        String dateAndTime = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(dateAndTime, formatter);
        expensesRecord.setExpenseDateAndTime(localDateTime);

        printService.print("expense amount");
        expensesRecord.setExpenseAmount(scanner.nextDouble());
        scanner.nextLine();

        printService.print("expenses category");
        expensesRecord.setExpenseCategory(scanner.nextLine());

        printService.print("payment method ? Bank transfer input 1 / Cash- input 0");
        int input = scanner.nextInt();
        if (input == 1) {
            expensesRecord.setMethodOfPayment("bank transfer");
        } else {
            expensesRecord.setMethodOfPayment("cash");
        }
        scanner.nextLine();

        printService.print("please add short description of expense");
        expensesRecord.setExpenseDescription(scanner.nextLine());

        return expensesRecord;
    }

    public ExpensesRecord[] addRecordToExpensesList(ExpensesRecord expensesRecord) {
        for (int i = 0; i <= expenses.length; i++) {
            if (i == 0) {
               expenses[i] = expensesRecord;
            }
        }
        return expenses;
    }

    public ExpensesRecord getExpensesRecordByIndex() {
        printService.print("please input record index");
        int recordIndex = scanner.nextInt();
        ExpensesRecord record = expenses[recordIndex];
        return record;
    }
}

