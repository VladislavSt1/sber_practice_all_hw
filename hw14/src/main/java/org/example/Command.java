package org.example;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Command {
    private Map<String, String> parameters;

    public Command(String commandString) {
        this.parameters = parseCommand(commandString);
    }

    private Map<String, String> parseCommand(String command) {
        return Stream.of(command.split("\\s+"))
                .filter(token -> token.startsWith("-"))
                .collect(Collectors.toMap(
                        token -> token,
                        token -> getNextToken(command, token)
                ));
    }

    private String getNextToken(String command, String currentToken) {
        String[] tokens = command.split("\\s+");
        int currentIndex = Stream.of(tokens).collect(Collectors.toList()).indexOf(currentToken);
        if (currentIndex < tokens.length - 1) {
            return tokens[currentIndex + 1];
        }
        return "";
    }

    public String getConvertedString() {
        return parameters.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .collect(Collectors.joining(" "));
    }
}
