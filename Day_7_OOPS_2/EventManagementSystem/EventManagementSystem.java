package Day_7_OOPS_2.EventManagementSystem;

import java.util.*;

// Define Event class
class Event {
    private int eventId;
    private String eventName;
    private Date eventDate;
    private String eventLocation;
    private Set<String> attendees;

    public Event(int eventId, String eventName, Date eventDate, String eventLocation) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.attendees = new HashSet<>();
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public void setAttendees(Set<String> attendees) {
        this.attendees = attendees;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public Set<String> getAttendees() {
        return attendees;
    }

    public void addAttendee(String attendeeName) {
        attendees.add(attendeeName);
    }

    public void removeAttendee(String attendeeName) {
        attendees.remove(attendeeName);
    }

    public void displayEventDetails() {
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Location: " + eventLocation);
        System.out.println("Attendees: " + attendees);
    }
}

// Define EventManager class
class EventManager {
    private List<Event> events;

    public EventManager() {
        this.events = new ArrayList<>();
    }

    public void createEvent(int eventId, String eventName, Date eventDate, String eventLocation) {
        Event newEvent = new Event(eventId, eventName, eventDate, eventLocation);
        events.add(newEvent);
        System.out.println("Event created successfully.");
    }

    public void updateEvent(int eventId, String eventName, Date eventDate, String eventLocation) {
        for (Event event : events) {
            if (event.getEventId() == eventId) {
                event.setEventName(eventName);
                event.setEventDate(eventDate);
                event.setEventLocation(eventLocation);
                System.out.println("Event updated successfully.");
                return;
            }
        }
        System.out.println("Event not found.");
    }

    public void deleteEvent(int eventId) {
        Iterator<Event> iterator = events.iterator();
        while (iterator.hasNext()) {
            Event event = iterator.next();
            if (event.getEventId() == eventId) {
                iterator.remove();
                System.out.println("Event deleted successfully.");
                return;
            }
        }
        System.out.println("Event not found.");
    }

    public void registerForEvent(int eventId, String attendeeName) {
        for (Event event : events) {
            if (event.getEventId() == eventId) {
                event.addAttendee(attendeeName);
                System.out.println(attendeeName + " registered for " + event.getEventName());
                return;
            }
        }
        System.out.println("Event not found.");
    }

    public void cancelRegistration(int eventId, String attendeeName) {
        for (Event event : events) {
            if (event.getEventId() == eventId) {
                event.removeAttendee(attendeeName);
                System.out.println(attendeeName + " canceled registration for " + event.getEventName());
                return;
            }
        }
        System.out.println("Event not found.");
    }

    public void displayAllEvents() {
        for (Event event : events) {
            event.displayEventDetails();
            System.out.println();
        }
    }
}

// Main class to run the program
public class EventManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManager eventManager = new EventManager();

        while (true) {
            System.out.println("\nEvent Management System Menu:");
            System.out.println("1. Create Event");
            System.out.println("2. Update Event");
            System.out.println("3. Delete Event");
            System.out.println("4. Register for Event");
            System.out.println("5. Cancel Registration");
            System.out.println("6. Display All Events");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Event ID: ");
                    int eventId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter Event Name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter Event Date (YYYY-MM-DD): ");
                    // Example date format input handling
                    Date eventDate = new Date(); // Replace with actual date parsing
                    System.out.print("Enter Event Location: ");
                    String eventLocation = scanner.nextLine();
                    eventManager.createEvent(eventId, eventName, eventDate, eventLocation);
                    break;
                case 2:
                    System.out.print("Enter Event ID to update: ");
                    int eventIdToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter New Event Name: ");
                    String newEventName = scanner.nextLine();
                    System.out.print("Enter New Event Date (YYYY-MM-DD): ");
                    // Example date format input handling
                    Date newEventDate = new Date(); // Replace with actual date parsing
                    System.out.print("Enter New Event Location: ");
                    String newEventLocation = scanner.nextLine();
                    eventManager.updateEvent(eventIdToUpdate, newEventName, newEventDate, newEventLocation);
                    break;
                case 3:
                    System.out.print("Enter Event ID to delete: ");
                    int eventIdToDelete = scanner.nextInt();
                    eventManager.deleteEvent(eventIdToDelete);
                    break;
                case 4:
                    System.out.print("Enter Event ID to register: ");
                    int eventIdToRegister = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter Attendee Name to register: ");
                    String attendeeNameToRegister = scanner.nextLine();
                    eventManager.registerForEvent(eventIdToRegister, attendeeNameToRegister);
                    break;
                case 5:
                    System.out.print("Enter Event ID to cancel registration: ");
                    int eventIdToCancel = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter Attendee Name to cancel registration: ");
                    String attendeeNameToCancel = scanner.nextLine();
                    eventManager.cancelRegistration(eventIdToCancel, attendeeNameToCancel);
                    break;
                case 6:
                    eventManager.displayAllEvents();
                    break;
                case 7:
                    System.out.println("Exiting Event Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
