import java.util.*;

/**
 * Airport Class
 */

public class Airport {
    /**
     * Using 4 List to get the constant records of FlightNumbers 1. For all the
     * flights that are going to take off soon ! 2. For all the flights that are
     * going to land on the airport! 3. For all the past flights that already took
     * off! For Records!! 4. For all the past flights that already landed on! For
     * Records!!
     */
    public Queue<String> takeOff;
    public Queue<String> landing;
    public Queue<String> takenOff;
    public Queue<String> landed;

    // For adding the flights that are going to take off soon
    public void addTakeOff(String flight_number) {
        takeOff.add(flight_number);
    }

    // For Adding the flights that are going to land on the airport
    public void addLanding(String flight_number) {
        landing.add(flight_number);
    }

    // For performing the next action
    public String handleNextAction() {
        if (landing.size() > 0) {
            String flight = landing.remove();
            landed.add(flight);
            return "Flight " + flight + " is landing.";
        } else if (takeOff.size() > 0) {
            String flight = takeOff.remove();
            takenOff.add(flight);
            return "Flight " + flight + " is taking off.";
        } else {
            return "No plane is waiting to land of take-off";
        }
    }
}