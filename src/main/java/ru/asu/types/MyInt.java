package ru.asu.types;

import java.util.Objects;

public class MyInt {

    private String valueString;
    private int sign;
    private final String reg = "-?[0-9]*";

    public MyInt(int value) {
        this.valueString = String.valueOf(value);
        boolean regex = this.valueString.matches(reg);
        boolean regex1 = String.valueOf(value).matches(reg);

        if (!regex || !regex1){
            System.out.println("Некорректный ввод числа");
            this.valueString = "0";
        }

        if (value < 0) {
            this.sign = 1;
            this.valueString = this.getValueString().substring(1, this.valueString.length());
        } else {
            this.sign = 0;
        }
    }

    public MyInt(String value) {
        this.valueString = value;
        boolean regex = this.valueString.matches(reg);
        boolean regex1 = value.matches(reg);

        if (!regex || !regex1){
            System.out.println("Некорректный ввод числа");
            this.valueString = "0";
        }
        if (value.charAt(0) == '-') {
            this.sign = 1;
            this.valueString = this.getValueString().substring(1, this.valueString.length());
        } else {
            this.sign = 0;
        }
    }

    public MyInt(byte[] value) {
        this.valueString = String.valueOf(value);
        boolean regex = this.valueString.matches(reg);
        boolean regex1 = String.valueOf(value).matches(reg);

        if (!regex || !regex1){
            System.out.println("Некорректный ввод числа");
            this.valueString = "0";
        }

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
        MyInt result = new MyInt("0");

        this.reverse();
        value.reverse();

        int shift = 0;
        StringBuilder zeros = new StringBuilder();
        for (int i = 0; i < this.valueString.length(); i++) {
            StringBuilder res = new StringBuilder();
            res.append(zeros.toString());
            for (int j = 0; j < value.valueString.length(); j++) {
                int a = Character.getNumericValue(this.valueString.charAt(i));
                int b = Character.getNumericValue(value.valueString.charAt(j));
                int x = a * b + shift;

                res.append(x%10);
                shift = x/10;
            }
            if (shift != 0) {
                res.append(shift);
            }
            shift = 0;
            zeros.append("0");

            res.reverse();
            result = result.sum(new MyInt(res.toString()));
        }
        this.reverse();
        value.reverse();
        if (result.valueString.charAt(0) == '0') {
            result.valueString = result.valueString.substring(1);
        }
        if (this.sign + value.sign == 1) {
            result.sign = 1;
        }
        return result;
        /*result = new StringBuilder(dropZero(result));
        if (myIntSign != signSecond && !String.valueOf(result).equals("0")) result.insert(0, '-');
        return String.valueOf(result);*/
    }

    public MyInt max(MyInt value) {
        if (this.sign != value.sign) {
            if (this.sign == 1) {
                return value;
            }
            return this;
        }

        int razn = this.valueString.length() - value.valueString.length();
        int flag = minMax(value, razn);

        MyInt min;
        MyInt max;
        if (flag == 0) {
            max = this;
            min = value;
        } else {
            max = value;
            min = this;
        }

        if (this.sign == 0) {
            return max;
        } else {
            return min;
        }
    }

    public MyInt min(MyInt value) {
        if (this.sign != value.sign) {
            if (this.sign == 1) {
                return this;
            }
            return value;
        }

        int razn = this.valueString.length() - value.valueString.length();
        int flag = minMax(value, razn);

        MyInt min;
        MyInt max;
        if (flag == 0) {
            max = this;
            min = value;
        } else {
            max = value;
            min = this;
        }

        if (this.sign == 0) {
            return min;
        } else {
            return max;
        }
    }

    public MyInt abs() {
        return new MyInt(this.valueString);
    }

    public int compareTo(MyInt value) {
        if (this.sign != value.sign) {
            if (this.sign == 1) {
                return -1;
            }
            return 1;
        }

        if (this.equals(value)) {
            return 0;
        }

        MyInt max = this.max(value);
        if (this.equals(max)) {
            return 1;
        } else {
            return -1;
        }
    }

    public String gcd(MyInt value) {
        if (this.valueString.equals("0")) {
            return value.valueString;
        } else if (value.valueString.equals("0")) {
            return this.valueString;
        }
        MyInt myInt = simpleGcd(this.max(value), this.min(value));
        return myInt.valueString;
    }

    public String toString() {
        String printedSing = this.sign == 1 ? "-" : "";
        return printedSing + this.valueString;
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
        int flag = minMax(value, razn);

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
            resultSign = this.sign;
        } else {
            resultSign = value.sign;
        }

        result.reverse();
        this.reverse();
        value.reverse();

        if (this.valueString.charAt(0) == '0') {
            this.valueString = this.valueString.substring(1);
        }
        if (value.valueString.charAt(0) == '0') {
            value.valueString = value.valueString.substring(1);
        }
        if (result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        MyInt r = new MyInt(result.toString());
        if (resultSign == 1 && !String.valueOf(result).equals("0")) {
            r.sign = 1;
        }
        return r;
    }

    private int minMax(MyInt value, int razn) {
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
        return flag;
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
        return sign == myInt.sign &&
                Objects.equals(valueString, myInt.valueString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueString, sign);
    }

    private MyInt simpleGcd(MyInt first, MyInt second) {
        if (first.valueString.equals("0"))
            return first;
//        return simpleGcd(second, getSurplus(first, second));
        int compare = first.compareTo(second);
        if (compare == 1) {
            MyInt subtract = first.subtract(second);
            return simpleGcd(subtract, second);
        } else if (compare == -1) {
            MyInt subtract = second.subtract(first);
            return simpleGcd(first, subtract);
        } else {
            return first;
        }
    }

    private String getSurplus(String first, String second) {
        int restGreater = 1;
        while (restGreater == 1) {
            StringBuilder result = new StringBuilder();
            minus(first, second, result);
            first = result.toString();
            restGreater = first.compareTo(second);
        }
        return first;
    }
}
