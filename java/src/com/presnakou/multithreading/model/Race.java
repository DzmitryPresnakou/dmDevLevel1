package com.presnakou.multithreading.model;

import java.util.HashMap;
import java.util.Map;

public class Race {

    private final Map<String, Integer> cristals = new HashMap<>();
    private final String name;

    public Race(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getCristals() {
        return cristals;
    }
}
