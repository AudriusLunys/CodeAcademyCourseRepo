package service;

import model.ExpensesRecord;
import model.IncomeRecord;
import model.Record;
import model.exception.WrongSelectionInputException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Budget {
    private PrintService printService = new PrintService();
    private Scanner scanner = new Scanner(System.in);
    private final String MENU_ENTRY = " 1 -> EDIT 2 ->NEXT";
    private Map<Integer, Record> recordList = new HashMap<>();
    private int idInList = 1;

    public Record createRecord()  {
        Record record = null;
        try {
            printService.print("Income record 1 | Expense record 2");
            int choice = scanner.nextInt();
            if (choice == 1 || choice == 2) {
                printService.print(" Ammout of money ");
                BigDecimal sumOfMoney = scanner.nextBigDecimal();
                scanner.nextLine();
                printService.print("date : format yyyy-MM-dd");
                String date = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(date, formatter);
                printService.print("description");
                String description = scanner.nextLine();
                printService.print(" Category");
                String category = scanner.nextLine();
                if (choice == 1) {
                    record = new IncomeRecord(sumOfMoney, localDate, description, category);
                } else if (choice == 2) {
                    record = new ExpensesRecord(sumOfMoney, localDate, description, category);
                } else {
                    printService.print("input error");
                }
            } else {
                throw new WrongSelectionInputException("incorrect selection entered");
            }
        }
        catch (InputMismatchException exception) {
            System.out.println("bad input");
            scanner.nextLine();
        }
        catch (DateTimeParseException dateTimeParseException) {
            System.out.println("bad date input ");
        }
        return record;
    }

    public void addRecord(Record record) {
        recordList.put(idInList, record);
        idInList++;
    }

    public ArrayList<IncomeRecord> getAllIncomeRecords() {
        ArrayList<IncomeRecord> incomeRecords = new ArrayList<>();
        for (Record value : recordList.values()) {
            if (value instanceof IncomeRecord) {
                incomeRecords.add((IncomeRecord) value);
            }
        }
        return incomeRecords;
    }

    public ArrayList<ExpensesRecord> getAllExpencesRecords() {
        ArrayList<ExpensesRecord> expensesRecords = new ArrayList<>();
        for (Record value : recordList.values()) {
            if (value instanceof ExpensesRecord) {
                expensesRecords.add((ExpensesRecord) value);
            }
        }
        return expensesRecords;
    }

    public void showAllRecords() {
        printService.print("** this is list of all awailable records **");
        for (Map.Entry<Integer, Record> entry : recordList.entrySet()) {
            printService.print("" + entry);
        }
    }

    public void editSelectedRecord() {
        try {
            printService.print("please Enter record ID");
            int id = scanner.nextInt();
            int choice = 0;
            for (Map.Entry<Integer, Record> recordEntry : recordList.entrySet()) {
                if (recordEntry.getKey() == id) {
                    printService.print("Ammout is :" + recordEntry.getValue().getAmount());
                    printService.print(MENU_ENTRY);
                    choice = scanner.nextInt();
                    if (choice == 1) {
                        printService.print(" enter new ammount");
                        recordEntry.getValue().setAmount(scanner.nextBigDecimal());
                    }
                    printService.print("Record date is :" + recordEntry.getValue().getRecordDate());
                    printService.print(MENU_ENTRY);
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        printService.print(" enter new date : format yyyy-MM-dd");
                        String date = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate localDate = LocalDate.parse(date, formatter);
                        recordEntry.getValue().setRecordDate(localDate);
                    }
                    printService.print("Record description is :" + recordEntry.getValue().getRecordDescription());
                    printService.print(MENU_ENTRY);
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        printService.print(" enter new description");
                        recordEntry.getValue().setRecordDescription(scanner.nextLine());
                    }
                    if (recordEntry.getValue() instanceof IncomeRecord) {
                        printService.print("Income category is: " + ((IncomeRecord) recordEntry.getValue()).getIncomeCategory());
                    }
                    if (recordEntry.getValue() instanceof ExpensesRecord) {
                        printService.print("Expenses category is: " + ((ExpensesRecord) recordEntry.getValue()).getExpenseCategory());
                    }
                    printService.print(MENU_ENTRY);
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        printService.print(" enter new category");
                        String category = scanner.nextLine();
                        if (recordEntry.getValue() instanceof IncomeRecord) {
                            ((IncomeRecord) recordEntry.getValue()).setIncomeCategory(category);
                        } else if (recordEntry.getValue() instanceof ExpensesRecord) {
                            ((ExpensesRecord) recordEntry.getValue()).setExpenseCategory(category);
                        }
                    }
                    printService.print("edited record :" + recordEntry.getValue());
                }
            }
        }
        catch (InputMismatchException exception) {
            System.out.println("bad input");
            scanner.nextLine();
        }
    }

    public void deleteRecordByID() {
        try {
            printService.print("please input ID of record to delete");
            int idToDelete = scanner.nextInt();
            recordList.remove(idToDelete);
        } catch (InputMismatchException ex) {
            System.out.println("bad input");
            scanner.nextLine();
        }
    }

    public BigDecimal checkBalance() {
        BigDecimal sumOfIncome = new BigDecimal(0);
        BigDecimal sumOfExpenses = new BigDecimal(0);
        for (Record record : recordList.values()) {
            if (record instanceof IncomeRecord) {
                BigDecimal amount = record.getAmount();
                sumOfIncome = sumOfIncome.add(amount);
            }
            if (record instanceof ExpensesRecord) {
                BigDecimal amount = record.getAmount();
                sumOfExpenses = sumOfExpenses.add(amount);
            }
        }
        return sumOfIncome.subtract(sumOfExpenses);
    }
}










