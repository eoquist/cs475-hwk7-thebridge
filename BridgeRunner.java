/**
 * Runs all threads
 */

public class BridgeRunner {
	// Purely for testing purposes
	private int test_val = 0;

	public static void main(String[] args) {
		int bridge_limit;
		int num_cars;

		if (args.length != 2) {
			System.out.println("Usage: javac BridgeRunner <bridge limit> <num cars>");
			return;
		} else if (Integer.parseInt(args[0]) <= 0 || Integer.parseInt(args[1]) <= 0) {
			System.out.println("Error: bridge limit and/or num cars must be positive.");
			return;
		} else {
			bridge_limit = Integer.parseInt(args[0]);
			num_cars = Integer.parseInt(args[1]);
		}

		// instantiate the bridge
		OneLaneBridge bridge = new OneLaneBridge(bridge_limit);

		// ----- ----- ----- ----- -----
		Thread[] threads = new Thread[num_cars];
		for (int i = 0; i < num_cars; i++) {
			// Creating Thread objects -- need to encapsulate a Runnable object
			int car_id = i;
			threads[i] = new Thread(new Car(car_id, bridge));

			threads[i].start();
		}

		for (int i = 0; i < num_cars; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// ----- ----- ----- ----- -----

		System.out.println("All cars have crossed!!");
	}

	// ======================================================================================

	public synchronized void inc() {
		// do stuff with Counter object locked
		test_val++;
		// unlock right before leaving method
	}

	// You can use a synchronized block if only a critical section of code within
	// the method needs locked.
	// synchronized(objectToLockUp){
	// // acquires intrinsic lock on objectToLockUp
	// // releases lock after you leave the block
	// }

	// Three operations (API for Object class):
	// • wait() - Block until another thread calls notify() or notifyAll()
	// - Calling this releases the monitor lock and sleeps atomically!
	// • notify() - Wake up one thread that's waiting
	// • notifyAll() - Wake up all threads that's waiting
	// Important: You must throw a synchronized block around these calls, or these
	// calls must occur in a synchronized method.

}