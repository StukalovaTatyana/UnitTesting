package ru.asu.types;

import java.util.Objects;

public class MyInt {

    private String valueString;

    public MyInt(int value) {
        this.valueString = String.valueOf(value);
    }

    public MyInt(String value) {
        this.valueString = value;
    }

    public MyInt(byte[] value) {
        this.valueString = String.valueOf(value);
    }

    public MyInt add(MyInt value) {
        StringBuilder result = new StringBuilder();

        int razn = this.valueString.length() - value.valueString.length();
        this.valueString = "0" + this.valueString;
        value.valueString = "0" + value.valueString;
        if (razn > 0) {
            value.addZero(razn);
        } else if (razn < 0) {
            this.addZero(razn);
        }

        this.reverse();
        value.reverse();

        int shift = 0;
        for (int i = 0; i < this.valueString.length(); i++) {
            int a = Character.getNumericValue(this.valueString.charAt(i));
            int b = Character.getNumericValue(value.valueString.charAt(i));

            int res = a + b + shift;

            result.append(res%10);
            shift = res/10;
        }
        result.reverse();
        if (result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }


        MyInt r = new MyInt(result.toString());
        return r;
    }

    public MyInt subtract(MyInt value) {
        return null;
    }

    public MyInt multiply(MyInt value) {
        return null;
    }

    public MyInt max(MyInt value) {
        return null;
    }

    public MyInt min(MyInt value) {
        return null;
    }

    public MyInt abs(MyInt value) {
        return null;
    }

    public MyInt compareTo(MyInt value) {
        return null;
    }

    public MyInt gcd(MyInt value) {
        return null;
    }

    public MyInt toString(MyInt value) {
        return null;
    }

    public MyInt longValue(MyInt value) {
        return null;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public void reverse() {
        StringBuilder stringBuilder = new StringBuilder(this.valueString);
        stringBuilder.reverse();
        this.valueString = stringBuilder.toString();
    }

    public void addZero(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.abs(number); i++) {
            stringBuilder.append("0");
        }
        stringBuilder.append(this.valueString);
        this.valueString = stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyInt myInt = (MyInt) o;
        return Objects.equals(valueString, myInt.valueString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueString);
    }
}
