package org.example;

import java.util.ArrayList;
import java.util.List;

public class Multiplier {
    public static int multiplyEvenNumbers(int a, int b) throws CustomException {
        List<Integer>  evenNumbers= new ArrayList<>();
        if ((a % 2 != 0) & (b % 2 != 0)){
            throw new CustomException("Both numbers are not even.");
        }
        if(a % 2 != 0){
            throw new CustomException("First number is not even");
        } else {
            evenNumbers.add(a);
        }

        if(b % 2 != 0){
            throw new CustomException("Second number is not even");
        } else {
            evenNumbers.add(b);
        }
        return evenNumbers.get(0) * evenNumbers.get(1);
    }
}
