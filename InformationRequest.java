public class InformationRequest extends Request {
    private String[] questions;

    public InformationRequest(String description, int priority, int difficulty, String[] questions) {
        super(description, difficulty, 1);
        this.questions = questions;
        this.setStatus(Status.NEW);
        this.setPriority(priority);
    }
    //Getter method for questions
    
    public String[] getQuestions() {
        return questions;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }
    //Method that returns the number of items
    @Override
    public int getNumberOfItems() {
        return 0;
    }

    @Override
    public int getNumberOfQuestions() {
        return questions.length;
    }
    //Method that calculates the processing time for this request based on difficulty, factor, and number of questions
    @Override
    public int calculateProcessingTime() {
        return this.getDifficulty() * this.getFactor() * this.getNumberOfQuestions();
    }
}
