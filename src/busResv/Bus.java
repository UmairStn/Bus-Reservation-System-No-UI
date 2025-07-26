package busResv;

/**
 * Bus class - Represents a bus entity with its properties
 * This is a model/entity class that encapsulates bus information
 * Currently not actively used in the main application flow
 */
public class Bus {
    // Private fields to store bus information (encapsulation)
    private int busNo;      // Unique identifier for the bus
    private boolean ac;     // AC availability (true = AC, false = Non-AC)
    private int capacity;   // Maximum number of passengers the bus can hold

    /**
     * Constructor to create a Bus object with specified properties
     * @param no - Bus number/identifier
     * @param ac - AC availability (true/false)
     * @param cap - Passenger capacity
     */
    Bus(int no, boolean ac, int cap) {
        this.busNo=no;      // Initialize bus number
        this.ac=ac;         // Initialize AC status
        this.capacity=cap;  // Initialize capacity
    }

    /**
     * Getter method to retrieve bus capacity
     * @return capacity - Current capacity of the bus
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * Setter method to update bus capacity
     * @param cap - New capacity value to set
     */
    public void setCapacity(int cap){
        capacity=cap;
    }

    /**
     * Getter method to retrieve bus number
     * @return busNo - The bus identification number
     */
    public int getBusNo() {
        return busNo;
    }
}
