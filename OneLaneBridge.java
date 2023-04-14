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
     * 
     * @param car the arriving car
     * @throws InterruptedException if the thread is interrupted
     */
    @Override
    public void arrive(Car car) throws InterruptedException {
        // TODO - OneLaneBridge arrive()

        // check the direction of the bridge
        // check if the bridge has space
        // if the arriving car matches the direction of the bridge and there is space for the car, allow the car to enter
        // if it doesn't then the car must wait

        // This method has to determine whether the thread which called it must wait, or
        // is allowed to proceed on to the bridge. Specifically, a car can’t enter the
        // bridge when there are too many cars on it or if it’s going against the
        // current flow of traffic. When the car is allowed to enter the bridge, use the
        // car’s setEntryTime(currentTime) method to set the entry time. Add the car to
        // the bridge list. Then print the bridge list so we can see (and ensure) that
        // there are no more than 3 cars on the bridge. Finally, increment currentTime
        // by 1.

        // OUTPUT: shows bridge’s current allowed direction, followed by the list of
        // cars currently on the bridge.
    }

    /**
     * Handles the exit of a car leaving the bridge.
     * 
     * @param car the exiting car
     * @throws InterruptedException if the thread is interrupted
     */
    @Override
    public void exit(Car car) throws InterruptedException {
        // TODO - OneLaneBridge exit()

        // This Bridge method is called by a car when it wants to exit the bridge. But
        // any car can call this method at any time, so we have to put in some “guard
        // rails” to make sure that a car on the bridge can’t just randomly disappear
        // off the bridge when there are still cars in front of it.

        // When it’s the car’s turn to exit the bridge, remove the car from the list.
        // Then print the bridge list so that we can see there’s one fewer car (and the
        // car that left had better been at the head of the list!). When a car leaves,
        // signal to other cars that might be waiting to get on the bridge. Do not
        // change currentTime when exiting.

        // OUTPUT: shows bridge’s current allowed direction, followed by the list of
        // cars currently on the bridge.

    }

    // TODO - check outputs section of notes

    /**
     * This feels wrong
     * 
     * @return string representation of OneLaneBridge
     */
    @Override
    public String toString() {
        return "Bridge (dir=" + this.direction + "):";
    }

}