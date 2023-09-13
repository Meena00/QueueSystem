import java.util.Arrays;

public class QueueSystem {
    private int clock;
    private int totalWaitingTime;
    private Client[] clientsWorld;
    private int totalClientsInSystem;
    private int waitingLineSize;
    private Client[] waitingLine;
    private boolean tvInWaitingArea;
    private boolean coffeeInWaitingArea;
    private Queue[] queues;

    public QueueSystem(int waitingLineSize, boolean tvInWaitingArea, boolean coffeeInWaitingArea) {
        this.clock = 0;
        this.totalWaitingTime = 0;
        this.clientsWorld = new Client[0];
        this.totalClientsInSystem = 0;
        this.waitingLineSize = waitingLineSize;
        this.waitingLine = new Client[waitingLineSize];
        this.tvInWaitingArea = tvInWaitingArea;
        this.coffeeInWaitingArea = coffeeInWaitingArea;
        this.queues = new Queue[4];
        for (int i = 0; i < 4; i++) {
            this.queues[i] = new Queue(i + 1);
        }
        if (tvInWaitingArea) {
            for (Client c : waitingLine) {
                c.setPatience(c.getPatience() + 20);
            }
        }
        if (coffeeInWaitingArea) {
            for (Client c : waitingLine) {
                if (c instanceof Client) {
                    c.setPatience(c.getPatience() + 15);
                }
            }
        }
    }

    public void increaseTime() {
        this.clock++;
        for (int i = 0; i < 4; i++) {
            Queue queue = this.queues[i];
            if (!queue.isEmpty()) {
                Client Client = queue.Client();
                Request Request = getRequest();
                if (Request.getStartTime() == -1) {
                    Request.setStartTime(this.clock);
                }
                if (this.clock - Request.getStartTime() >= Request.getStartTime()) {
                    queue.dequeue();
                    if (queue.size() == 1) {
                        this.totalWaitingTime += this.clock - Client.getArrivalTime();
                    }
                    this.totalClientsInSystem--;
                    this.clientsWorld = Arrays.copyOfRange(this.clientsWorld, 1, this.clientsWorld.length);
                }
            }
        }
        for (int i = 0; i < this.waitingLineSize; i++) {
            Client client = this.waitingLine[i];
            if (client != null) {
                Request Request = Request.getRequest(); // im trying to get the request class to increment getStart Time
                if (Request != null && Request.getStartTime() == -1) {
                    Request.setStartTime(this.clock);
                }
                if (client.getPatience() <= this.clock - client.getArrivalTime()) {
                    this.waitingLine[i] = null;
                    this.totalClientsInSystem--;
                    this.clientsWorld = Arrays.copyOfRange(this.clientsWorld, 1, this.clientsWorld.length);
                }
            }
        }
    }

    public int getClock() {
        return this.clock;
    }

    public int getTotalWaitingTime() {
        return this.totalWaitingTime;
    }

    public int getTotalClientsInSystem() {
        return this.totalClientsInSystem;
    }

    public int getWaitingLineSize() {
        return this.waitingLineSize;
    }

    public Client[] getWaitingLine() {
        return this.waitingLine;
    }

    public boolean isTvInWaitingArea() {
        return this.tvInWaitingArea;
    }

    public boolean isCoffeeInWaitingArea() {
        return this.coffeeInWaitingArea;
    }
}