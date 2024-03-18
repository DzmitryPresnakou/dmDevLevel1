package com.presnakou.multithreading.model;

import com.presnakou.multithreading.enums.CrystalType;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

    private final Map<CrystalType, Integer> cristals = new HashMap<>();
    private final String name;

    public Race(String name) {
        this.name = name;
    }

    public void addCristals(List<CrystalType> list) {
        list.forEach(detail -> cristals.merge(detail, 1, Integer::sum));
    }

    public String getName() {
        return name;
    }

    public Map<CrystalType, Integer> getCristals() {
        return cristals;
    }
}
