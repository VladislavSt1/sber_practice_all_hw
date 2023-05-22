package org.example;

// Определение функционального интерфейса
interface NumberChecker {
    boolean check(int number);
}

public class z1 {
    public static void main(String[] args) {
        // Реализация интерфейса с помощью лямбда-выражения
        NumberChecker checker = (number) -> number % 13 == 0;

        // Пример использования
        int number = 27;
        boolean result = checker.check(number);
        System.out.println(result); // Выведет: false

        number = 39;
        result = checker.check(number);
        System.out.println(result); // Выведет: true
    }
}
