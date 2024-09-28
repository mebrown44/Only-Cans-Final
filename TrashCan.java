import java.util.ArrayList;
import java.util.List;
public class TrashCan {
    private int trashCanId;
    private String location;
    private List<Integer> fullCapacity
    private List<Integer> moderateCapacity;
    private List<Integer> emptyCapacity;
    //reportedUsers to track users reporting a trash can
    private List<Integer> reportedUsers;
    private String currentStatus;

    //constructor to initalize a TrashCan object with an ID and location
    public TrashCan(int trashCanId, String location){
        this.trashCanId = trashCanId;
        this.location = location;
        this.fullCapacity = new ArrayList<>();
        this.moderateCapacity = new ArrayList<>();
        this.emptyCapacity = new ArrayList<>();
        this.reportedUsers = new ArrayList<>();
        //default status is empty for the trash can
        this.currentStatus = "Empty";
    }

    //method to update the fullness status of the trash can based on the users reportings
    public void updateStatus(String fullnessStatus){
        //marking trash can as full and adding it to Array List of full trash cans
        if(fullnessStatus.equals("full")){
            fullCapacity.add(trashCanId);
            currentStatus = "full";
        }
        //marking trash can as moderately full and adding it to Array List of moderately full trash cans
        else if(fullnessStatus.equals("moderate")){
            moderateCapacity.add(trashCanId);
            currentStatus = "moderate";
        }
        //marking trash can as empty and adding it to Array List of empty trash cans
        else{
            emptyCapacity.add(trashCanId);
            currentStatus = "empty";
        }
    }
    
}
