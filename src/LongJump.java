import java.time.LocalTime;

/**
 * Represents a long jump.
 */
public class LongJump {
    private int startNumber;
    private String name;
    private Double jumpLength;
    private boolean validJump;
    private LocalTime timeJumped;

    /**
     * Creates an instanse of a long jump.
     *
     * @param startNumber The startnumber of the athlete, a positive integer.
     * @param name The name of the athlete.
     * @param jumpLength The length of the jump made by the athlete.
     * @param validJump Negative if the jump is invalid, positive if valid.
     * @param timeJumped The time when the jump was performed.
     */
    public LongJump(int startNumber, String name, Double jumpLength, boolean validJump, LocalTime timeJumped) {
        // Uses the set methods which have implemented guarding to initialize the parameters.
        this.setStartNumber(startNumber);
        this.setName(name);
        this.setJumpLength(jumpLength);
        this.setValidJump(validJump);
        this.setTimeJumped(timeJumped);
    }

    /**
     * Returns the startnumber of the athlete.
     *
     * @return the startnumber of the athlete.
     */
    public int getStartNumber() {
        return startNumber;
    }

    /**
     * Returns the name of the athlete.
     *
     * @return the name of the athlete.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the jump length performed by the athlete.
     *
     * @return the jump length performed by the athlete.
     */
    public Double getJumpLength() {
        return jumpLength;
    }

    /**
     * Returns a value positive value if a jump is approved, a negative value if not approved.
     *
     * @return a value positive value if a jump is approved, a negative value if not approved.
     */
    public boolean isValidJump() {
        return validJump;
    }

    /**
     * Returns the time the jump was performed.
     *
     * @return the time the jump was performed.
     */
    public LocalTime getTimeJumped() {
        return timeJumped;
    }

    /**
     * Sets a new startnumber for the athlete.
     *
     * @param startNumber the startnumber.
     */
    public void setStartNumber(int startNumber) {
        if (startNumber < 0){
            System.out.println("Invalid start number");
        }
        this.startNumber = startNumber;
    }

    /**
     * Sets a new name for the athlete.
     *
     * @param name the new name.
     */
    public void setName(String name) {
       if (name.isBlank() || name.isEmpty()) {
           System.out.println("Invalid name");
       }
        this.name = name;
    }

    /**
     * Sets a new jumplength for performed by the athlete.
     *
     * @param jumpLength the jumplength.
     */
    public void setJumpLength(Double jumpLength) {
        if (jumpLength < 0){
            System.out.println("Jump length cannot be less than zero");
        }
        this.jumpLength = jumpLength;
    }

    /**
     * Sets a new value to used to determine if a jump is valid or invalid.
     *
     * Negative for invalid, positive for valid.
     * @param validJump
     */
    public void setValidJump(boolean validJump) {
        this.validJump = validJump;
    }

    /**
     * Sets a new time the jump was performed at
     *
     * @param timeJumped the time of the jump.
     */
    public void setTimeJumped(LocalTime timeJumped) {
        if (timeJumped == null){
            System.out.println("Invalid value for time jumped");
        }
        this.timeJumped = timeJumped;
    }
}
