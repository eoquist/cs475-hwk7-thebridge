/**
 * Description here
 */
public class OneLaneBridge extends Bridge {
    protected int max_capacity;
    private Object monitor = new Object();

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
        synchronized(monitor){
            boolean space_on_bridge = this.bridge.size() < this.max_capacity;
            boolean car_matches_direction = (car.getDirection() == this.direction);

            if (space_on_bridge && car_matches_direction) {
                car.setEntryTime(this.currentTime);
                this.bridge.add(car);
                System.out.println(this.bridge.toString());
                this.currentTime++;
            } else {
                // car must wait
                monitor.wait();
            }
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
        synchronized(monitor){
            boolean space_on_bridge = this.bridge.size() < this.max_capacity;
            boolean car_matches_direction = (car.getDirection() == this.direction);
            boolean car_is_first = (this.bridge.get(0) == car); // idk if this actually works lol

            if (space_on_bridge && car_matches_direction && car_is_first && !this.bridge.isEmpty()) {
                this.bridge.remove(0);
                System.out.println(this.bridge.toString());

                // signal to other cars that might be waiting to get on the bridge
                if(this.bridge.isEmpty()){
                    this.direction = !this.direction;
                }
                monitor.notifyAll();
            } else{
                monitor.wait();
            }
        }
    }


    /**
     * Print function for the OneLaneBridge class.
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