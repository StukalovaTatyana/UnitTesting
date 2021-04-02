package types;

import org.junit.Test;
import ru.asu.types.MyInt;

import java.text.MessageFormat;

import static org.junit.Assert.assertEquals;

public class MyIntTest {

    @Test
    public void reversTest() {
        MyInt a = new MyInt(123);
        a.reverse();
        assertEquals("Значения не совпали", "321", a.getValueString());
    }

    @Test
    public void signIntegerTest() {
        MyInt a = new MyInt(123);
        assertEquals("Значения не совпали", 0, a.getSign());

        a = new MyInt(-13);
        assertEquals("Значения не совпали", 1, a.getSign());

        a = new MyInt(0);
        assertEquals("Значения не совпали", 0, a.getSign());
    }

    @Test
    public void signStringTest() {
        MyInt a = new MyInt("123");
        assertEquals("Знаки не совпали", 0, a.getSign());
        assertEquals("Значения не совпали", "123", a.getValueString());

        a = new MyInt("-13");
        assertEquals("Знаки не совпали", 1, a.getSign());
        assertEquals("Значения не совпали", "13", a.getValueString());

        a = new MyInt("0");
        assertEquals("Знаки не совпали", 0, a.getSign());
        assertEquals("Значения не совпали", "0", a.getValueString());

    }

    @Test
    public void signByteArrayTest() {
        MyInt a = new MyInt("123".getBytes());
        assertEquals("Значения не совпали", 0, a.getSign());

        a = new MyInt("-13".getBytes());
        assertEquals("Значения не совпали", 1, a.getSign());

        a = new MyInt("0".getBytes());
        assertEquals("Значения не совпали", 0, a.getSign());
    }

    @Test
    public void addZeroToBeginTest() {
        MyInt a = new MyInt(123);
        a.addZero(5);
        assertEquals("Значения не совпали", "00000123", a.getValueString());

        a = new MyInt("123");
        a.addZero(-2);
        assertEquals("Значения не совпали", "00123", a.getValueString());

        a = new MyInt("123");
        a.addZero(0);
        assertEquals("Значения не совпали", "123", a.getValueString());
    }

    @Test
    public void addPositiveToPositiveTest() {
        MyInt a = new MyInt(123);
        MyInt b = new MyInt(3);

        MyInt c = new MyInt(126);
        MyInt actual = a.add(b);
        assertEquals("Значения не совпали", c, actual);

        a = new MyInt(89);
        b = new MyInt(11);
        c = new MyInt("100");
        actual = a.add(b);

        assertEquals("Значения не совпали", c, actual);

        a = new MyInt(2);
        b = new MyInt(3);
        c = new MyInt("5");
        actual = a.add(b);
        assertEquals("Значения не совпали", c, actual);


        a = new MyInt(3);
        b = new MyInt(123);
        c = new MyInt("126");
        actual = a.add(b);
        assertEquals("Значения не совпали", c, actual);
    }

