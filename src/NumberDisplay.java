import java.util.IllegalFormatConversionException;

/**
 * Created by konig on 2016-04-04.
 */
public class NumberDisplay {

    private int minLimit, maxLimit, value;

    public NumberDisplay(int minLimit, int maxLimit){

        if(minLimit >= maxLimit) {
            throw new IllegalArgumentException("Maximum must be larger than minimum");
        }

        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.value = minLimit;
    }

    public int getValue(){

        return value;
    }

    public void setValue(int newValue){

        value = newValue;
    }

    public String getDisplayValue(){

        return String.format("%02d", value);
    }

    public void increment(){

        if(value + 1 < maxLimit){
            value++;
        }else{
            value = minLimit;
        }
    }

    public boolean didWrapAround(){

        return value == minLimit;
    }
}

