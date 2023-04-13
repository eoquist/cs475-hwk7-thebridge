/**
 * Runs all threads
 */

public class BridgeRunner {

	public static void main(String[] args) {
		// check command line inputs
		int bridge_limit;
		int num_cars;
		if (args.length != 2) {
            System.out.println("Usage: javac BridgeRunner <bridge limit> <num cars>");
            return;
        } else{
			bridge_limit = Integer.parseInt(args[0]);
			num_cars = Integer.parseInt(args[1]);
		}

		// instantiate the bridge
		OneLaneBridge bridge = new OneLaneBridge(bridge_limit);

		// TODO - allocate space for threads

		// TODO - start then join the threads

		System.out.println("All cars have crossed!!");
	}

}