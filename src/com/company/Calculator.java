package com.company;

import java.util.IllegalFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Calculator<T> {

    protected T value = null;

    public abstract Calculator<T> addition(T value);

    public abstract Calculator<T> subtraction(T value);

    public abstract Calculator<T> multiplication(T value);

    public abstract Calculator<T> division(T value);

    public abstract String getValue();

    public abstract T validate(T value) throws IllegalArgumentException;

    public Calculator<T> init(T value) {
        this.value = validate(value);
        return this;
    }

    public T getResult() {
        return value;
    }

    public Calculator<T> calc(T number1,T number2,char operation) {
        init(number1);
        switch (operation) {
            case '+':
                addition(number2);
                break;
            case '-':
                subtraction(number2);
                break;
            case '*':
                multiplication(number2);
                break;
            case '/':
                division(number2);
                break;
        }

        return this;
    }

    public static String calc(String s) throws IllegalFormatException {
        Pattern p = Pattern.compile("^([\\-]?[\\d]+)[\\s]?([+\\-/*]{1})[\\s]?([\\-]?[\\d]+)$");
        Matcher m = p.matcher(s);

        if (m.matches()) {

            ArabicCalculator c = new ArabicCalculator();
            return c.calc(
                    new Integer(m.group(1)),
                    new Integer(m.group(3)),
                    m.group(2).charAt(0)
            ).getValue();
        } else {
            p = Pattern.compile("^([IVXLCDM]+)[\\s]?([+\\-/*]{1})[\\s]?([IVXLCDM]+)$");
            m = p.matcher(s);
            if (m.matches()) {

                RomanCalculator c = new RomanCalculator();
                return c.calc(
                        m.group(1),
                        m.group(3),
                        m.group(2).charAt(0)
                ).getValue();
            }
        }
        throw new IllegalArgumentException(s + " - Неверное значение");
    }
}
