package org.example.kyu6;
import org.example.kyu6.MorseCodeDecoder;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MorseCodeDecoderTest {
    @Test
    public void testExampleFromDescription() {
        assertThat(MorseCodeDecoder.decode("...---..."), is("SOS"));
    }
}