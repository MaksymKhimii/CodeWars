package org.example.kyu6;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MultiplesTest {
    @Test
    public void test() {
        assertEquals(23, new MultiplesOf3Or5().solution(10));
    }
}
