package service;

import model.ExpensesRecord;
import model.IncomeRecord;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Budget {
    private PrintService printService = new PrintService();
    private Scanner scanner = new Scanner(System.in);

    private Map<Integer, IncomeRecord> income = new HashMap<>();
    private Map<Integer, ExpensesRecord> expenses= new HashMap<>();

    private int incomeId=1;
    private int expensesId=1;


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

    public Map<Integer, IncomeRecord> addRecordToIncomeList(IncomeRecord incomeRecord) {
        income.put(incomeId, incomeRecord);
        incomeId++;
        return income;
    }

    public void printIncomeList() {
        for (Map.Entry<Integer, IncomeRecord> incomeRecordEntry : income.entrySet()) {
           printService.print("" + incomeRecordEntry);
        }
    }

    public void deleteIncomeRecordById(){
      printService.print("please input ID of record to delete");
      int idToDelete= scanner.nextInt();
        income.remove(idToDelete);
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

    public Map<Integer, ExpensesRecord> addRecordToExpensesList(ExpensesRecord expensesRecord) {
        expenses.put(expensesId, expensesRecord);
        expensesId++;
        return expenses;
    }

    public void printExpensesList() {
        for (Map.Entry<Integer, ExpensesRecord> expensesRecordEntry : expenses.entrySet()) {
            printService.print("" + expensesRecordEntry);
        }
    }

    public void deleteExpensesRecordById(){
        printService.print("please input ID of record to delete");
        int idToDelete= scanner.nextInt();
        expenses.remove(idToDelete);
    }

    public Double checkBalance(){
        Double sumOfIncome = 0.0;
        for (IncomeRecord incomeRecord : income.values()) {
            sumOfIncome += incomeRecord.getIncomeAmount();
        }
        Double sumOfExpenses = 0.0;
        for (ExpensesRecord expensesRecord : expenses.values()) {
            sumOfExpenses+=expensesRecord.getExpenseAmount();
        }
        return sumOfIncome - sumOfExpenses;
    }

}

