/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pls;

/**
 * Represents a parking slot in the parking management system.
 * Tracks the slot's unique identifier and occupancy status.
 */
public class ParkingSlot {
    // Unique identifier for the parking slot
    private int slotId;
    
    // Occupancy status of the parking slot (true = occupied, false = available)
    private boolean isOccupied;

    /**
     * Constructs a new ParkingSlot with the specified ID and occupancy status.
     * 
     * @param slotId The unique identifier for this parking slot
     * @param isOccupied The initial occupancy status (true if occupied, false if available)
     */
    public ParkingSlot(int slotId, boolean isOccupied) {
        this.slotId = slotId;
        this.isOccupied = isOccupied;
    }

    /**
     * Gets the unique identifier of this parking slot.
     * 
     * @return The slot ID number
     */
    public int getSlotId() {
        return slotId;
    }

    /**
     * Sets the unique identifier for this parking slot.
     * 
     * @param slotId The new ID number to assign to this slot
     */
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    /**
     * Checks the occupancy status of this parking slot.
     * 
     * @return true if the slot is occupied, false if available
     */
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Updates the occupancy status of this parking slot.
     * 
     * @param occupied The new occupancy status (true to mark as occupied, false as available)
     */
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}