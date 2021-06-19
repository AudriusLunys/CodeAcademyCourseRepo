package service;

import model.ExpensesRecord;
import model.IncomeRecord;
import model.Record;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileServiceImpl implements FileService {
    private String FILE_PATH = "src/budgetFile.csv";

    @Override
    public void writeDataToFile(Map<Integer, Record> recordList) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        recordList.forEach((integer, record) -> {
            try {
                bufferedWriter.write(integer.toString());
                bufferedWriter.write(",");
                bufferedWriter.write(record.getAmount().toString());
                bufferedWriter.write(",");
                bufferedWriter.write(record.getRecordDate().toString());
                bufferedWriter.write(",");
                bufferedWriter.write(record.getRecordDescription());
                bufferedWriter.write(",");
                if (record instanceof ExpensesRecord) {
                    bufferedWriter.write((((ExpensesRecord) record).getExpenseCategory()));
                }
                if (record instanceof IncomeRecord) {
                    bufferedWriter.write((((IncomeRecord) record).getIncomeCategory()));
                }
                bufferedWriter.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bufferedWriter.close();
    }
}


