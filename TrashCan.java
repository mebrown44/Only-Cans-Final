import java.util.ArrayList;
import java.util.List;

public class TrashCan {
    private int trashCanId;
    private String location;
    //to track the users reporting a specific trash can
    private List<Integer> reportedUsers;  
    //to track fullness values of the trash cans reported by the users
    private List<Double> fullnessValues;  

    //constructor to initialize TrashCan object with a id and location
    public TrashCan(int trashCanId, String location) {
        this.trashCanId = trashCanId;
        this.location = location;
        this.reportedUsers = new ArrayList<>();
        //initialize a empty list for fullness values
        this.fullnessValues = new ArrayList<>();  
    }

    //adding a user's fullness report (from a scale of 1 to 5) to the trash can
    public void addFullnessReport(int userId, double fullnessValue) {
        //only adding the user if they haven't already reported for this trash can
        if (!reportedUsers.contains(userId)) {
            //adding the user to the list of reported users
            reportedUsers.add(userId); 
            //adding fullness value to the list
            fullnessValues.add(fullnessValue);  
        }
    }

    //calculating average fullness of the trash can
    public double getAverageFullness() {
        double total = 0;
        for (double value : fullnessValues) {
            total += value;
        }
        return total / fullnessValues.size();  
    }

    //checking if more than 2 users have reported and if the average fullness is more than or equal to 4.5
    public boolean shouldSendNotification() {
        return reportedUsers.size() > 2 && getAverageFullness() >= 4.5;
    }

    //resetting the trash can status once it's emptied
    public void markEmpty() {  
        reportedUsers.clear();  //clearing the user's reports
        fullnessValues.clear();  //clearing the fullness values for the trash can
    }

    //getters
    public int getTrashCanId() {
        return trashCanId;
    }

    public String getLocation() {
        return location;
    }
}