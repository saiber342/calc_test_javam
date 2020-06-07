package com.company;

class RomanCalculator extends ArabicCalculator {

    @Override
    public String getValue() {
        return RomanNumeral.toRoman(getResult());
    }

    public RomanCalculator init(String value) {
        init(RomanNumeral.toArabic(value));
        return this;
    }

    public RomanCalculator addition(String number) {
        addition(RomanNumeral.toArabic(number));
        return this;
    }

    public RomanCalculator subtraction(String number) {
        subtraction(RomanNumeral.toArabic(number));
        return this;
    }

    public RomanCalculator multiplication(String number) {
        multiplication(RomanNumeral.toArabic(number));
        return this;
    }

    public RomanCalculator division(String number) {
        division(RomanNumeral.toArabic(number));
        return this;
    }

    public RomanCalculator calc(String number1,String number2,char operation) {
        calc(RomanNumeral.toArabic(number1),RomanNumeral.toArabic(number2),operation);
        return this;
    }
}

