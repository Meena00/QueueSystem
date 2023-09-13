public class ReturningItems extends Request {
    private String[] itemsToReturn;

    public ReturningItems(String description, int priority, int difficulty, String[] itemsToReturn) {
    	super(description, priority, difficulty);
        this.itemsToReturn = itemsToReturn; //Set itemsToReturn
        this.setStatus(Status.NEW); //Set status of request to NEW
    }
    
    //Getter for itemsToReturn
    public String[] getItemsToReturn() {
        return itemsToReturn;
    }

    public void setItemsToReturn(String[] itemsToReturn) {
        this.itemsToReturn = itemsToReturn;
    }
    //Return the number of items in the itemsToReturn array
    @Override
    public int getNumberOfItems() {
        return itemsToReturn.length;
    }
    //overrides number of questions 
    @Override
    public int getNumberOfQuestions() {
        return 0;
    }
}
