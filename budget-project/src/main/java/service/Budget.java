package service;

import model.ExpensesRecord;
import model.IncomeRecord;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

public class Budget {
    private PrintService printService = new PrintService();
    private Scanner scanner = new Scanner(System.in);

    private IncomeRecord[] income = new IncomeRecord[100];
    private ExpensesRecord[] expenses = new ExpensesRecord[100];


    public IncomeRecord addIncomeRecord() {
        IncomeRecord incomeRecord = new IncomeRecord();
        printService.printRequestIncomeAmount();
        incomeRecord.setIncomeAmount(scanner.nextDouble());
        scanner.nextLine();

        //printService.printRequestIncomeDate();
        // String date=scanner.nextLine();
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // LocalDate localDate = LocalDate.parse(date,formatter);
        // incomeRecord.setIncomeDate(localDate);

        printService.printRequestIncomeCategory();

        incomeRecord.setIncomeCategory(scanner.nextLine());

        printService.printIsTransfer();
        int input = scanner.nextInt();
        if (input == 1) {
            incomeRecord.setBankTransfer(true);
        } else {
            incomeRecord.setBankTransfer(false);
        }
        scanner.nextLine();
        printService.printAddInfo();
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

    public IncomeRecord getIncomeRecord(IncomeRecord[] income){
        printService.requestIndexInput();
       int recordIndex = scanner.nextInt();
       IncomeRecord record = income[recordIndex];
       return record;
    }
}
