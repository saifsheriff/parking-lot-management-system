/*
 * This class represents the Dashboard data model for a parking lot system.
 * It holds key information about total, occupied, and available parking slots.
 */

package pls;

public class Dashboard {

    // Total number of parking slots in the system
    private int totalSlots;

    // Number of currently occupied slots
    private int occupiedSlots;

    // Number of currently available slots
    private int availableSlots;

    /*
     * Constructor to initialize the dashboard with given values.
     *
     * @param totalSlots total number of slots
     * @param occupiedSlots number of slots that are currently occupied
     * @param availableSlots number of slots that are currently available
     */
    public Dashboard(int totalSlots, int occupiedSlots, int availableSlots) {
        this.totalSlots = totalSlots;
        this.occupiedSlots = occupiedSlots;
        this.availableSlots = availableSlots;
    }

    // Getter for totalSlots
    public int getTotalSlots() {
        return totalSlots;
    }

    // Setter for totalSlots
    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    // Getter for occupiedSlots
    public int getOccupiedSlots() {
        return occupiedSlots;
    }

    // Setter for occupiedSlots
    public void setOccupiedSlots(int occupiedSlots) {
        this.occupiedSlots = occupiedSlots;
    }

    // Getter for availableSlots
    public int getAvailableSlots() {
        return availableSlots;
    }

    // Setter for availableSlots
    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }
}
