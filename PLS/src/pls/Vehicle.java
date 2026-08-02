/*
 * This class represents a Vehicle with basic attributes:
 * - plateNumber: the vehicle's license plate
 * - type: the type of the vehicle (e.g., car, motorcycle, truck)
 * 
 * It uses encapsulation with private fields and provides
 * public getters and setters to access and modify the data.
 */

package pls;

public class Vehicle {

    // Private fields representing vehicle details
    private String plateNumber;  // License plate number of the vehicle
    private String type;         // Type of the vehicle (e.g., car, bus, truck)

    // Constructor to initialize a new Vehicle object with given values
    public Vehicle(String plateNumber, String type) {
        this.plateNumber = plateNumber;
        this.type = type;
    }

    // Getter for plateNumber - returns the license plate number
    public String getPlateNumber() {
        return plateNumber;
    }

    // Setter for plateNumber - sets or updates the license plate number
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    // Getter for type - returns the vehicle type
    public String getType() {
        return type;
    }

    // Setter for type - sets or updates the vehicle type
    public void setType(String type) {
        this.type = type;
    }
}
