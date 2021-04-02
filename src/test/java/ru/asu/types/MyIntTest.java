package ru.asu.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MyIntTest {

    @Test
    void reversTest() {
        MyInt a = new MyInt(123);
        a.reverse();
        assertEquals("321", a.getValueString(), "Значения не совпали");
    }

    @Test
    void signIntegerTest() {
        MyInt a = new MyInt(123);
        assertEquals(0, a.getSign());

        a = new MyInt(-13);
        assertEquals(1, a.getSign());

        a = new MyInt(0);
        assertEquals(0, a.getSign());
    }

    @Test
    void signStringTest() {
        MyInt a = new MyInt("123");
        assertEquals(0, a.getSign(), "Знаки не совпали");
        assertEquals("123", a.getValueString());

        a = new MyInt("-13");
        assertEquals(1, a.getSign(), "Знаки не совпали");
        assertEquals("13", a.getValueString());

        a = new MyInt("0");
        assertEquals(0, a.getSign(), "Знаки не совпали");
        assertEquals("0", a.getValueString());

    }

    @Test
    void signByteArrayTest() {
        MyInt a = new MyInt("123".getBytes());
        assertEquals(0, a.getSign());

        a = new MyInt("-13".getBytes());
        assertEquals(1, a.getSign());

        a = new MyInt("0".getBytes());
        assertEquals(0, a.getSign());
    }

    @Test
    void addZeroToBeginTest() {
        MyInt a = new MyInt(123);
        a.addZero(5);
        assertEquals("00000123", a.getValueString());

        a = new MyInt("123");
        a.addZero(-2);
        assertEquals("00123", a.getValueString());

        a = new MyInt("123");
        a.addZero(0);
        assertEquals("123", a.getValueString());
    }

    @Test
    void addPositiveToPositiveTest() {
        MyInt a = new MyInt(123);
        MyInt b = new MyInt(3);

        MyInt c = new MyInt(126);
        MyInt actual = a.add(b);
        assertEquals(c, actual);

        a = new MyInt(89);
        b = new MyInt(11);
        c = new MyInt("100");
        actual = a.add(b);

        assertEquals(c, actual);

        a = new MyInt(2);
        b = new MyInt(3);
        c = new MyInt("5");
        actual = a.add(b);
        assertEquals(c, actual);


        a = new MyInt(3);
        b = new MyInt(123);
        c = new MyInt("126");
        actual = a.add(b);
        assertEquals(c, actual);
    }

    @Test
    void addPositiveToNegativeTest() {
        MyInt a = new MyInt(124);
        MyInt b = new MyInt(-3);
        MyInt c = new MyInt(121);
        MyInt actual = a.add(b);
        assertEquals(c, actual);

        a = new MyInt(89);
        b = new MyInt(-11);
        c = new MyInt("78");
        actual = a.add(b);
        assertEquals(c, actual);

        a = new MyInt(222);
        b = new MyInt(-333);
        c = new MyInt("-111");
        actual = a.add(b);
        assertEquals(c, actual);

        a = new MyInt(3);
        b = new MyInt(-123);
        c = new MyInt("-120");
        actual = a.add(b);
        assertEquals(c, actual);

        a = new MyInt(11);
        b = new MyInt(-2);
        c = new MyInt("9");
        actual = a.add(b);
        assertEquals(c, actual);
    }

    @Test
    void addNegativeToPositive() {
        MyInt a = new MyInt(-11);
        MyInt b = new MyInt(2);
        MyInt c = new MyInt("-9");
        MyInt actual = a.add(b);
        assertEquals(c, actual);

        a = new MyInt(-13);
        b = new MyInt(2);
        c = new MyInt("-11");
        actual = a.add(b);
        assertEquals(c, actual);

        a = new MyInt(-23);
        b = new MyInt(11);
        c = new MyInt("-12");
        actual = a.add(b);
        assertEquals(c, actual);

        a = new MyInt(-23);
        b = new MyInt(31);
        c = new MyInt("8");
        actual = a.add(b);
        assertEquals(c, actual);
    }

    @Test
    void addNegativeToNegative() {
        MyInt a = new MyInt(-11);
        MyInt b = new MyInt(-2);
        MyInt c = new MyInt("-13");
        MyInt actual = a.add(b);
        assertEquals(c, actual);

        a = new MyInt(-91);
        b = new MyInt(-9);
        c = new MyInt("-100");
        actual = a.add(b);
        assertEquals(c, actual);
    }

    @Test
    void subtractPositiveToPositiveTest() {
        MyInt a = new MyInt(124);
        MyInt b = new MyInt(114);
        MyInt c = new MyInt(10);
        MyInt actual = a.subtract(b);
        assertEquals(c, actual);

        a = new MyInt(999);
        b = new MyInt(977);
        c = new MyInt(22);
        actual = a.subtract(b);
        assertEquals(c, actual);

    }

    @Test
    void subtractPositiveToNegativeTest() {
        MyInt a = new MyInt(124);
        MyInt b = new MyInt(-114);
        MyInt c = new MyInt(238);
        MyInt actual = a.subtract(b);
        assertEquals(c, actual);

        a = new MyInt(999);
        b = new MyInt(-977);
        c = new MyInt(1976);
        actual = a.subtract(b);
        assertEquals(c, actual);

    }

    @Test
    void subtractNegativeToPositiveTest() {
        MyInt a = new MyInt(-124);
        MyInt b = new MyInt(114);
        MyInt c = new MyInt(-238);
        MyInt actual = a.subtract(b);
        assertEquals(c, actual);

        a = new MyInt(-999);
        b = new MyInt(977);
        c = new MyInt(-1976);
        actual = a.subtract(b);
        assertEquals(c, actual);

    }

    @Test
    void subtractNegativeToNegativeTest() {
        MyInt a = new MyInt(-124);
        MyInt b = new MyInt(-11432);
        MyInt c = new MyInt(-11308);
        MyInt actual = a.subtract(b);
        assertEquals(c, actual);

        a = new MyInt(-999);
        b = new MyInt(-977);
        c = new MyInt(-22);
        actual = a.subtract(b);
        assertEquals(c, actual);

    }

    @Test
    void absTest() {
        MyInt a = new MyInt("1");
        MyInt abs = new MyInt("1");
        assertEquals(abs, a.abs());

        a = new MyInt("-1");
        abs = new MyInt("1");
        assertEquals(abs, a.abs());

        a = new MyInt("0");
        abs = new MyInt("0");
        assertEquals(abs, a.abs());

        a = new MyInt("0");
        a.setSign(1);
        abs = new MyInt("0");
        assertEquals(abs, a.abs());
    }

    @Test
    void toStringTest() {
        MyInt a = new MyInt("12345");
        String sign = a.getSign() == 1 ? "-" : "";
        assertEquals(sign + a.getValueString(), a.toString());

        a = new MyInt("-12345");
        sign = a.getSign() == 1 ? "-" : "";
        assertEquals(sign + a.getValueString(), a.toString());
    }

    @Test
    void regexTest() {
        MyInt a = new MyInt("0lkh7123");
        assertEquals("0", a.getValueString());

        a = new MyInt(-782110);
        assertEquals("782110", a.getValueString());

        a = new MyInt(782110);
        assertEquals("782110", a.getValueString());

    }

    @Test
    void minTest() {
        MyInt a = new MyInt("12345");
        MyInt b = new MyInt("12344");
        assertEquals(b, a.min(b));
        assertEquals(b, b.min(a));

        a = new MyInt("12");
        b = new MyInt("12");
        assertEquals(a, a.min(b));
        assertEquals(a, b.min(a));

        a = new MyInt("123");
        b = new MyInt("1456");
        assertEquals(a, a.min(b));
        assertEquals(a, b.min(a));

        a = new MyInt("-123");
        b = new MyInt("1456");
        assertEquals(a, a.min(b));
        assertEquals(a, b.min(a));

        a = new MyInt("123");
        b = new MyInt("-1456");
        assertEquals(b, a.min(b));
        assertEquals(b, b.min(a));

        a = new MyInt("6666");
        b = new MyInt("-1456");
        assertEquals(b, a.min(b));
        assertEquals(b, b.min(a));

        a = new MyInt("123");
        b = new MyInt("-123");
        assertEquals(b, a.min(b));
        assertEquals(b, b.min(a));

    }

    @Test
    void maxTest() {
        MyInt a = new MyInt("12345");
        MyInt b = new MyInt("12344");
        assertEquals(a, a.max(b));
        assertEquals(a, b.max(a));

        a = new MyInt("12");
        b = new MyInt("12");
        assertEquals(a, a.max(b));
        assertEquals(a, b.max(a));

        a = new MyInt("123");
        b = new MyInt("1456");
        assertEquals(b, a.max(b));
        assertEquals(b, b.max(a));

        a = new MyInt("-123");
        b = new MyInt("1456");
        assertEquals(b, a.max(b));
        assertEquals(b, b.max(a));

        a = new MyInt("123");
        b = new MyInt("-1456");
        assertEquals(a, a.max(b));
        assertEquals(a, b.max(a));

        a = new MyInt("6666");
        b = new MyInt("-1456");
        assertEquals(a, a.max(b));
        assertEquals(a, b.max(a));

        a = new MyInt("123");
        b = new MyInt("-123");
        assertEquals(a, a.max(b));
        assertEquals(a, b.max(a));
    }

    @Test
    void compareToTest() {
        MyInt a = new MyInt(12);
        MyInt b = new MyInt(12);
        assertEquals(0, a.compareTo(b));
        assertEquals(0, b.compareTo(a));

        a = new MyInt(-12);
        b = new MyInt(-12);
        assertEquals(0, a.compareTo(b));
        assertEquals(0, b.compareTo(a));

        a = new MyInt("6666");
        b = new MyInt("1456");
        assertEquals(1, a.compareTo(b));
        assertEquals(-1, b.compareTo(a));

        a = new MyInt("-6666");
        b = new MyInt("-123");
        assertEquals(-1, a.compareTo(b));
        assertEquals(1, b.compareTo(a));

        a = new MyInt("123");
        b = new MyInt("-123");
        assertEquals(1, a.compareTo(b));
        assertEquals(-1, b.compareTo(a));
    }

    @Test
    void gcd() {
        MyInt a = new MyInt("123");
        MyInt b = new MyInt("123");
        String gcd = a.gcd(b);
        assertEquals("123", gcd);
        gcd = b.gcd(a);
        assertEquals("123", gcd);

        a = new MyInt("15");
        b = new MyInt("80");
        assertEquals("5", a.gcd(b));
        assertEquals("5", b.gcd(a));

        a = new MyInt("0");
        b = new MyInt("80");
        assertEquals("80", a.gcd(b));
        assertEquals("80", b.gcd(a));

        a = new MyInt("80");
        b = new MyInt("0");
        assertEquals("80", a.gcd(b));
        assertEquals("80", b.gcd(a));
    }

    @Test
    void multiplyTest() {
        MyInt a = new MyInt("80");
        MyInt b = new MyInt("2");
        MyInt c = new MyInt("160");
        assertEquals(c, a.multiply(b));
        assertEquals(c, b.multiply(a));


        a = new MyInt("123");
        b = new MyInt("321");
        c = new MyInt("39483");
        assertEquals(c, a.multiply(b));
        assertEquals(c, b.multiply(a));

        a = new MyInt("-11");
        b = new MyInt("11");
        c = new MyInt("-121");
        assertEquals(c, a.multiply(b));
        assertEquals(c, b.multiply(a));

        a = new MyInt("11");
        b = new MyInt("-11");
        c = new MyInt("-121");
        assertEquals(c, a.multiply(b));
        assertEquals(c, b.multiply(a));

        a = new MyInt("-11");
        b = new MyInt("-11");
        c = new MyInt("121");
        assertEquals(c, a.multiply(b));
        assertEquals(c, b.multiply(a));

        a = new MyInt("-2837");
        b = new MyInt("-273");
        c = new MyInt("774501");
        assertEquals(c, a.multiply(b));
        assertEquals(c, b.multiply(a));
    }

    @Test
    void ts() {
        MyInt a = new MyInt("-2837");
        MyInt b = new MyInt("-273");
        MyInt c = new MyInt("774501");
        assertEquals(c, a.multiply(b));
        assertEquals(c, b.multiply(a));
    }
}
