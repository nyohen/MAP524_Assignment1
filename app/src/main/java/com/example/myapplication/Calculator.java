package com.example.myapplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calculator
{
    private final List<String> userValues = new ArrayList<>();
    public Calculator() {}

    public void push(String input) {
        userValues.add(input);
    }

    public String calculate()      //changed to String method to fix incompatible types error
    {
        boolean checkState;
        int total = 0;
        String output;

        checkState = true;
        for(int i = 0; i < userValues.size()
                && userValues.size() >= 3 && checkState; i++)
        {
            if(i == 0) {
                try {   total = Integer.parseInt(userValues.get(i));    }
                catch (NumberFormatException e) {  checkState = false; }
            }

            if ((i >= 2) && (i%2 == 0)) {
                if (operatorScan(userValues.get(i - 1)))
                {
                    try {
                        total = method(total, Integer.parseInt(userValues.get(i)),
                                userValues.get(i - 1));
                    } catch (NumberFormatException e) {   checkState = false;    }
                } else {  checkState = false;   }
            }
        }

        if(!checkState) {   output = "failed";  }
        else {   output = Integer.toString(total); }
        return output;
    }

    private int method(int first, int second, String symbol)
    {
        int initial = 0;
        switch (symbol)
        {
            case "+":
                initial = first + second;
                break;
            case "*":
                initial = first * second;
                break;
            case "-":
                initial = first - second;
                break;
            case "/":
                initial = first / second;
                break;
            default:
                break;
        }
        return initial;
    }

    private boolean operatorScan(String symbol) {
        return (Objects.equals(symbol, "+") || Objects.equals(symbol, "-")
                || Objects.equals(symbol, "*") || Objects.equals(symbol, "/"));
    }

    public void clear() {   userValues.clear();    }
}