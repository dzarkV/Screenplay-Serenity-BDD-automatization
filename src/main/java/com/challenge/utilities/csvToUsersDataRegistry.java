package com.challenge.utilities;

import com.challenge.models.UserData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class csvToUsersDataRegistry {

    public static List<UserData> fromCsvToUsersData() {
        Reader filereader;
        List<UserData> listOfUsers = new ArrayList<>();

        try {
            filereader = new FileReader("src/test/resources/testdata/examples_registry.csv");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(filereader);

            for (CSVRecord record : records) {
                listOfUsers.add(new UserData(record.get("nombre"), record.get("apellido"),
                                record.get("edad"), record.get("email"),
                                record.get("salario"), record.get("departamento")));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return listOfUsers;
    }


}
