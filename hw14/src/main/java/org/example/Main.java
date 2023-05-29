package org.example;

public class Main {
    public static void main(String[] args) {
        String commandString = "-importkeystore true -srckeystore kafka.jks -destkeystore kafka.p12 -deststoretype PKCS12";

        Command command = new Command(commandString);
        String convertedString = command.getConvertedString();
        System.out.println("Converted String: " + convertedString);

        MultiplicationTable table = new MultiplicationTable();
        table.printTable();
    }
}
