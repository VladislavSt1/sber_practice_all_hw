package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultiplierTest {

    @Test
    public void testMultiplyEvenNumbersWithTwoEvenNumbers() {
        try {
            int result = Multiplier.multiplyEvenNumbers(2, 4);
            Assertions.assertEquals(8, result);
        } catch (CustomException e) {
            Assertions.fail("An unexpected CustomException exception was thrown.");
        }
    }

    @Test
    public void testMultiplyEvenNumbersWithOneEvenAndOneOddNumber() {
        Assertions.assertThrows(CustomException.class, () -> Multiplier.multiplyEvenNumbers(3, 4));
    }

    @Test
    public void testMultiplyEvenNumbersWithTwoOddNumbers() {
        Assertions.assertThrows(CustomException.class, () -> Multiplier.multiplyEvenNumbers(3, 5));
    }
}

