package org.example;

import java.util.Arrays;
import java.util.List;

import static org.example.mapToProd.mapToProductDto;


public class Main {
    public static void main(String[] args) throws Exception {
        Pet cat = new Pet("Барсик", Status.AVAILABLE,
                List.of(new Photo("Барсик с цветочком",
                                "https://placekitten.com/200/300"),
                        new Photo("Барсик на ручках",
                                "https://placekitten.com/500/605")
                ));
        Animal animalCat = mapToProductDto(cat);
        System.out.println(animalCat);
    }

}

