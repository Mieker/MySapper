package com.mieker.saperui.application;

public class Styller {

    public String setButtonColor(int coveredNum) {
        String fontWeight = "-fx-font-weight: 700; ";

        switch (coveredNum) {
            case 1:
                return fontWeight + "-fx-text-fill: blue; ";

            case 2:
                return fontWeight + "-fx-text-fill: green; ";

            case 3:
                return fontWeight + "-fx-text-fill: red; ";

            case 4:
                return fontWeight + "-fx-text-fill: navy; ";

            case 5:
                return fontWeight + "-fx-text-fill: brown; ";

            case 6:
                return fontWeight + "-fx-text-fill: lightblue; ";

            case 7:
                return fontWeight + "-fx-text-fill: orange; ";

            case 8:
                return fontWeight + "-fx-text-fill: white; ";

            default:
                return fontWeight + "-fx-text-fill: black; ";
        }
    }
}
