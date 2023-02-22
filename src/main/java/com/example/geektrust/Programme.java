package com.example.geektrust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programme {

    private Map<String, Integer> quantityOfProgammes = new HashMap<>();
    List<String> typeOfProgrammes;
    List<Double> costOfProgrammes;


    public Map<String, Integer> getQuantityOfProgammes() {
        return quantityOfProgammes;
    }

    public void setQuantityOfProgammes(Map<String, Integer> quantityOfProgammes) {
        this.quantityOfProgammes = quantityOfProgammes;
    }

    Programme() {
        quantityOfProgammes = new HashMap<>();
        typeOfProgrammes = new ArrayList<>();
        typeOfProgrammes.add(Constants.CERTIFICATE);
        typeOfProgrammes.add(Constants.DEGREE);
        typeOfProgrammes.add(Constants.DIPLOMA);
        costOfProgrammes = new ArrayList<>();
        costOfProgrammes.add(Constants.COST_CERTIFICATE);
        costOfProgrammes.add(Constants.COST_DEGREE);
        costOfProgrammes.add(Constants.COST_DIPLOMA);
    }
    public void addProgramme(String program, Integer quantity) {
        Map<String, Integer> map = getQuantityOfProgammes();
        map.put(program, quantity);
        setQuantityOfProgammes(map);
    }

}
