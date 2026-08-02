/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pls;

import java.time.LocalDateTime;

/**
 * Represents a parking record containing information about vehicle parking sessions.
 * Tracks entry and exit times for vehicles in specific parking slots.
 */
public class ParkingRecord {
    // Unique identifier for the parking record
    private int recordId;
    
    // Identifier for the parking slot/space
    private String slotNumber;
    
    // Date and time when the vehicle entered the parking slot
    private LocalDateTime entryTime;
    
    // Date and time when the vehicle exited the parking slot (null if still parked)
    private LocalDateTime exitTime;

    /**
     * Constructs a new ParkingRecord with complete details.
     * 
     * @param recordId Unique ID for the parking record
     * @param slotNumber Identifier of the parking slot/space
     * @param entryTime Date and time of vehicle entry
     * @param exitTime Date and time of vehicle exit (can be null for active parking)
     */
    public ParkingRecord(int recordId, String slotNumber, LocalDateTime entryTime, LocalDateTime exitTime) {
        this.recordId = recordId;
        this.slotNumber = slotNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    /**
     * Gets the unique record identifier.
     * @return The record ID
     */
    public int getRecordId() {
        return recordId;
    }

    /**
     * Sets the unique record identifier.
     * @param recordId The new record ID to set
     */
    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    /**
     * Gets the parking slot number/identifier.
     * @return The slot number/identifier
     */
    public String getSlotNumber() {
        return slotNumber;
    }

    /**
     * Sets the parking slot number/identifier.
     * @param slotNumber The new slot number/identifier to set
     */
    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    /**
     * Gets the entry date and time of the vehicle.
     * @return The entry timestamp
     */
    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    /**
     * Sets the entry date and time of the vehicle.
     * @param entryTime The new entry timestamp to set
     */
    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * Gets the exit date and time of the vehicle.
     * @return The exit timestamp (null if vehicle hasn't exited)
     */
    public LocalDateTime getExitTime() {
        return exitTime;
    }

    /**
     * Sets the exit date and time of the vehicle.
     * @param exitTime The new exit timestamp to set
     */
    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}