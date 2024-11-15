package com.example.exercise9;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CalculatorController {
    @FXML private Text result;
    @FXML private TextField numFiled1;
    @FXML private TextField numFiled2;

    @FXML protected void divideBtn() {
        calculate('/');
    }

    @FXML protected void multiplyBtn() {
        calculate('*');
    }

    @FXML protected void addBtn() {
        calculate('+');
    }

    @FXML protected void subtractBtn() {
        calculate('-');
    }

    @FXML protected void clearBtn() {
        result.setText("");
        numFiled1.clear();
        numFiled2.clear();
    }

    private void calculate(char btn) {
        try {
            int num1 = Integer.parseInt(numFiled1.getText());
            int num2 = Integer.parseInt(numFiled2.getText());
            int res = 0;

            switch (btn) {
                case '/':
                    if (num2 != 0) {
                        double r = (double) num1 / num2;
                        result.setText(num1 + " over " + num2 + " equals " + r);
                    } else {
                        result.setText("number2 cannot be 0");
                    }
                    break;
                case '*':
                    res = num1 * num2;
                    result.setText(num1 + " multiply " + num2 + " equals " + res);
                    break;
                case '+':
                    res = num1 + num2;
                    result.setText(num1 + " plus " + num2 + " equals " + res);
                    break;
                case '-':
                    res = num1 - num2;
                    result.setText(num1 + " subtract " + num2 + " equals " + res);
                    break;
            }
        }catch (NumberFormatException e) {
            result.setText("Please enter right number");
        }
    }
}
