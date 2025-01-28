import java.util.ArrayList;

/**
 * This class contains methods which perform various operations on a layered linked
 * list to simulate transit
 * 
 * @author Ishaan Ivaturi
 * @author Prince Rawal
 * @author Kobe Martinez
 */
public class Transit {
	/**
	 * Makes a layered linked list representing the given arrays of train stations, bus
	 * stops, and walking locations. Each layer begins with a location of 0, even though
	 * the arrays don't contain the value 0.
	 * 
	 * @param trainStations Int array listing all the train stations
	 * @param busStops Int array listing all the bus stops
	 * @param locations Int array listing all the walking locations (always increments by 1)
	 * @return The zero node in the train layer of the final layered linked list
	 */
	public static TNode makeList(int[] trainStations, int[] busStops, int[] locations) {
		// WRITE YOUR CODE HERE	
		TNode head = new TNode();
		TNode head2 = new TNode();
		TNode head3 = new TNode();

		if(head.location == head2.location || head.location == head3.location){
			head.down = head2;
			head.down.down = head3;
		}

		

		TNode tmp = head;
		TNode prt = head2;
		TNode prt2 = head3;
		
		//adding train to L1
		for (int k = 0; k < trainStations.length; k++){
			tmp.next = new TNode(trainStations[k]);
			tmp = tmp.next;
		}
	
			
			for (int l = 0; l < busStops.length; l++){
				prt.next = new TNode(busStops[l]);
				prt = prt.next;
			}
			
			
				//adding walk to L3
				
				for (int m = 0; m < locations.length; m++){
					prt2.next = new TNode(locations[m]);
					prt2 = prt2.next;
				}
				
				
				
				//Train to Bus & Bus to Walk
		TNode x = head;
		TNode w = head2;
		while(x != null){

			if(w.location == x.location){
				x.down = w;
				x = x.next;
			}
			else{
				w = w.next;
			}
		}
		
		TNode y = head2;
		TNode z = head3;
		
		while(y != null){

			if(z.location == y.location){
				y.down = z;
				y = y.next;
			}
			else{
				z = z.next;
			}
		}
				
		return head;
	}

	
	
		/**
	 * Modifies the given layered list to remove the given train station but NOT its associated
	 * bus stop or walking location. Do nothing if the train station doesn't exist
	 * 
	 * @param trainZero The zero node in the train layer of the given layered list
	 * @param station The location of the train station to remove
	 */
	public static void removeTrainStation(TNode trainZero, int station) {
		// WRITE YOUR CODE HERE
		TNode ptr = trainZero;
		TNode node = null;
		 
		

		if(ptr != null && ptr.location == station){
			trainZero = ptr.next;
		}
		while(ptr != null && ptr.location != station){
			node = ptr;
			ptr = ptr.next;
		}
		if(station == 0){ 
			return;
		}
		if(ptr == null){
			return;
		}
		node.next = ptr.next;

	}

	/**
	 * Modifies the given layered list to add a new bus stop at the specified location. Do nothing
	 * if there is no corresponding walking location.
	 * 
	 * @param trainZero The zero node in the train layer of the given layered list
	 * @param busStop The location of the bus stop to add
	 */
	public static void addBusStop(TNode trainZero, int busStop) {
		// WRITE YOUR CODE HERE
		TNode ptr = trainZero.down;
		//TNode ptr2 = trainZero.down.down;
		TNode node = null;
		TNode item = new TNode();
		item.location = busStop;
		//TNode ptr2 = trainZero.down.down;

		
		
		while(ptr != null && ptr.location < busStop ){
			
			
			
			node = ptr;
			ptr = ptr.next;
			
		}
		if(ptr == null){
			return;
		}
		if(ptr.location == busStop){
			return;
		}
		node.next = item;
		item.next = ptr;
		

		//Train to Bus & Bus to Walk
		TNode x = trainZero;
		TNode w = trainZero.down;
		while(x != null){

			if(w.location == x.location){
				x.down = w;
				x = x.next;
			}
			else{
				w = w.next;
			}
		}
		
		TNode y = trainZero.down;
		TNode z = trainZero.down.down;
		
		while(y != null){

			if(z.location == y.location){
				y.down = z;
				y = y.next;
			}
			else{
				z = z.next;
			}
		}

		

	
	}
	
