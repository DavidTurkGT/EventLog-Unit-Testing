import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by David Turk on 7/27/17.
 */
public class EventLogTests {
    EventLog log = new EventLog();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void nullEventThrowsException() {
        System.out.println("Testing throwing exceptions....");
        Event nullEvent = null;
        thrown.expect(IllegalArgumentException.class);
        log.addEvent(nullEvent);
    }

    @Test
    public void eventWithNullNameThrowsException() {
        Event nullNameEvent = new Event(null, "action");
        thrown.expect(IllegalArgumentException.class);
        log.addEvent(nullNameEvent);
    }

    @Test
    public void eventWithNullActionThrowsException() {
        Event nullActionEvent = new Event("name",null);
        thrown.expect(IllegalArgumentException.class);
        log.addEvent(nullActionEvent);
    }

    @Test
    public void addStandardEvent(){
        System.out.print("Testing adding a test....");
        //Running the function adds an event to the list
        //The return value from the addEvent method should be true
//        int startNumEvents = log.getNumEvents();
        Event newEvent = new Event("testName","testAction");
        thrown.expect(IllegalArgumentException.class);
        log.addEvent(newEvent);
        //THIS IS THE OLD TEST
//        boolean result = log.addEvent(newEvent);
//        assertTrue("Event did not return true when an event was added", result);
//        assertEquals(log.getNumEvents(), 1);
    }

    @Test
    public void addFace2FaceEvent(){
        Event face2Face = new Event("face","Face2Face");
        assertTrue("Can't add Face2Face",log.addEvent(face2Face));
        assertEquals(1, log.getNumEvents());
    }

    @Test
    public void addPhoneCall(){
        Event phoneCall = new Event("phone","PhoneCall");
        assertTrue("Can't add PhoneCall",log.addEvent(phoneCall));
        assertEquals(1, log.getNumEvents());
    }

    @Test
    public void addTextMessaging(){
        Event textMsg = new Event("text","TextMessaging");
        assertTrue("Can't add TextMessaging",log.addEvent(textMsg));
        assertEquals(1,log.getNumEvents());
    }

    @Test
    public void addUnknown(){
        Event unknown = new Event("unknown", "Unknown");
        assertTrue("Can't add Unknown",log.addEvent(unknown));
        assertEquals(1,log.getNumEvents());
    }
}
