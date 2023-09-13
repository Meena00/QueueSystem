	public class Client {
	private int id;
	private String firstName;
	private String lastName;
	private int arrivalTime;
	private int waitingTime;
	private int timeInQueue;
	private int serviceTime;
	private int departureTime;
	private char serverID;
	private int Patience;
	
	
	private static int nextId = 0; //static variable to keep track of next available client ID
	
	public Client(String firstName, String lastName, int arrivalTime) { 
		
	    this.id = nextId++;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.arrivalTime = arrivalTime;
	    this.waitingTime = 0;
	    this.timeInQueue = 0;
	    this.serviceTime = 0;
	    this.departureTime = 0;
	    this.serverID = '-';
	}
	public Client() {
	}
	// getters and setters for all private fields
	public int getClientID() {
	    return id;
	}

	
	public int getId() {
	    return id;
	}
	
	public String getFirstName() {
	    return firstName;
	}
	
	public void setFirstName(String firstName) {
	    this.firstName = firstName;
	}
	
	public String getLastName() {
	    return lastName;
	}
	
	public void setLastName(String lastName) {
	    this.lastName = lastName;
	}
	
	public int getArrivalTime() {
	    return arrivalTime;
	}
	
	public void setArrivalTime(int arrivalTime) {
	    this.arrivalTime = arrivalTime;
	}
	
	public int getWaitingTime() {
	    return waitingTime;
	}
	
	public void setWaitingTime(int waitingTime) {
	    this.waitingTime = waitingTime;
	}
	
	public int getTimeInQueue() {
	    return timeInQueue;
	}
	
	public void setTimeInQueue(int timeInQueue) {
	    this.timeInQueue = timeInQueue;
	}
	
	public int getServiceTime() {
	    return serviceTime;
	}
	
	public void setServiceTime(int serviceTime) {
	    this.serviceTime = serviceTime;
	}
	
	public int getDepartureTime() {
	    return departureTime;
	}
	
	public void setDepartureTime(int departureTime) {
	    this.departureTime = departureTime;
	}
	
	public char getServerID() {
	    return serverID;
	}
	
	public void setServerID(char serverID) {
	    this.serverID = serverID;
	}
	// This method calculates the service level for the client
	// based on their waiting time and time spent in the queue
	// The service level is calculated on a scale of 0 to 10, where
	// 0 is the lowest possible service level and 10 is the highest.
	// The method returns the calculated service level.
	public int estimateServiceLevel() {
	    if (serverID == '-') {
	        return -1;
	    }
	
	    int maxPoints = 10;
	    if (waitingTime > 4) {
	        maxPoints--;
	    }
	    if (waitingTime > 6) {
	        maxPoints--;
	    }
	    if (waitingTime > 8) {
	        maxPoints--;
	    }
	    if (waitingTime > 10) {
	        maxPoints--;
	    }
	    if (waitingTime > 12) {
	        maxPoints--;
	    }
	    if (timeInQueue > 4) {
	        maxPoints--;
	    }
	    if (timeInQueue > 6) {
	        maxPoints--;
	    }
	    if (timeInQueue > 8) {
	        maxPoints--;
	    }
	    if (timeInQueue > 10) {
	        maxPoints--;
	    }
	    if (timeInQueue > 12) {
	        maxPoints--;
	    }
	
	    return maxPoints;
	}
	//
	public String toString() {
	    return "Client: " + lastName + ", " + firstName + "\n" +
	           "** Arrival Time : " + arrivalTime + "\n" +
	           "** Waiting Time : " + waitingTime + "\n" +
	           "** Time In Queue : " + timeInQueue + "\n" +
	           "** Service Time : " + serviceTime + "\n" +
	           "** Departure Time : " + departureTime + "\n" +
	           "** Served By Server: " + serverID + "\n" +
	           "** Service Level : " + estimateServiceLevel();
	}
	public void increasePatience(int i) {
		
	}
	public int getPatience() {
	    return Patience;
	}
	
	public void setPatience(int Patience) {
	    this.Patience = Patience;
	}
	}
