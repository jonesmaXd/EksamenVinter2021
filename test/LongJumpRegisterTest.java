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
        LongJump longJump = new LongJump(1, "Jons", 1.3, true, LocalTime.parse("06:30"));
        LongJumpRegister longJumpRegister = new LongJumpRegister();
        longJumpRegister.addLongJump(longJump);
        assertEquals(longJumpRegister.getSize(), 1);
    }
}
