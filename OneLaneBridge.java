/**
 * Description here
 */
public class OneLaneBridge extends Bridge {
    protected int max_capacity;

    /**
     * Default Constructor for OneLaneBridge
     */
    public OneLaneBridge() {
        super();
    }

    /**
     * Constructor for OneLaneBridge
     * 
     * @param
     */
    public OneLaneBridge(int num) {
        super();
        this.max_capacity = num;
    }

    /**
     * Determines whether the thread which called it must wait, or
     * if the car is allowed to proceed on to the bridge.
     * 
     * @param car the arriving car
     * @throws InterruptedException if the thread is interrupted
     */
    @Override
    public void arrive(Car car) throws InterruptedException {
        boolean space_on_bridge = this.bridge.size() < this.max_capacity;
        boolean car_matches_direction = (car.getDirection() == this.direction);

        if (space_on_bridge && car_matches_direction) {
            // TODO - OneLaneBridge arrive()
            car.setEntryTime(this.currentTime);
            this.bridge.add(car);
            System.out.println(this.bridge.toString());
            this.currentTime++;
        } else {
            // car must wait
            car.wait();
        }
    }

    /**
     * Handles the exit of a car leaving the bridge.
     * 
     * @param car the exiting car
     * @throws InterruptedException if the thread is interrupted
     */
    @Override
    public void exit(Car car) throws InterruptedException {
        boolean space_on_bridge = this.bridge.size() < this.max_capacity;
        boolean car_matches_direction = (car.getDirection() == this.direction);
        boolean car_is_first = (this.bridge.get(0) == car); // idk if this actually works lol

        if (space_on_bridge && car_matches_direction && car_is_first) {
            // TODO - OneLaneBridge exit()
            this.bridge.remove(0);
            System.out.println(this.bridge.toString());
            // signal to other cars that might be waiting to get on the bridge

        } else{
            
        }

        // This Bridge method is called by a car when it wants to exit the bridge. But
        // any car can call this method at any time, so we have to put in some “guard
        // rails” to make sure that a car on the bridge can’t just randomly disappear
        // off the bridge when there are still cars in front of it.

    }

    // TODO - check outputs section of notes

    /**
     * TPrint function for the OneLaneBridge class.
     * @return string representation of OneLaneBridge
     */
    @Override
    public String toString() {
        String print_str = "Bridge (dir=" + this.direction + "):";
        for(Car car : this.bridge){
            print_str += car.toString();
        }
        return print_str;
    }

}