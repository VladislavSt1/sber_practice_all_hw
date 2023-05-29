package org.example;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultiplicationTable {
    public void printTable() {
        Stream.iterate(2, i -> i <= 9, i -> i + 1)
                .flatMap(i -> Stream.iterate(2, j -> j <= 9, j -> j + 1)
                        .map(j -> i + " * " + j + " = " + (i * j)))
                .forEach(System.out::println);
    }
}
