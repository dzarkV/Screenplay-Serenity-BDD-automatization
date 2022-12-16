package com.challenge.utilities;

import com.challenge.models.UserData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvToUsersDataRegistry {

    private CsvToUsersDataRegistry(){}

    public static List<UserData> fromCsvToUsersData() {
        Reader csvFileReader;
        List<UserData> listOfUsers = new ArrayList<>();

        try {
            csvFileReader = new FileReader("src/test/resources/testdata/examples_registry.csv");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(csvFileReader);

            for (CSVRecord csvRecord : records) {
                listOfUsers.add(new UserData(csvRecord.get("nombre"), csvRecord.get("apellido"),
                                csvRecord.get("edad"), csvRecord.get("email"),
                                csvRecord.get("salario"), csvRecord.get("departamento")));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listOfUsers;
    }


}
