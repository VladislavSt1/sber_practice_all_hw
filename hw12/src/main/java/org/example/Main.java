package org.example;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Messages messages = new Messages();
        Class<?> messagesClass = messages.getClass();

        Paint classAnnotation = messagesClass.getAnnotation(Paint.class);
        String classStyle = (classAnnotation != null) ? classAnnotation.style() : "";
        String classColor = (classAnnotation != null) ? classAnnotation.color() : "";

        Method[] methods = messagesClass.getDeclaredMethods();
        for (Method method : methods) {
            Paint methodAnnotation = method.getAnnotation(Paint.class);
            String methodStyle = (methodAnnotation != null) ? methodAnnotation.style() : "";
            String methodColor = (methodAnnotation != null) ? methodAnnotation.color() : "";

            String message = "";
            try {
                message = (String) method.invoke(messages);
            } catch (Exception e) {
                System.err.println("Error invoking method: " + method.getName());
                e.printStackTrace();
            }

            if (!methodStyle.isEmpty()) {
                message = applyStyle(message, methodStyle, methodColor);
            } else if (!classStyle.isEmpty()) {
                message = applyStyle(message, classStyle, classColor);
            }

            System.out.println(message);
        }
    }

    private static String applyStyle(String message, String style, String color) {
        String prefix = "";
        String suffix = Paint.RESET;

        switch (style) {
            case "-":
                prefix = "---- ";
                suffix = " ----";
                break;
            case "!":
                prefix = "!!!! ";
                suffix = " !!!!";
                break;
            case "#":
                prefix = "^^^^ ";
                suffix = " ^^^^";
                break;
            case "*":
                prefix = "**** ";
                suffix = " ****";
                break;
            default:
                prefix = "";
                suffix = Paint.RESET;
                break;
        }

        return color + prefix + message + suffix + Paint.RESET;
    }
}
