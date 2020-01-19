package ru.asu.types;

import java.util.Objects;

public class MyInt {

    private String valueString;
    private int sign;

    public MyInt(int value) {
        this.valueString = String.valueOf(value);
        if (value < 0) {
            this.sign = 1;
            this.valueString = this.getValueString().substring(1, this.valueString.length());
        } else {
            this.sign = 0;
        }
    }

    public MyInt(String value) {
        this.valueString = value;
        if (value.charAt(0) == '-') {
            this.sign = 1;
            this.valueString = this.getValueString().substring(1, this.valueString.length());
        } else {
            this.sign = 0;
        }
    }

    public MyInt(byte[] value) {
        this.valueString = String.valueOf(value);
        if (((char) value[0]) == '-') {
            this.sign = 1;
            this.valueString = this.getValueString().substring(1, this.valueString.length());
        } else {
            this.sign = 0;
        }
    }

    public MyInt add(MyInt value) {
        if (this.sign == 0 && value.sign == 0) {
            return this.sum(value);
        } else if (this.sign == 0 && value.sign == 1) {
            return this.minus(value);
        } else if (this.sign == 1 && value.sign == 0) {
            return value.minus(this);
        } else {
            MyInt sum = this.sum(value);
            sum.sign = sum.sign == 0 ? 1 : 0;
            return sum;
        }
    }

    public MyInt subtract(MyInt value) {
        if (this.sign == 0 && value.sign == 0) {
            return this.minus(value);
        } else if (this.sign == 0 && value.sign == 1) {
            return this.sum(value);
        } else if (this.sign == 1 && value.sign == 0) {
            MyInt sum = this.sum(value);
            sum.sign = sum.sign == 0 ? 1 : 0;
            return sum;
        } else {
            return value.minus(this);
        }
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

    private MyInt sum(MyInt value) {
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

            result.append(res % 10);
            shift = res / 10;
        }
        result.reverse();
        if (result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        MyInt r = new MyInt(result.toString());
        return r;
    }

    private MyInt minus(MyInt value) {
        StringBuilder result = new StringBuilder();
        int razn = this.valueString.length() - value.valueString.length();
        int flag = 0;
        if (razn > 0) {
            flag = 0;
        } else if (razn < 0) {
            flag = 1;
        } else {
            for (int i = 0; i < this.valueString.length(); i++) {
                int a = Character.getNumericValue(this.valueString.charAt(i));
                int b = Character.getNumericValue(value.valueString.charAt(i));
                if (a > b) {
                    flag = 0;
                    break;
                } else if (a < b) {
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 1) {
            this.addZero(razn);
            this.reverse();
            value.reverse();

            minus(value.valueString, this.valueString, result);
        } else {
            value.addZero(razn);
            this.reverse();
            value.reverse();

            minus(this.valueString, value.valueString, result);
        }

        int resultSign;
        if (flag == 0) {
            resultSign = this.sign;
        } else if (this.sign == value.sign) {
            resultSign = Math.abs(this.sign - 1);
        } else {
            resultSign = value.sign;
        }

        result.reverse();

        if (result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        MyInt r = new MyInt(result.toString());
        if (resultSign == 1 && !String.valueOf(result).equals("0")) {
            r.sign = 1;
        }
        return r;
    }

    private void minus(String first, String second, StringBuilder result) {
        int adder = 10;
        int regulator = 0;
        for (int i = 0; i < first.length(); i++) {
            int a = Character.getNumericValue(first.charAt(i));
            int b = Character.getNumericValue(second.charAt(i));

            int x = a + adder - regulator - b;
            regulator = 1;
            if (x >= adder) {
                x -= adder;
                regulator = 0;
            }
            result.append(x);
        }
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

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
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
