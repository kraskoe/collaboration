import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 24.09.2017.
 */
public class serviceDetermineTest {
    @Test
    public void isEmailTest() throws Exception {
        assertTrue(serviceDetermine.isEmail("krasko@mail.ru"));
    }

    @Test
    public void isSurnameTest() throws Exception {
        assertTrue(serviceDetermine.isSurname("Zack"));
    }

    @Test
    public void isTelNumberTest() throws Exception {
        assertTrue(serviceDetermine.isTelNumber("+375295772832"));
    }

    @Test
    public void isInsNumberTest() throws Exception {
        assertTrue(serviceDetermine.isInsNumber("1234567A890BC1"));
    }
}