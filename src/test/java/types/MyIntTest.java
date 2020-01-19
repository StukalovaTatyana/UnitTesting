package types;

import org.junit.Test;
import ru.asu.types.MyInt;

import static org.junit.Assert.assertEquals;

public class MyIntTest {

    @Test
    public void reversTest() {
        MyInt a = new MyInt(123);
        a.reverse();
        assertEquals("Значения не совпали", "321", a.getValueString());
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
    public void addPositiveToNevativeTest() {
        MyInt a = new MyInt(123);
        MyInt b = new MyInt(-3);

        MyInt c = new MyInt(120);
        MyInt actual = a.add(b);
        assertEquals("Значения не совпали", c, actual);

        a = new MyInt(89);
        b = new MyInt(-11);
        c = new MyInt("78");
        actual = a.add(b);

        assertEquals("Значения не совпали", c, actual);

        a = new MyInt(2);
        b = new MyInt(-3);
        c = new MyInt("-5");
        actual = a.add(b);
        assertEquals("Значения не совпали", c, actual);


        a = new MyInt(3);
        b = new MyInt(-123);
        c = new MyInt("-120");
        actual = a.add(b);
        assertEquals("Значения не совпали", c, actual);

        a = new MyInt(10);
        b = new MyInt(-1);
        c = new MyInt("9");
        actual = a.add(b);
        assertEquals("Значения не совпали", c, actual);
    }


}
