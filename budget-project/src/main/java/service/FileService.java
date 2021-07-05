package service;

import model.Record;

import java.io.IOException;
import java.util.Map;

public interface FileService  {
    void writeDataToFile(Map<Integer, Record> recordList) throws IOException;
   Map<Integer, Record> readDataFromFile() throws IOException;

}
