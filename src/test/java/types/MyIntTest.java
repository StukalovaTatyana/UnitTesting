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

    }

    @Test
    public void subtractPositiveToNegativeTest() {

    }

    @Test
    public void subtractNegativeToPositiveTest() {

    }

    @Test
    public void subtractNegativeToNegativeTest() {

    }

}
