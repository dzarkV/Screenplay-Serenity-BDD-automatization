package com.challenge.utilities;

import com.challenge.models.UserData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.challenge.utilities.OpenFile.fromPath;

public class CsvToUsersDataRegistry {

    private CsvToUsersDataRegistry(){}

    public static List<UserData> fromCsvToUsersData() {
        List<UserData> listOfUsers = new ArrayList<>();

        try {
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(
                    fromPath("src/test/resources/testdata/examples_registry.csv"));

            records.forEach(
                    csvRecord -> listOfUsers.add(new UserData(csvRecord.get("nombre"), csvRecord.get("apellido"),
                            csvRecord.get("edad"), csvRecord.get("email"),
                            csvRecord.get("salario"), csvRecord.get("departamento")))
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listOfUsers;
    }


}
