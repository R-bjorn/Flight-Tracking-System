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

    // For print the planes waiting for landing/take-off.
    public String waitingPlanes() {
        StringBuilder waitingPlanes = new StringBuilder();
        if (landing.size() > 0) {
            waitingPlanes.append("Planes waiting for landing\n");
            waitingPlanes.append("---------------------------\n");
            for (String flight : landed) {
                waitingPlanes.append(flight);
            }
            waitingPlanes.append("\n");
            return waitingPlanes.toString();
        }
        if (takeOff.size() > 0) {
            waitingPlanes.append("Planes waiting for take-off\n");
            waitingPlanes.append("---------------------------\n");
            for (String flight : takeOff) {
                waitingPlanes.append(flight);
            }
            waitingPlanes.append("\n");
            return waitingPlanes.toString();
        }
        return "No plane is in the landing and take-off queues.";
    }
}