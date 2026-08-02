/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pls;

/**
 * The Logs class represents a log entry containing a timestamp and activity description.
 * This can be used to track events or actions in the system.
 */
public class Logs {
    // The timestamp when the activity occurred
    private String timestamp;
    
    // Description of the activity that was performed
    private String activity;

    /**
     * Constructs a new Logs instance with the specified timestamp and activity.
     * 
     * @param timestamp The time when the activity occurred (formatted as string)
     * @param activity The description of the activity/event
     */
    public Logs(String timestamp, String activity) {
        this.timestamp = timestamp;
        this.activity = activity;
    }

    /**
     * Gets the timestamp of this log entry.
     * 
     * @return The timestamp as a String
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp for this log entry.
     * 
     * @param timestamp The new timestamp to set
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets the activity description of this log entry.
     * 
     * @return The activity description
     */
    public String getActivity() {
        return activity;
    }

    /**
     * Sets the activity description for this log entry.
     * 
     * @param activity The new activity description to set
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }
}