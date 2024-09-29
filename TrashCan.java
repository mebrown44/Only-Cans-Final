import java.util.*;
import java.io.*;

public class TrashCan {
    private String trashCanId;
    private static int ID = 0;
    private double[] loc;
    private ArrayList<Populate> descriptions;
    //to track the users reporting a specific trash can
    private List<Integer> reportedUsers;  
    //to track fullness values of the trash cans reported by the users
    private List<Double> fullnessValues;  

    //constructor to initialize TrashCan object with a id and location
    public TrashCan() {
        ID++;

        trashCanId = "Trash Can #";
        if(descriptions.get(ID).recycle)
            trashCanId = "Recycling Bin #";

        for(int i = 0; i < descriptions.size(); i++){
            if(i < 1000)
                trashCanId += "0";

            if(i < 100)
                trashCanId += "0";

            if(i < 10)
                trashCanId += "0";
        }
        this.trashCanId += ID;
        

        loc = new double[2];
        loc[0] = descriptions.get(ID).longitude;
        loc[1] = descriptions.get(ID).latitude;

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
    public String getTrashCanId() {
        return trashCanId;
    }

    public String getImageName(){
        return "Trash Cans/" + descriptions.get(ID).image;
    }

    public boolean getRecycle(){
        return descriptions.get(ID).recycle;
    }

    public String getLocation() {
        return "(" + loc[0] + ", " + loc[1] + ")";
    } 


    private class Populate{
        private double longitude;
        private double latitude;
        private String image;
        private boolean recycle;

        private Populate(){
            String fileName = "TrashFile.txt";

                Scanner inFile = null;

                try{
                    inFile = new Scanner(new File(fileName));
                }catch(FileNotFoundException e) {
                    System.exit(-1);
                }

                while(inFile.hasNextLine()){
                    longitude = inFile.nextDouble();
                    latitude = inFile.nextDouble();
                    image = inFile.nextLine();
                    
                    String temp = inFile.nextLine();
                    if(temp.equals("T"))
                        recycle = true;
                    else
                        recycle = false;

                    inFile.nextLine();

                }
        }

    }
}
