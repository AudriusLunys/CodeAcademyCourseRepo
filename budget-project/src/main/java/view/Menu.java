package view;
import model.Record;
import exception.WrongSelectionInputException;
import service.Budget;
import service.FileServiceImpl;
import service.PrintService;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private FileServiceImpl fileService = new FileServiceImpl();
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
                "8 - Write records to file" + '\n' +
                "9 - Get records from file" + '\n' +
                "0 - exit program " + '\n' +
                "please enter your choice "
        );
    }

    public void run() throws IOException {
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
                case 8:
                    fileService.writeDataToFile(budget.getRecords());
                    break;
                case 9:
                    fileService.readDataFromFile();
                    printService.print("records read");
                    break;
                default:
                    System.out.println("something went wrong");
                    break;
            }
        } while (userChoice != 0);

    }

}


