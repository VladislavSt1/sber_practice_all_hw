package org.example;

// Определение функционального интерфейса
@FunctionalInterface
interface StringComparator {
    String compareStrings(String s1, String s2);
}

public class z2 {
    public static void main(String[] args) {
        StringComparator comparator = (s1, s2) -> s1.length() > s2.length() ? s1 : s2;

        // Пример использования
        String result = comparator.compareStrings("Hello", "Hellooo");
        System.out.println(result);
    }
}
