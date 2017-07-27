import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Turk on 7/27/17.
 */
public class EventLog {
    private List<Event> eventList;

    public EventLog(){
        eventList = new ArrayList<>();
    }

    public boolean addEvent(Event event) throws IllegalArgumentException{
        if(event == null) { throw new IllegalArgumentException(); }
        if(event.getName() == null || event.getAction() == null) { throw new IllegalArgumentException(); }
        if( event.getAction().equals("Face2Face") ||
            event.getAction().equals("PhoneCall") ||
            event.getAction().equals("TextMessaging") ||
            event.getAction().equals("Unknown")
            ){
            eventList.add(event);
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getNumEvents(){
        return eventList.size();
    }
}