	/**
	 * Determines the optimal path to get to a given destination in the walking layer, and 
	 * collects all the nodes which are visited in this path into an arraylist. 
	 * 
	 * @param trainZero The zero node in the train layer of the given layered list
	 * @param destination An int representing the destination
	 * @return
	 */
	public static ArrayList<TNode> bestPath(TNode trainZero, int destination) {
		// WRITE YOUR CODE HERE
		ArrayList<TNode> path = new ArrayList<TNode>();
		TNode tmp = trainZero;
		path.add(tmp);
		//TNode tmp2 = trainZero.down;
		//TNode tmp3 = trainZero.down.down;
		
		while(tmp.next != null && tmp.next.location <= destination ){
			tmp = tmp.next;
			path.add(tmp);
		}
		if(tmp.location <= destination){
			tmp = tmp.down;
			path.add(tmp);
		}

		while(tmp.next != null && tmp.next.location <= destination){
				tmp = tmp.next;
				path.add(tmp);
		}
		if(tmp.location <= destination){
			tmp = tmp.down;
			path.add(tmp);
		}
		while(tmp.next != null && tmp.next.location <= destination){
			tmp = tmp.next;
			path.add(tmp);
	}
		
		
		

		return path;
	}

	/**
	 * Returns a deep copy of the given layered list, which contains exactly the same
	 * locations and connections, but every node is a NEW node.
	 * 
	 * @param trainZero The zero node in the train layer of the given layered list
	 * @return
	 */
	public static TNode duplicate(TNode trainZero) {
		// WRITE YOUR CODE HERE
		int trainLength = length(trainZero);
		int busLength = length(trainZero.down);
		int walkingLength = length(trainZero.down.down);

		
		int[] trains = new int[trainLength];
		int[] buses = new int[busLength];
		int[] walks = new int[walkingLength];

		int trainID = 0;
		TNode tmp = trainZero;
		while(tmp != null){
			trains[trainID++] = tmp.location;
			tmp = tmp.next;
		}
		int busID = 0;
		TNode tmp1 = trainZero.down;
		while(tmp1 != null){
			buses[busID++] = tmp1.location;
			tmp1 = tmp1.next;
		}
		int walkID = 0;
		TNode tmp2 = trainZero.down.down;
		while(tmp2 != null){
			walks[walkID++] = tmp2.location;
			tmp2 = tmp2.next;
		}
		
		//adding train to DL1
		TNode head = new TNode();
		TNode ref = head;
		
		for (int i = 1; i < trains.length; i++){
			ref.next = new TNode(trains[i],null,null);
			ref = ref.next;
		}
		//adding bus to DL2
		TNode head2 = new TNode();
		head.down = head2;
		TNode ref2 = head.down;
		
		for (int i = 1; i < buses.length; i++){
			ref2.next = new TNode(buses[i],null,null);
			ref2 = ref2.next;
		}
		//adding walk to DL3
		TNode head3 = new TNode();
		head.down.down = head3;
		TNode ref3 = head.down.down;
		
		for (int i = 1; i < walks.length; i++){
			ref3.next = new TNode(walks[i],null,null);
			ref3 = ref3.next;
		}

		
		
		//Train to Bus & Bus to Walk
		TNode x = head;
		TNode w = head.down;
		while(x != null){

			if(w.location == x.location){
				x.down = w;
				x = x.next;
			}
			else{
				w = w.next;
			}
		}
		
		TNode y = head.down;
		TNode z = head.down.down;
		
		while(y != null){

			if(z.location == y.location){
				y.down = z;
				y = y.next;
			}
			else{
				z = z.next;
			}
		}
		

		return head;
	}
private static int length(TNode trainZero){
	TNode train = trainZero;
	int ptr = trainZero.location;
	while(train != null){
		ptr++;
		train = train.next;

	}
	return ptr;

}
	/**
	 * Modifies the given layered list to add a scooter layer in between the bus and
	 * walking layer.
	 * 
	 * @param trainZero The zero node in the train layer of the given layered list
	 * @param scooterStops An int array representing where the scooter stops are located
	 */
	public static void addScooter(TNode trainZero, int[] scooterStops) {
		// WRITE YOUR CODE HERE
		TNode head = trainZero;
		TNode item = new TNode();
		TNode item2 = trainZero.down.down;

		//equal to new 0
		head = item;

		//value before added 0
		
		item2.down = head;
		item2.down.next = item2.next;

		for (int m = 0; m < scooterStops.length; m++){
			item2.next = new TNode(scooterStops[m],null,null);
			item2 = item2.next;
		}
		
		//Train to Bus & Bus to Walk
		TNode x = trainZero.down;
		TNode w = trainZero.down.down;
		while(x != null){

			if(w.location == x.location){
				x.down = w;
				x = x.next;
			}
			else{
				w = w.next;
			}
		}
		
		TNode y = trainZero.down.down;
		TNode z = trainZero.down.down.down;
		
		while(y != null){

			if(z.location == y.location){
				y.down = z;
				y = y.next;
			}
			else{
				z = z.next;
			}
		}
		
		
		



	}
}