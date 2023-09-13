public class VIPClient extends Client implements Prioritizable {
    private int memberSince;
    private int priority;

    public VIPClient (String firstName, String lastName, int birthYear,String gender,
    		int arrivalTime,int patience, Request[] requests, int memberSince, int priority) {
        super();
        this.memberSince = memberSince;
        this.priority = priority;
    }

    public int getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(int memberSince) {
        this.memberSince = memberSince;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        String clientInfo = super.toString();
        String vipInfo = String.format("** VIP since : %d\n** priority : %d", memberSince, priority);
        return clientInfo + vipInfo;
    }
}
