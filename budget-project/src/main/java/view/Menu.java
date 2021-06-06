package view;
import model.Record;
import model.exception.WrongSelectionInputException;
import service.Budget;
import service.PrintService;
import java.util.Scanner;

public class Menu {

    private PrintService printService = new PrintService();
    private Budget budget = new Budget();
    private Scanner scanner = new Scanner(System.in);

    private void displayMenu() {
        printService.print("**** Budget App Menu ***" + '\n' +
                "1 - Add record" + '\n' +
                "2 - Show all records" + '\n' +
                "3 - Get all income records" + '\n' +
                "4 - Get all expense records" + '\n' +
                "5 - Edit record by ID" + '\n' +
                "6 - Delete  record by ID" + '\n' +
                "7 - Get balance" + '\n' +
                "0 - exit program " + '\n' +
                "please enter your choice "
        );
    }

    public void run() {
        int userChoice;
        do {
            displayMenu();
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    Record record = null;
                    try {
                        record = budget.createRecord();
                    } catch (WrongSelectionInputException ex) {
                        printService.print(ex.getMessage());
                    }
                    budget.addRecord(record);
                    break;
                case 2:
                    budget.showAllRecords();
                    break;
                case 3:
                    printService.print("" + '\n' + budget.getAllIncomeRecords());
                    break;
                case 4:
                    printService.print("" + '\n' + budget.getAllExpencesRecords());
                    break;
                case 5:
                    budget.editSelectedRecord();
                    break;
                case 6:
                    budget.deleteRecordByID();
                    break;
                case 7:
                    printService.print("balance : " + budget.checkBalance());
                    break;
                default:
                    System.out.println("something went wrong");
                    break;
            }
        } while (userChoice != 0);

    }

}


