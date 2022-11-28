package com.mieker.mysapper.application;

public class Styller {

    public String setButtonColor(int coveredNum) {
        String fontWeight = "-fx-font-weight: 700; ";

        return switch (coveredNum) {
            case 1 -> fontWeight + "-fx-text-fill: blue; ";
            case 2 -> fontWeight + "-fx-text-fill: green; ";
            case 3 -> fontWeight + "-fx-text-fill: red; ";
            case 4 -> fontWeight + "-fx-text-fill: navy; ";
            case 5 -> fontWeight + "-fx-text-fill: brown; ";
            case 6 -> fontWeight + "-fx-text-fill: lightblue; ";
            case 7 -> fontWeight + "-fx-text-fill: orange; ";
            case 8 -> fontWeight + "-fx-text-fill: white; ";
            default -> fontWeight + "-fx-text-fill: black; ";
        };
    }
}
