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
     * Handles the arrival of a car to the bridge.
     * @param car the arriving car
     * @throws InterruptedException if the thread is interrupted
     */
    @Override
    public void arrive(Car car) throws InterruptedException {
        // TODO
    }

    /**
     * Handles the exit of a car leaving the bridge.
     * @param car the exiting car
     * @throws InterruptedException if the thread is interrupted
     */
    @Override
    public void exit(Car car) throws InterruptedException {
        // TODO
    }

}