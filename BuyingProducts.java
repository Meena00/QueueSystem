public class BuyingProducts extends Request {
    private String[] itemsToBuy;

    public BuyingProducts(String description, int priority, int difficulty, String[] itemsToBuy) {
        super(description, priority, difficulty);
        this.itemsToBuy = itemsToBuy;
        this.setStatus(Status.NEW);
    }

    public String[] getItemsToBuy() {
        return itemsToBuy;
    }

    public void setItemsToBuy(String[] itemsToBuy) {
        this.itemsToBuy = itemsToBuy;
    }

    @Override
    public int getNumberOfItems() {
        return itemsToBuy.length;
    }

    @Override
    public int getNumberOfQuestions() {
        return 0;
    }
}
