package com.company;

class ArabicCalculator extends Calculator<Integer> {

    @Override
    public ArabicCalculator addition(Integer number) {
        value+=validate(number);
        return this;
    }

    @Override
    public ArabicCalculator subtraction(Integer number) {
        value-=validate(number);
        return this;
    }

    @Override
    public ArabicCalculator multiplication(Integer number) {
        value*=validate(number);
        return this;
    }

    @Override
    public ArabicCalculator division(Integer number) {
        value/=validate(number);
        return this;
    }

    @Override
    public String getValue() {
        return "" + getResult();
    }

    @Override
    public Integer validate(Integer number) throws IllegalArgumentException {
        if (number < -32768 || number > 32767)
            throw new IllegalArgumentException(number + " Не находится в пределе [-32768,32767]");
        return number;
    }

}
