package no.ntnu;


import no.ntnu.LongJump;
import no.ntnu.LongJumpRegister;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

public class LongJumpRegisterTest {

    /**
     * test
     */
    @Test
    public void addCorrectLongJump() {
        LongJump longJump = new LongJump(1, "Jons", 1.3, true, LocalTime.parse("06:30"));
        LongJumpRegister longJumpRegister = new LongJumpRegister();
        longJumpRegister.addLongJump(longJump);
        assertEquals(longJumpRegister.getSize(), 3);
    }

    /**
     * test
     */
    @Test
    public void addIncorrectLongJump() {
        try {
            LongJump longJump = new LongJump(-1, "", -1.0, true, LocalTime.parse(""));
            LongJumpRegister longJumpRegister = new LongJumpRegister();
            longJumpRegister.addLongJump(longJump);
            fail("Exception was not thrown when adding a wrong valued jump");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
