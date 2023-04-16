/**
 * Runs all threads
 */

public class BridgeRunner {

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
	
	// Three operations (API for Object class):
	// • wait() - Block until another thread calls notify() or notifyAll()
	// - Calling this releases the monitor lock and sleeps atomically!
	// • notify() - Wake up one thread that's waiting
	// • notifyAll() - Wake up all threads that's waiting

}