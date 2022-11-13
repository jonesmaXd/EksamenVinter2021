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
        assertEquals(longJumpRegister.getSize(), 1);
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

    /**
     * test
     */
    @Test
    public void addLongJumpWithNull() {
        try {
            LongJump longJump = new LongJump(1, null, 1.0, true, LocalTime.parse("06:30"));
            LongJumpRegister longJumpRegister = new LongJumpRegister();
            longJumpRegister.addLongJump(longJump);
            fail("Exception was not thrown when adding a wrong valued jump");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    /**
     *
     */
    @Test
    public void compareLongJumps() {
        LongJump longJump1 = new LongJump(10, "Jakob Arnsesen", 3.9, true, LocalTime.parse("06:30"));
        LongJump longJump2 = new LongJump(10, "Jakob Arnsesen", 6.9, false, LocalTime.parse("07:30"));
        LongJump longJump3 = new LongJump(90, "Kjell Ange", 6.4, true, LocalTime.parse("09:30"));

        LongJumpRegister longJumpRegister = new LongJumpRegister();
        longJumpRegister.addLongJump(longJump1);
        longJumpRegister.addLongJump(longJump2);
        longJumpRegister.addLongJump(longJump3);

        assertEquals(longJumpRegister.getLongestJump().getJumpLength(), 6.9);
    }
}
