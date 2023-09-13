public abstract class Request implements Prioritizable {
	 private String description;
	    private int priority;
	    private int difficulty;
	    private int factor;
	    private int startTime;
	    private int endTime;
	    private int completionLevel;
	    private Status status;

    public Request(String description, int priority, int difficulty) {
        this.description = description;
        this.priority = priority;
        this.difficulty = difficulty;
        this.factor = 1;
        this.startTime = 0;
        this.endTime = 0;
        this.completionLevel = 0;
        this.status = Status.NEW;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getCompletionLevel() {
        return completionLevel;
    }

    public void setCompletionLevel(int completionLevel) {
        this.completionLevel = completionLevel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public abstract int getNumberOfItems();
    public abstract int getNumberOfQuestions();

    public int calculateProcessingTime() {
        int processingTime = 0;
        if (this instanceof InformationRequest) {
            processingTime = getDifficulty() * getFactor() * getNumberOfQuestions();
        } else if (this instanceof ReturningItems || this instanceof BuyingProducts) {  //  
            processingTime = getDifficulty() * getFactor() * getNumberOfItems();
        }
        return processingTime;
    }


}
