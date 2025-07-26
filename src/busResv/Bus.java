package busResv;


public class Bus {
    private int busNo;
    private boolean ac;
    private int capacity;

    Bus(int no, boolean ac, int cap) {
        this.busNo=no;
        this.ac=ac;
        this.capacity=cap;
    }

    //getter
    public int getCapacity(){
        return capacity;
    }

    //setter
    public void setCapacity(int cap){
        capacity=cap;
    }

    //Display

    public int getBusNo() {
        return busNo;
    }
}
