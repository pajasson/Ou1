/**
 * Created by konig on 2016-04-05.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ClockTest {


    @Test
    public void DisplayTest() throws Exception {

        Clock newClock = new Clock();
        assertEquals("00:00", newClock.getTime());
    }

    @Test
    public void ClockTickAndWrapTest() throws Exception {

        Clock newClock = new Clock(23, 59);
        newClock.timeTick();
        assertEquals("00:00", newClock.getTime());
    }

    @Test
    public void SetClockTest() throws Exception {

        Clock newClock = new Clock();
        newClock.setTime(22, 22);
        assertEquals("22:22", newClock.getTime());
    }
}