    @Test
    public void addPositiveToNegativeTest() {
        MyInt a = new MyInt(124);
        MyInt b = new MyInt(-3);
        MyInt c = new MyInt(121);
        MyInt actual = a.add(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

        a = new MyInt(89);
        b = new MyInt(-11);
        c = new MyInt("78");
        actual = a.add(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

        a = new MyInt(222);
        b = new MyInt(-333);
        c = new MyInt("-111");
        actual = a.add(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

        a = new MyInt(3);
        b = new MyInt(-123);
        c = new MyInt("-120");
        actual = a.add(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

        a = new MyInt(11);
        b = new MyInt(-2);
        c = new MyInt("9");
        actual = a.add(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);
    }

    @Test
    public void addNegativeToPositive() {
        MyInt a = new MyInt(-11);
        MyInt b = new MyInt(2);
        MyInt c = new MyInt("-9");
        MyInt actual = a.add(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

        a = new MyInt(-13);
        b = new MyInt(2);
        c = new MyInt("-11");
        actual = a.add(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

        a = new MyInt(-23);
        b = new MyInt(11);
        c = new MyInt("-12");
        actual = a.add(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

        a = new MyInt(-23);
        b = new MyInt(31);
        c = new MyInt("8");
        actual = a.add(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);
    }

    @Test
    public void addNegativeToNegative() {
        MyInt a = new MyInt(-11);
        MyInt b = new MyInt(-2);
        MyInt c = new MyInt("-13");
        MyInt actual = a.add(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

        a = new MyInt(-91);
        b = new MyInt(-9);
        c = new MyInt("-100");
        actual = a.add(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);
    }

    @Test
    public void subtractPositiveToPositiveTest() {
        MyInt a = new MyInt(124);
        MyInt b = new MyInt(114);
        MyInt c = new MyInt(10);
        MyInt actual = a.subtract(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

        a = new MyInt(999);
        b = new MyInt(977);
        c = new MyInt(22);
        actual = a.subtract(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

    }

    @Test
    public void subtractPositiveToNegativeTest() {
        MyInt a = new MyInt(124);
        MyInt b = new MyInt(-114);
        MyInt c = new MyInt(238);
        MyInt actual = a.subtract(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

        a = new MyInt(999);
        b = new MyInt(-977);
        c = new MyInt(1976);
        actual = a.subtract(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

    }

    @Test
    public void subtractNegativeToPositiveTest() {
        MyInt a = new MyInt(-124);
        MyInt b = new MyInt(114);
        MyInt c = new MyInt(-238);
        MyInt actual = a.subtract(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

        a = new MyInt(-999);
        b = new MyInt(977);
        c = new MyInt(-1976);
        actual = a.subtract(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

    }

    @Test
    public void subtractNegativeToNegativeTest() {
        MyInt a = new MyInt(-124);
        MyInt b = new MyInt(-11432);
        MyInt c = new MyInt(-11308);
        MyInt actual = a.subtract(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

        a = new MyInt(-999);
        b = new MyInt(-977);
        c = new MyInt(-22);
        actual = a.subtract(b);
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", c.getValueString(), actual.getValueString()), c, actual);

    }

    @Test
    public void absTest() {
        MyInt a = new MyInt("1");
        MyInt abs = new MyInt("1");
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", a.getValueString(), abs.getValueString()), abs, a.abs());

        a = new MyInt("-1");
        abs = new MyInt("1");
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", a.getValueString(), abs.getValueString()), abs, a.abs());

        a = new MyInt("0");
        abs = new MyInt("0");
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", a.getValueString(), abs.getValueString()), abs, a.abs());

        a = new MyInt("0");
        a.setSign(1);
        abs = new MyInt("0");
        assertEquals(MessageFormat.format("Значения не совпали! Ожидалось:{0}, пришло:{1}", a.getValueString(), abs.getValueString()), abs, a.abs());
    }

    @Test
    public void toStringTest() {
        MyInt a = new MyInt("12345");
        String sign = a.getSign() == 1 ? "-" : "";
        assertEquals("Значения не совпали!", sign + a.getValueString(), a.toString());

        a = new MyInt("-12345");
        sign = a.getSign() == 1 ? "-" : "";
        assertEquals("Значения не совпали!", sign + a.getValueString(), a.toString());
    }

    @Test
    public void regexTest() {
        MyInt a = new MyInt("0lkh7123");
        assertEquals("Значения не совпали!", "0", a.getValueString());

        a = new MyInt(-782110);
        assertEquals("Значения не совпали!", "782110", a.getValueString());

        a = new MyInt(782110);
        assertEquals("Значения не совпали!", "782110", a.getValueString());

    }

    @Test
    public void minTest() {
        MyInt a = new MyInt("12345");
        MyInt b = new MyInt("12344");
        assertEquals("Значения не совпали!", b, a.min(b));
        assertEquals("Значения не совпали!", b, b.min(a));

        a = new MyInt("12");
        b = new MyInt("12");
        assertEquals("Значения не совпали!", a, a.min(b));
        assertEquals("Значения не совпали!", a, b.min(a));

        a = new MyInt("123");
        b = new MyInt("1456");
        assertEquals("Значения не совпали!", a, a.min(b));
        assertEquals("Значения не совпали!", a, b.min(a));

        a = new MyInt("-123");
        b = new MyInt("1456");
        assertEquals("Значения не совпали!", a, a.min(b));
        assertEquals("Значения не совпали!", a, b.min(a));

        a = new MyInt("123");
        b = new MyInt("-1456");
        assertEquals("Значения не совпали!", b, a.min(b));
        assertEquals("Значения не совпали!", b, b.min(a));

        a = new MyInt("6666");
        b = new MyInt("-1456");
        assertEquals("Значения не совпали!", b, a.min(b));
        assertEquals("Значения не совпали!", b, b.min(a));

        a = new MyInt("123");
        b = new MyInt("-123");
        assertEquals("Значения не совпали!", b, a.min(b));
        assertEquals("Значения не совпали!", b, b.min(a));

    }

    @Test
    public void maxTest() {
        MyInt a = new MyInt("12345");
        MyInt b = new MyInt("12344");
        assertEquals("Значения не совпали!", a, a.max(b));
        assertEquals("Значения не совпали!", a, b.max(a));

        a = new MyInt("12");
        b = new MyInt("12");
        assertEquals("Значения не совпали!", a, a.max(b));
        assertEquals("Значения не совпали!", a, b.max(a));

        a = new MyInt("123");
        b = new MyInt("1456");
        assertEquals("Значения не совпали!", b, a.max(b));
        assertEquals("Значения не совпали!", b, b.max(a));

        a = new MyInt("-123");
        b = new MyInt("1456");
        assertEquals("Значения не совпали!", b, a.max(b));
        assertEquals("Значения не совпали!", b, b.max(a));

        a = new MyInt("123");
        b = new MyInt("-1456");
        assertEquals("Значения не совпали!", a, a.max(b));
        assertEquals("Значения не совпали!", a, b.max(a));

        a = new MyInt("6666");
        b = new MyInt("-1456");
        assertEquals("Значения не совпали!", a, a.max(b));
        assertEquals("Значения не совпали!", a, b.max(a));

        a = new MyInt("123");
        b = new MyInt("-123");
        assertEquals("Значения не совпали!", a, a.max(b));
        assertEquals("Значения не совпали!", a, b.max(a));
    }

    @Test
    public void compareToTest() {
        MyInt a = new MyInt(12);
        MyInt b = new MyInt(12);
        assertEquals("Значения не совпали!", 0, a.compareTo(b));
        assertEquals("Значения не совпали!", 0, b.compareTo(a));

        a = new MyInt(-12);
        b = new MyInt(-12);
        assertEquals("Значения не совпали!", 0, a.compareTo(b));
        assertEquals("Значения не совпали!", 0, b.compareTo(a));

        a = new MyInt("6666");
        b = new MyInt("1456");
        assertEquals("Значения не совпали!", 1, a.compareTo(b));
        assertEquals("Значения не совпали!", -1, b.compareTo(a));

        a = new MyInt("-6666");
        b = new MyInt("-123");
        assertEquals("Значения не совпали!", -1, a.compareTo(b));
        assertEquals("Значения не совпали!", 1, b.compareTo(a));

        a = new MyInt("123");
        b = new MyInt("-123");
        assertEquals("Значения не совпали!", 1, a.compareTo(b));
        assertEquals("Значения не совпали!", -1, b.compareTo(a));
    }

    @Test
    public void gcd() {
        MyInt a = new MyInt("123");
        MyInt b = new MyInt("123");
        String gcd = a.gcd(b);
        assertEquals("Значения не совпали!", "123", gcd);
        gcd = b.gcd(a);
        assertEquals("Значения не совпали!", "123", gcd);

        a = new MyInt("15");
        b = new MyInt("80");
        assertEquals("Значения не совпали!", "5", a.gcd(b));
        assertEquals("Значения не совпали!", "5", b.gcd(a));

        a = new MyInt("0");
        b = new MyInt("80");
        assertEquals("Значения не совпали!", "80", a.gcd(b));
        assertEquals("Значения не совпали!", "80", b.gcd(a));

        a = new MyInt("80");
        b = new MyInt("0");
        assertEquals("Значения не совпали!", "80", a.gcd(b));
        assertEquals("Значения не совпали!", "80", b.gcd(a));
    }

    @Test
    public void multiplyTest() {
        MyInt a = new MyInt("80");
        MyInt b = new MyInt("2");
        MyInt c = new MyInt("160");
        assertEquals("Значения не совпали!", c, a.multiply(b));
        assertEquals("Значения не совпали!", c, b.multiply(a));


        a = new MyInt("123");
        b = new MyInt("321");
        c = new MyInt("39483");
        assertEquals("Значения не совпали!", c, a.multiply(b));
        assertEquals("Значения не совпали!", c, b.multiply(a));

        a = new MyInt("-11");
        b = new MyInt("11");
        c = new MyInt("-121");
        assertEquals("Значения не совпали!", c, a.multiply(b));
        assertEquals("Значения не совпали!", c, b.multiply(a));

        a = new MyInt("11");
        b = new MyInt("-11");
        c = new MyInt("-121");
        assertEquals("Значения не совпали!", c, a.multiply(b));
        assertEquals("Значения не совпали!", c, b.multiply(a));

        a = new MyInt("-11");
        b = new MyInt("-11");
        c = new MyInt("121");
        assertEquals("Значения не совпали!", c, a.multiply(b));
        assertEquals("Значения не совпали!", c, b.multiply(a));

        a = new MyInt("-2837");
        b = new MyInt("-273");
        c = new MyInt("774501");
        assertEquals("Значения не совпали!", c, a.multiply(b));
        assertEquals("Значения не совпали!", c, b.multiply(a));
    }

    @Test
    public void ts() {
        MyInt a = new MyInt("-2837");
        MyInt b = new MyInt("-273");
        MyInt c = new MyInt("774501");
        assertEquals("Значения не совпали!", c, a.multiply(b));
        assertEquals("Значения не совпали!", c, b.multiply(a));
    }
}
