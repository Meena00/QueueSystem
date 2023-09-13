public class VIPQueue {
    private String serverName;
    private int queueSize;
    private boolean acceptingAnyClients;
    private Queue VIPQueue;

    public VIPQueue(String serverName, int queueSize, boolean acceptAnyClients) {
        this.serverName = serverName;
        this.queueSize = queueSize;
        this.acceptingAnyClients = acceptAnyClients;
        this.VIPQueue = new Queue(queueSize);
    }

    public VIPQueue(String serverName, int queueSize) {
        this(serverName, queueSize, false);
    }

    public boolean isAcceptingAnyClients() {
        return acceptingAnyClients;
    }
    
    // Sets the value of acceptingAnyClients
    public void setAcceptingAnyClients(boolean acceptingAnyClients) {
        this.acceptingAnyClients = acceptingAnyClients;
    }

    public Queue getQueue() {
        return this.VIPQueue;
    }
    // Sets the VIPQueue object to the specified Queue object
    public void setQueue(Queue queue) {
        this.VIPQueue = queue;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }
}
