package org.example;

public class CustomException extends Exception {
    CustomException() {}

    CustomException(String message) {
        super(message);
    }
}
