package CalenderApp;
import java.time.LocalDate;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calender implements Serializable{

    ArrayList<Event> eventlist;
    private Scanner myscanner = new Scanner(System.in);

    public Calender(ArrayList<Event> eventlist) {

        this.eventlist = eventlist;
    }

    public void addNewEvent() {
        try {
            System.out.println("Enter date in this format 'yyyy-MM-DD'");
            String dateInput = myscanner.nextLine();

            Pattern datePattern = Pattern.compile("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$");
            Matcher match = datePattern.matcher(dateInput);
            boolean isMatching = match.matches();

            if (isMatching) {
                LocalDate userDate = LocalDate.parse(dateInput);
                System.out.println("Enter description");
                String description = myscanner.nextLine();
                Event newevent = new Event(userDate, description);
                eventlist.add(newevent);


                try (ObjectOutputStream saveevent = new ObjectOutputStream(new FileOutputStream("events.txt"))) {
                    saveevent.writeObject(eventlist);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("'" + newevent.getDescription() + "' has been added to calendar!");
            } else {
                System.out.println("Invalid date format! Use 'yyyy-MM-DD'");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewEvents() {
        try {
            LocalDate presentDate = LocalDate.now();
            if (eventlist.isEmpty()) {
                System.out.println("Nothing saved to calendar!");
            } else {
                Iterator<Event> iterator = eventlist.iterator();
                boolean removed = false;

                while (iterator.hasNext()) {
                    Event event = iterator.next();
                    if (presentDate.isAfter(event.getDate())) {
                        iterator.remove();
                        removed = true;
                    } else {
                        System.out.println(event);
                    }
                }

                if (removed) {
                    System.out.println("Missed events have been removed from calendar!");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void loadEvents(){
        try( ObjectInputStream loadevent = new ObjectInputStream(new FileInputStream("events.txt"))){
            eventlist = (ArrayList<Event>) loadevent.readObject();
            System.out.println("Events loaded successfully!");
        } catch (FileNotFoundException e) {
            eventlist = new ArrayList<>();
            System.out.println("No saved events found. Starting with a fresh calendar.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading events: " + e.getMessage());
            eventlist = new ArrayList<>();
        }
    }

    public void checkTodayEvents() {
        if (eventlist.isEmpty()) {
            System.out.println("No events added to calendar!");
            return;
        }

        LocalDate presentDate = LocalDate.now();
        boolean found = false;

        for (Event everyEvent : eventlist) {
            if (everyEvent.getDate().equals(presentDate)) {
                if (!found) {
                    System.out.println("Today's events:");
                    found = true;
                }
                System.out.println(everyEvent.getDate() + " :: " + everyEvent.getDescription());
            }
        }

        if (!found) {
            System.out.println("No events scheduled for today!");
        }
    }

}
