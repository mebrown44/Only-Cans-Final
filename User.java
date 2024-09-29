public class User {
    private int userId;
    private String name;
    private String email;

    //constructor for initializing a User object
    public User(int userId, String name, String email) {
        this.userId = userId; //Do we need this
        this.name = name;
        this.email = email;
    }

    //method for a user to submit a report about a trash can
    public Report submitReport(TrashCan trashCan, int userId, double fullnessValue) {
        return new Report(trashCan.getTrashCanId(), this.userId, fullnessValue);
    }

    //getter
    public int getUserId() {
        return userId;
    }
}
