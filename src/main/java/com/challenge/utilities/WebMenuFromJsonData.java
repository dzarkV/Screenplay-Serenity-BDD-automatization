package com.challenge.utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

import static com.challenge.utilities.OpenFile.fromPath;

public class WebMenuFromJsonData {

    private WebMenuFromJsonData(){}
    public static List<String> fromJsonFileToListString(String flow){
        JSONParser parser = new JSONParser();
        List<String> listElements = new ArrayList<>();

        try {
            JSONObject flowData = (JSONObject) parser.parse(fromPath("src/test/resources/testdata/web_menu.json"));
            JSONObject obj = (JSONObject) flowData.get(flow);
            listElements.add(obj.keySet().toString().replaceAll("[\\[\\]]",""));
            listElements.add(obj.values().toString().replaceAll("[\\[\\]]",""));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        return listElements;
    }

}
