/**
 * Created by Niklas Königsson dv15nkn on 2016-04-04.
 */

/**
 * Class that handles individual dumberdisplays to be used by Clock and
 * its subclasses
 */
public class NumberDisplay {

    private int minLimit, maxLimit, value;

    /**
     * Constructor for the numberdisplay
     * @param minLimit The minimum value for the display
     * @param maxLimit The maximum value for the display
     * @throws IllegalArgumentException
     */
    public NumberDisplay(int minLimit, int maxLimit){

        if(minLimit >= maxLimit) {
            throw new IllegalArgumentException("Maximum must be larger " +
                                                "than minimum");
        }

        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.value = minLimit;
    }

    /**
     * Gets the value of this numberdisplay
     * @return the value of the display as an int
     */
    public int getValue(){

        return value;
    }

    /**
     * Sets the value of this numberdisplay
     */
    public void setValue(int newValue){

        value = newValue;
    }

    /**
     * Gets the value of this numberdisplay
     * @return The numberdisplay as a String
     */
    public String getDisplayValue(){

        return String.format("%02d", value);
    }

    /**
     * increment this numberdisplay by 1
     */
    public void increment(){

        if(value < maxLimit){
            value++;
        }else{
            value = minLimit;
        }
    }

    /**
     * Checks if the value is equal to the minimumlimit
     * If true a wraparound has been made
     * @return Boolean expression if the value is at minimum
     */
    public boolean didWrapAround(){

        return value == minLimit;
    }
}

