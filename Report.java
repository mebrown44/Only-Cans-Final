public class Report {
    private int trashCanId;
    private int userId;
    //fullness value provided by the user (1 to 5)
    private double fullnessValue;  

    //constuctor for initializing an Report object
    public Report(int trashCanId, int userId, double fullnessValue) {
        this.trashCanId = trashCanId;
        this.userId = userId;
        this.fullnessValue = fullnessValue;
    }

    //getters
    public double getFullnessValue() {
        return fullnessValue;
    }

    public int getTrashCanId() {
        return trashCanId;
    }

    public int getUserId() {
        return userId;
    }
}
