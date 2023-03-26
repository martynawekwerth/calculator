package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class calculator {

    @FXML
    private Label labelResult;

    @FXML
    private Label FirstNumber;

    @FXML
    private Label Operation;

    @FXML
    private Label SecondNumber;

    private double Number1 = 0;

    private String operator = "+";


    @FXML
    void onMouseNumberClicked(MouseEvent event) {

        int value = Integer.parseInt(((Button)event.getSource()).getId().replace("button", ""));
        labelResult.setText(String.valueOf(Double.parseDouble(labelResult.getText())==0?Double.valueOf(value):Double.valueOf(Double.parseDouble(labelResult.getText())*10+value)));
    }

    @FXML
    void onMouseOperatorClicked(MouseEvent event) {

        String symbol = ((Button)event.getSource()).getId().replace("button", "");
        if (symbol.equals("Equals")) {
            double Number2 = Double.parseDouble(labelResult.getText());
            switch (operator) {
                case "+" -> labelResult.setText((Number1+Number2) + "");
                case "-" -> labelResult.setText((Number1-Number2) + "");
                case "*" -> labelResult.setText((Number1*Number2) + "");
                case "/" -> labelResult.setText((Number1/Number2) + "");
                case "X^n " -> labelResult.setText((int)Math.pow(Number1, Number2) + "");
            }
            SecondNumber.setText(String.valueOf(Number2));
            Operation.setText(String.valueOf(operator));
            operator = ".";
        } else if (symbol.equals("Clear")) {
            labelResult.setText(String.valueOf(Double.valueOf(0.0)));
            SecondNumber.setText(String.valueOf(0.0));
            Operation.setText(String.valueOf("."));
            FirstNumber.setText(String.valueOf(0.0));
            operator = ".";
        } else if (symbol.equals("Negation")) {
            Number1 = Double.parseDouble(labelResult.getText());
            labelResult.setText((Number1 * -1) + "");
        } else if (symbol.equals("Root"))   {
            Number1 = Double.parseDouble(labelResult.getText());
            labelResult.setText((Math.sqrt(Number1) + ""));
        } else {
            switch (symbol) {
                case "Plus" -> operator = "+";
                case "Minus" -> operator = "-";
                case "Multi" -> operator = "*";
                case "Div" -> operator = "/";
                case "Power" -> operator = "X^n ";
            }
            Number1 = Double.parseDouble(labelResult.getText());
            FirstNumber.setText(String.valueOf(Number1));
            labelResult.setText(String.valueOf(Double.valueOf(0.0)));
        }

    }

}
