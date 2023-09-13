public class Queue {
    private int size;
    private Client[] clients;
    private int numClients;
    private Client[] clientsInQueue;

    public Queue(int size) {
        this.size = size;
        clients = new Client[size];
        numClients = 0;
        clientsInQueue = new Client[size - 1];
    }

    public boolean isEmpty() {
        return (clients[0] == null);
    }

    public boolean isFull() {
        return (clients[size - 1] != null);
    }
    
    //adds a new Client object to the queue
    public boolean enqueue(Client client) {
        if (isFull()) {
            return false;
        } else {
            int i = 0;
            while (clients[i] != null) {
                i++;
            }
            clients[i] = client;
            numClients++;
            if (numClients > 1) {
                for (int j = 0; j < numClients - 1; j++) {
                    clientsInQueue[j] = clients[j + 1];
                }
            }
            return true;
        }
    }
    //removes and returns the first Client object in the queue.

    public Client dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            Client client = clients[0];
            for (int i = 0; i < size - 1; i++) {
                clients[i] = clients[i + 1];
            }
            clients[size - 1] = null;
            numClients--;
            if (numClients > 0) {
                for (int j = 0; j < numClients; j++) {
                    clientsInQueue[j] = clients[j + 1];
                }
            }
            return client;
        }
    }

    public int size() {
        return numClients;
    }
    //returns a string representation of the queue.
    public String toString() {
        String queueAsString = "";
        for (int i = 0; i < numClients; i++) {
            queueAsString += "[";
            queueAsString += clientsInQueue[i].getClientID();
            queueAsString += "]";
        }
        return queueAsString;
    }

	public Client Client() {
		
		return null;
	}
}
