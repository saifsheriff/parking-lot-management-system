/*
 * This class represents the details of a vehicle's exit from the parking lot.
 * It holds the vehicle number and the time the vehicle exited.
 */

package pls;

public class Exit {
    // Field to store the vehicle's license plate number
    private String vehicleNumber;

    // Field to store the time the vehicle exited the parking lot
    private String exitTime;

    /**
     * Constructor to initialize the Exit object with vehicle number and exit time.
     * 
     * @param vehicleNumber the license plate number of the vehicle
     * @param exitTime the time the vehicle exited
     */
    public Exit(String vehicleNumber, String exitTime) {
        this.vehicleNumber = vehicleNumber;
        this.exitTime = exitTime;
    }

    /**
     * Gets the vehicle number.
     * 
     * @return vehicleNumber
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    /**
     * Sets the vehicle number.
     * 
     * @param vehicleNumber the new vehicle number
     */
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    /**
     * Gets the exit time of the vehicle.
     * 
     * @return exitTime
     */
    public String getExitTime() {
        return exitTime;
    }

    /**
     * Sets the exit time of the vehicle.
     * 
     * @param exitTime the new exit time
     */
    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }
}
