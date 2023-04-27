package org.example;

public class Messages {
    @Paint(style = "-", color = Paint.RED)
    public String customMessage1() { return "customMessage1";}

    @Paint(style = "!", color = Paint.YELLOW)
    public String customMessage2() { return "customMessage2";}

    @Paint(style = "*", color = Paint.PURPLE)
    public String customMessage3() { return "customMessage3";}

    @Paint(style = "#", color = Paint.CYAN)
    public String customMessage4() {return "customMessage4";}
}

