package com.challenge.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class OpenFile {

    private OpenFile(){}

    public static Reader fromPath(String path) throws FileNotFoundException {
        return new FileReader(path);
    }
}
