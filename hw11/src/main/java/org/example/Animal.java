package org.example;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Animal {
    private String title;
    private boolean isAvailable;
    private boolean isSold;
    private Map<String, String> photosMap;

    @Override
    public String toString() {
        return "Animal{" +
                "title='" + title + '\'' +
                ", isAvailable=" + isAvailable +
                ", isSold=" + isSold +
                ", photosMap=" + photosMap +
                '}';
    }
}

