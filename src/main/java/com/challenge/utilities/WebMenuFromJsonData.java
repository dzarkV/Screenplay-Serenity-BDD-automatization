package com.challenge.utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WebMenuFromJsonData {

    private WebMenuFromJsonData(){}
    public static List<String> fromJsonFileToListString(String flow){
        JSONParser parser = new JSONParser();
        JSONObject flowData;
        List<String> listElements = new ArrayList<>();

        try {
            flowData = (JSONObject) parser.parse(
                    (new FileReader("src/test/resources/testdata/web_menu.json")));
            JSONObject obj = (JSONObject) flowData.get(flow);
            listElements.add(obj.keySet().toString().replaceAll("[\\[\\]]",""));
            listElements.add(obj.values().toString().replaceAll("[\\[\\]]",""));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        return listElements;
    }

}
