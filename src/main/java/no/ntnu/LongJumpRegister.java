package no.ntnu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a register for long jumps.
 */
public class LongJumpRegister {
    /**
     * Using an arraylist in this project becuase i am most familiar with it, but i do recognize that a hashmap
     * could be used with the startnumber as a key. But if something unexpected were to go wrong
     * i would prefer to be using the arraylist and not hashmap - personal preference.
     */
    private ArrayList<LongJump> jumpRegister;

    public LongJumpRegister() {
        this.jumpRegister = new ArrayList<>();
    }

    /**
     * Adds an existing jump to the register
     *
     * @param longJump the jump to be added
     */
    public void addLongJump(LongJump longJump) {
        if(longJump != null) {
            this.jumpRegister.add(longJump);
        } else {
            System.out.println("Error adding long jump");
        }
    }

    /**
     * Removes a longjump from the register.
     *
     * @param longJump the longjump to be removed.
     */
    public void removeLongJump(LongJump longJump) {
        if (longJump != null) {
            this.jumpRegister.remove(longJump);
        }
    }

    /**
     * Returns the total amount of jumps registered.
     *
     * @return the total amount of jumps registered.
     */
    public int getNumberOfJumps() {
        return this.jumpRegister.size();
    }

    /**
     * Returns an iterator for all the jumps in the register.
     *
     * @return the iterator.
     */
    public Iterator<LongJump> getAllJumps() {
        return this.jumpRegister.iterator();
    }

    //Attempted to use the Collectons.max method to find the longest jump,

    //but it did not work and I was unable to figure out why so I moved on to a different solution.
/*    public no.ntnu.LongJump getLongestJump() {
        no.ntnu.LongJump max = Collections.max(jumpRegister);
        System.out.println(max.getJumpLength());
    }*/

    /**
     * Finds the longest jump in the register.
     *
     * @return the longest jump.
     */
    public LongJump getLongestJump() {
        LongJump foundLongJump = null;
        int index = 0;
        Double max = jumpRegister.get(0).getJumpLength();

        while (index < getNumberOfJumps()){
            Double currentLongJump = this.jumpRegister.get(index).getJumpLength();
            if (currentLongJump > max) {
                max = currentLongJump;
                foundLongJump = jumpRegister.get((index));
            }
            index++;
        }
        return foundLongJump;
    }

    /**
     * Finds all the jumps by a specific athlete using the startnumber.
     *
     * @param startNumber the startnumber of the athlete.
     * @return an Arraylist of all the jumps of the athlete with the corresponding startnumber.
     */
    public ArrayList<LongJump> findAllJumpsByStartNumber(int startNumber) {
        ArrayList<LongJump> foundJumps = new ArrayList<>();
        for (LongJump l : jumpRegister) {
            if (l.getStartNumber() == startNumber){
                foundJumps.add(l);
            }
        }
        return foundJumps;
    }

    /**
     * Calculates the total length of all the jumps added together.
     *
     * @return the sum of all the jump lengths.
     */
    private double calculateTotalJumpLength() {
        Iterator<LongJump> it = this.jumpRegister.iterator();
        double sum = 0;
        while (it.hasNext()) {
            LongJump l = it.next();
            sum = sum + l.getJumpLength();
        }
        return sum;
    }

    /**
     * Calculates the average jump length of all the jumps.
     *
     * @return the average length of all the jumps.
     */
    public double calculateAverageJumpLength() {
        return calculateTotalJumpLength() / getNumberOfJumps();
    }

    public int getSize() {
        return jumpRegister.size();
    }
}
