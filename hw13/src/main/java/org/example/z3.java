package org.example;

// Определение функционального интерфейса
@FunctionalInterface
interface QuadraticFormula {
    double calculateDiscriminant(double a, double b, double c);
}

public class z3 {
    public static void main(String[] args) {
        // Создание объекта интерфейса с помощью лямбда-выражения
        QuadraticFormula formula = (a, b, c) -> b * b - 4 * a * c;

        // Пример использования
        double a = 5;
        double b = 7;
        double c = 3;
        double discriminant = formula.calculateDiscriminant(a, b, c);
        System.out.println("Дискриминант: " + discriminant);
    }


}
